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
  selectedTab: string;

  latitude =39.594710;
  longitude= -104.876650;


  constructor(private restService: RestaurantService, private currentRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.restaurantId = parseInt(this.currentRoute.snapshot.paramMap.get('restId'));
    this.getRestaurant(this.restaurantId);
    this.selectedTab = 'about';
  }

  getRestaurant(restaurantId: number): void {
    this.restService.show(restaurantId).subscribe(
    data=>{
      this.restaurant = data;
      console.log(this.restaurant);
      this.restaurant.phoneNumber = this.formatPhoneNumber(this.restaurant.phoneNumber);
      console.log('reviewsComponent.getRestaurant(): Restaurant retrieved');

    },
    err=>{
      console.error('reviewsComponent.getRestaurant(): retrieve failed');
      console.error(err);

    }
  );
  }

  formatPhoneNumber(phoneNumberString) {
    var cleaned = ('' + phoneNumberString).replace(/\D/g, '')
    var match = cleaned.match(/^(\d{3})(\d{3})(\d{4})$/)
    if (match) {
      return '(' + match[1] + ') ' + match[2] + '-' + match[3]
    }
    return null
  }


}
