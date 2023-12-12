import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookServiceService } from '../services/book-service.service';
import { ServiceService } from '../service/service.service';
import { book } from '../models/book';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  bookList!: book[];

  constructor(private router: Router,private bookService:BookServiceService,private service:ServiceService) { }

  ngOnInit() {

    this.bookService.getallbooks().subscribe((books: book[]) => {
      this.bookList = books;
    })
  }

  goToDetails(productId:Number): void {
    // Navigate to the details page with the object ID as a parameter
    this.router.navigate(['/object-details',productId]);
  }

}
