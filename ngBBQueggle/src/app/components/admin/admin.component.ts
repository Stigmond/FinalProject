import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Address } from './../../models/address';
import { Restaurant } from './../../models/restaurant';
import { RestaurantService } from './../../services/restaurant.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

restaurants = [];
users = [];
selectedTab: string = 'restaurants';

  constructor(private RestaurantService: RestaurantService, private userService: UserService, private currentRoute: ActivatedRoute, private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    if (localStorage.getItem('role') === 'ROLE_ADMIN') {
    console.log('WELCOME ADMIN!');
  } else {
    console.log('UNAUTHORIZED USER!');
    this.router.navigateByUrl('login');
  }
}

  restaurantIndex(): void{
    this.RestaurantService.index().subscribe(
      good=>{
        this.restaurants = good;
      },
      error=>{
        console.error('failed to load index()');
        console.error(error);
      }
    );
  }

  userIndex(): void{
    this.userService.index().subscribe(
      good=>{
        this.users = good;
      },
      error=>{
        console.error('failed to load index()');
        console.error(error);
      }
    );
  }




  showRestaurants(): void{
    this.restaurantIndex();
  }

  showUsers(): void{
    this.userIndex();
  }
}
