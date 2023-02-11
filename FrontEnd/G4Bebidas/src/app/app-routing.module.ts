import { ProductsComponent } from './pages/components/products/products.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { ListUsersComponent } from './pages/components/list-users/list-users.component';

const routes: Routes = [
  {path: "", component: HomeComponent },
  {path: 'home', component: HomeComponent },
  {path: 'login', component: LoginComponent},
  {path: 'sign-up', component: SignUpComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'product', component: ProductsComponent},
  {path: 'list-users', component: ListUsersComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
