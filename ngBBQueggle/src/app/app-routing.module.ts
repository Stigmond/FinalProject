import { AdminComponent } from './components/admin/admin.component';

import { UserProfileComponent } from './components/user-profile/user-profile.component';

import { AddRestaurantComponent } from './components/add-restaurant/add-restaurant.component';

import { LoginComponent } from './components/login/login.component';
import { RestaurantListComponent } from './components/restaurant-list/restaurant-list.component';
import { RestaurantInfoComponent } from './components/restaurant-info/restaurant-info.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ReviewsComponent } from './components/reviews/reviews.component';

const routes: Routes = [
{ path: '', pathMatch: 'full', redirectTo: 'home' },
{ path: 'reviews/:restId', component: ReviewsComponent },
{ path: 'home', component: HomeComponent},
{ path: 'register', component: RegisterComponent},
{ path: 'addRestaurant', component: AddRestaurantComponent},
{ path: 'info/:restId', component: RestaurantInfoComponent},
{ path: 'restaurant', component: RestaurantListComponent},
{ path: 'restaurant/:state', component: RestaurantListComponent},
{ path: 'restaurant/:state/:searchType/:searchTerm', component: RestaurantListComponent},
{ path: 'login', component: LoginComponent},
{ path: 'userProfile', component: UserProfileComponent},
{ path: 'userProfile/:userId', component: UserProfileComponent},
{ path: 'admin', component: AdminComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
