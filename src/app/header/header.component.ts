import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{

  connected!: boolean;

  constructor(private loginservice: LoginService, private router: Router) {}

  ngOnInit(): void {
    // Initial check when the component is loaded
    this.updateConnectedStatus();

    // Subscribe to route changes
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        // On each route change, update the connected status
        this.updateConnectedStatus();
      }
    });
  }

  updateConnectedStatus() {
    // Check the user status and update the connected variable
    this.connected = !!localStorage.getItem('user');
  }

  logout(event: Event) {
    this.loginservice.logout();
    this.router.navigate(["login"])
  }

  login(event: Event) {
    event.preventDefault();
    this.router.navigate(["login"])
  }

  home(event: Event) {
    event.preventDefault();
    this.router.navigate(["home"])
  }

}
