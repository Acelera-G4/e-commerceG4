import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {
  isDashboard = false;
  isHome = false;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.router.events.subscribe((event) => {
      if (
        this.router.url === '/dashboard' ||
        this.router.url === '/user' ||
        this.router.url === '/product'
      ) {
        this.isDashboard = true;
        this.isHome = false;
      } else {
        this.isDashboard = false;
        this.isHome = true;
      }
    });
  }
}
