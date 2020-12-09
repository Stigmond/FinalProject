import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ReviewsComponent } from './components/reviews/reviews.component';

const routes: Routes = [
{ path: 'reviews', component: ReviewsComponent },
{ path: 'home', component: HomeComponent},
{ path: 'register', component: RegisterComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
