import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Address } from './../../models/address';
import { Restaurant } from './../../models/restaurant';
import { RestaurantService } from './../../services/restaurant.service';
import { AuthService } from 'src/app/services/auth.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

restaurants = [];
users: User[];
selectedTab: string = 'users';
selectedUser: User;
selectedRestaurant: Restaurant;
updatedRestaurant: Restaurant;
toEdit: boolean = false;


  constructor(private RestaurantService: RestaurantService, private userService: UserService, private currentRoute: ActivatedRoute, private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    if (localStorage.getItem('role') === 'ROLE_ADMIN') {
    console.log('WELCOME ADMIN!');
    this.userIndex();
    this.restaurantIndex();
  } else {
    console.log('UNAUTHORIZED USER!');
    this.router.navigateByUrl('home');
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

  enableUser(): void{
    console.log(this.selectedUser);
    this.userService.update(this.selectedUser.id, this.selectedUser).subscribe(
      good=>{
        this.selectedUser = good;
      },
      error=>{
        console.error('failed to enable/disable user');
        console.error(error);
      }
    );
  }



  info(): void{
    console.log(this.selectedRestaurant);
  }

  showRestaurants(): void{
    this.restaurantIndex();
  }

  showUsers(): void{
    this.userIndex();
  }
}
