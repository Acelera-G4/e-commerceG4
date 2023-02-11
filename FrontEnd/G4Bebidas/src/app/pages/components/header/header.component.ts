import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {
  isDashboard = false;
  isLogin = false;
  isSignUp = false;
  isHome = false;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.router.events.subscribe((event) => {
      if (this.router.url === '/login' || this.router.url === '/sign-up') {
        this.isLogin = true;
        this.isSignUp = true;
      } else {
        this.isLogin = false;
        this.isSignUp = false;
      }

      if (
        this.router.url === '/dashboard' ||
        this.router.url === '/list-users'||
        this.router.url === '/product'
      ) {
        this.isDashboard = true;
        this.isHome = true;
      } else {
        this.isDashboard = false;
        this.isHome = false;
      }
    });
  }
}
