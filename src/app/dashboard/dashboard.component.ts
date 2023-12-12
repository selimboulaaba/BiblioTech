import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';
import { ServiceService } from '../service/service.service';
import { book } from '../models/book';
import { BookServiceService } from '../services/book-service.service';
import { LoginService } from '../login/login.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  
  bookList: any[] = [];
  book: book = {
    idBook: 0,
    title: '',
    author: '',
    genre: '',
    available: true, // Assuming this property is boolean
    imageUrl: '',
};
  tableData: any[] = [];
  title!: string;
  author!: string;
  image!: string;
  genre!: string;
  
  
  constructor(private formBuilder: FormBuilder,private service:ServiceService, private bookservice: BookServiceService, private loginservice: LoginService, private router: Router) { }

  ngOnInit() {
    
    this.service.request('GET', 'BOOK/book/getAll').subscribe(
      (response: any) => {
        console.log(response);
        this.bookList = response;
      },
      (error: any) => {
        if (error.status === 401) {
          
        } else {
          console.error('Error:', error.status, error.statusText);
        }
      }
    );
    this.service.request('GET', 'ORDER/findAllOrder').subscribe(
      (response: any) => {
        
        this.tableData = response;
        console.log(this.tableData);
        
      },
      (error: any) => {
        if (error.status === 401) {
          
        } else {
          console.error('Error:', error.status, error.statusText);
        }
      }
    );
    
  }

  
  onSubmit() {
    this.book.title = this.title;
    this.book.author = this.author;
    this.book.genre = this.genre;
    this.book.available = true;
    this.book.imageUrl = encodeURIComponent(this.image);
    console.log(this.book)
    this.bookservice.post(this.book).subscribe((book: book) => {
      console.log(book)
    })
    
  }
  
  clientLogos = [
    '../../assets/img/client_logo/client_logo_1.png',
    '../../assets/img/client_logo/client_logo_2.png',
    '../../assets/img/client_logo/client_logo_3.png',
    '../../assets/img/client_logo/client_logo_4.png',
    '../../assets/img/client_logo/client_logo_5.png',
    // Add more image sources as needed
  ];
  selectedLogo: string | null = null;

  onSelectLogo(logo: string): void {
    this.selectedLogo = logo;
  }

  logout() {
    this.loginservice.logout();
    this.router.navigate(["login"])
  }

}
