import { Component, OnInit, OnDestroy } from '@angular/core';
import { EventEmitter, Output } from '@angular/core';

import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './login.service';
import { user } from '../models/user';
import { DatePipe } from '@angular/common';

@Injectable({
  providedIn: 'root',
})
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {
  constructor(private router: Router, private loginservice: LoginService, private pipe: DatePipe) {}

  ngOnInit() {
    
  }
  ngOnDestroy() {
  }

  username: string = "";
  password: string = "";
  
  onSubmitLogin(): void {
    this.loginservice.login(this.username, this.password).subscribe((user: user) => {
      localStorage.setItem("user", JSON.stringify(user));
      if (user.role=="admin") {
        this.router.navigate(["admin"])
      }else if (user.role=="client") {
        this.router.navigate(["home"])
      }
      
    })
   
  }

}
