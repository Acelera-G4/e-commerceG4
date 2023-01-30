import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './home/home.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { FooterComponent } from './components/footer/footer.component';
import { CardComponent } from './components/card/card.component';

@NgModule({
  declarations: [
    HeaderComponent,
    HomeComponent,
    FooterComponent,
    CardComponent,
  ],
  imports: [CommonModule, MatToolbarModule, MatIconModule],
  exports: [
    HeaderComponent,
    HomeComponent,
    MatToolbarModule,
    MatIconModule,
    FooterComponent,
    CardComponent
  ],
})
export class PagesModule {}
