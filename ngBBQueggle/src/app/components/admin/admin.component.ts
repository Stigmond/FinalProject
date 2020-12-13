import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { Address } from './../../models/address';
import { Restaurant } from './../../models/restaurant';
import { RestaurantService } from './../../services/restaurant.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

restaurants = [];
users = [];

  constructor(private RestaurantService: RestaurantService, private userService: UserService, private currentRoute: ActivatedRoute) { }

  ngOnInit(): void {
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
