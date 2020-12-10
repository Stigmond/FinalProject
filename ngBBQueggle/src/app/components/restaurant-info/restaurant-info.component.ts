import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Restaurant } from 'src/app/models/restaurant';
import { RestaurantService } from 'src/app/services/restaurant.service';

@Component({
  selector: 'app-restaurant-info',
  templateUrl: './restaurant-info.component.html',
  styleUrls: ['./restaurant-info.component.css']
})
export class RestaurantInfoComponent implements OnInit {

  restaurantId: number;
  restaurant: Restaurant;
  selected: string;

  constructor(private restService: RestaurantService, private currentRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.restaurantId = parseInt(this.currentRoute.snapshot.paramMap.get('restId'));
    this.getRestaurant(this.restaurantId);
    this.selected = 'about';
  }


  getRestaurant(restaurantId: number): void {
    this.restService.show(restaurantId).subscribe(
    data=>{
      this.restaurant = data;
      console.log(this.restaurant);
      console.log('reviewsComponent.getRestaurant(): Restaurant retrieved');

    },
    err=>{
      console.error('reviewsComponent.getRestaurant(): retrieve failed');
      console.error(err);

    }
  );
  }

}
