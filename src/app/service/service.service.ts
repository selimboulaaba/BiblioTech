import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private apiUrl = 'http://localhost:8081';
  
  constructor(private httpClient: HttpClient, private router: Router) { }
  request(method: string, url: string, data?: any): Observable<any> {
    

    switch (method.toLowerCase()) {
      case 'get':
        return this.httpClient.get(`${this.apiUrl}/${url}`);
      case 'post':
        return this.httpClient.post(`${this.apiUrl}/${url}`, data);
      case 'put':
        return this.httpClient.put(`${this.apiUrl}/${url}`, data);
      case 'delete':
        return this.httpClient.delete(`${this.apiUrl}/${url}`);
      default:
        throw new Error(`Unsupported HTTP method: ${method}`);
    }
  }
}
