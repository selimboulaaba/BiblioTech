import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { user } from '../models/user';
import { Observable } from 'rxjs';
import { Route, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private baseUrl = 'http://localhost:8081/REVIEW'

  constructor(private http: HttpClient, private router: Router) { }

  login(username: string, password: string): Observable<user> {
    return this.http.get<user>(this.baseUrl+"/login/"+username+"/"+password);
  }

  get(idUser: number): Observable<user> {
    return this.http.get<user>(this.baseUrl+"/user/"+idUser);
  }

  logout() {
    localStorage.removeItem("user");
  }
}
