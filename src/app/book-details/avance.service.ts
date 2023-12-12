import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AvanceService {

  private baseUrl = 'http://localhost:8080/api/getRemainingDays/'

  constructor(private http: HttpClient) { }

  getRemainingDays(idBook: number): Observable<any> {
    return this.http.put<any>(this.baseUrl+idBook, {});
  }

}
