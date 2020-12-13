import { AuthService } from './services/auth.service';
import { AgmCoreModule} from '@agm/core';
import { RestaurantService } from './services/restaurant.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RestaurantListComponent } from './components/restaurant-list/restaurant-list.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { RegisterComponent } from './components/register/register.component';
import { ReviewsComponent } from './components/reviews/reviews.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RestaurantInfoComponent } from './components/restaurant-info/restaurant-info.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { AddRestaurantComponent } from './components/add-restaurant/add-restaurant.component';


@NgModule({
  declarations: [
    AppComponent,
    RestaurantListComponent,
    NavbarComponent,
    HomeComponent,
    FooterComponent,
    LoginComponent,
    LogoutComponent,
    RegisterComponent,
    ReviewsComponent,
    RestaurantInfoComponent,
    UserProfileComponent,
    AddRestaurantComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    ReactiveFormsModule,
    AgmCoreModule.forRoot({
      apiKey:'AIzaSyAyBvGZA0Ragd3WN1PTJnXQUaq3zcw8ZjM'
    })
  ],
  providers: [RestaurantService,AuthService],

  bootstrap: [AppComponent]
})
export class AppModule { }
