import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable,of  } from 'rxjs';
import { book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {
  private baseUrl = 'http://localhost:8081/BOOK'

  constructor(private http: HttpClient) { }

  getallbooks(): Observable<book[]> {
    return this.http.get<book[]>(this.baseUrl+"/book/getAll");
  }

  get(idBook: number): Observable<book> {
    return this.http.get<book>(this.baseUrl+"/book/getOne/"+idBook);
  }

  post(book: book): Observable<book> {
    const params = new HttpParams()
      .set('title', book.title)
      .set('author', book.author)
      .set('genre', book.genre)
      .set('available', true)
      .set('imageUrl', book.imageUrl);
    return this.http.get<book>(this.baseUrl+"/book/add/", {params});
  }

}
