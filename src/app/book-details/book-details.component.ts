import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookServiceService } from '../services/book-service.service';
import { ServiceService } from '../service/service.service';
import { book } from '../models/book';
import { order } from '../models/order';
import { OrderService } from './order.service';
import { ReviewService } from './review.service';
import { review } from '../models/review';
import { user } from '../models/user';
import { DatePipe } from '@angular/common';
import { AvanceService } from './avance.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent {
  remaining: number = 0;
  comment!: string;
  order:order = {

    idOrder: 0,
    idUser: 0,
    idBook: 0,
    pickupDate: new Date,
    returnDate: new Date,
    orderStatus: ""


};
  review: review = {
    reviewId: 0,
    bookId: 0,
    userId: 0,
    comment: '',
    date: '',
    rating: 0
    };
  startDate: Date = new Date; // or some default value
  endDate: Date = new Date;
  productDetails!:book;
  idBook: number =0;
  reviews!: review[];

  constructor(private route: ActivatedRoute,private router: Router,private bookService:BookServiceService,private service:ServiceService, private orderService: OrderService, private reviewservice: ReviewService, private datepipe: DatePipe, private avanceservice: AvanceService) { }
  
  ngOnInit(): void {

    this.route.params.subscribe((params) => {
      this.idBook = params['productId'];
      this.bookService.get(this.idBook).subscribe((books: book) => {
        this.productDetails = books;
      })
      this.reviewservice.getallreviews(params['productId']).subscribe((review: review[]) => {
        this.reviews = review;
        console.log(this.reviews)
      })
      this.avanceservice.getRemainingDays(params['productId']).subscribe((remaining: any) => {
        console.log("avance: ", remaining.daysRemaining)
        if (typeof remaining.daysRemaining === 'number') {
          this.remaining = remaining.daysRemaining;
        }
        else this.remaining = 0;
      })
    })

  }
  Order(): void {
    this.order.idBook=this.productDetails.idBook;
    this.order.pickupDate=this.startDate;
    this.order.returnDate=this.endDate;
    this.order.idUser=1;
    this.order.orderStatus="PLACED"

    this.orderService.post(this.order).subscribe((order: order) => {
      console.log(order)
      this.router.navigate(["home"])
    })
  }
  addreview(): void {
    const userJsonString = localStorage.getItem("user");
    const user: user = userJsonString ? JSON.parse(userJsonString) : null;
    const userId: number | undefined = user?.idUser;
    this.review.bookId = this.idBook;
    this.review.userId = userId;
    this.review.comment = this.comment;
    console.log("test", this.review)
    this.reviewservice.post(this.review).subscribe((review: review) => {
      console.log(review)
    })
  }
}
