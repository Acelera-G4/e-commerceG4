import { HeaderComponent } from './pages/components/header/header.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FooterComponent } from './pages/components/footer/footer.component';
import { CardComponent } from './pages/components/card/card.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { InputTextModule } from 'primeng/inputtext';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { InputMaskModule } from 'primeng/inputmask';
import {TableModule} from 'primeng/table';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { UserComponent } from './pages/components/user/user.component';
import { ProductsComponent } from './pages/components/products/products.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FooterComponent,
    LoginComponent,
    CardComponent,
    SignUpComponent,
    DashboardComponent,
    HeaderComponent,
    UserComponent,
    ProductsComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    InputTextModule,
    InputMaskModule,
    TableModule
    
  ],
  exports: [AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
