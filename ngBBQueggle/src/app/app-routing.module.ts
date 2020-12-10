import { Restaurant } from './models/restaurant';
import { RestaurantInfoComponent } from './components/restaurant-info/restaurant-info.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ReviewsComponent } from './components/reviews/reviews.component';

const routes: Routes = [
{ path: 'reviews/:restId', component: ReviewsComponent },
{ path: 'home', component: HomeComponent},
{ path: 'register', component: RegisterComponent},
{ path: 'info/:restId', component: RestaurantInfoComponent},
{ path: 'restarant', component: Restaurant}


];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
