import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css'],
})
export class FooterComponent {
  isDashboard = false;
 

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.router.events.subscribe((event) => {
      if (
        this.router.url === '/dashboard' ||
        this.router.url === '/user' ||
        this.router.url === '/product'
      ) {
        this.isDashboard = true;
      } else {
        this.isDashboard = false;
      }
    });


  }
}
