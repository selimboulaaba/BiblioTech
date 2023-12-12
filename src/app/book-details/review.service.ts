import { Injectable } from '@angular/core';
import { review } from '../models/review';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  private baseUrl = 'http://localhost:8081/REVIEW/review'

  constructor(private http: HttpClient) { }

  getallreviews(idBook: number): Observable<review[]> {
    return this.http.get<review[]>(this.baseUrl+"/book/"+idBook);
  }

  post(review: review): Observable<review> {

    const params = new HttpParams()
    .set('userId', review.userId)
    .set('bookId', review.bookId)
    .set('comment', review.comment)
    return this.http.get<review>(this.baseUrl+"/post", {params});
  }

}