import { Component, OnInit } from '@angular/core';
import { Address } from './../../models/address';
import { Restaurant } from './../../models/restaurant';
import { RestaurantService } from './../../services/restaurant.service';

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent implements OnInit {
  restaurants = [];
  address = [];
  selected: Restaurant = null;
  selectedAd: string= null;
  searchTerm = null;
  newRestaurant: Restaurant = new Restaurant();
    constructor(private RestaurantService: RestaurantService) { }

    ngOnInit(): void {
      this.RestaurantService.index();
    }

    index(): void{
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

    show(): void{
      this.RestaurantService.show(this.selected.id).subscribe(
        good=>{
          this.restaurants = [];
          this.restaurants.push(good);
          console.log('restaurant selected');
        },
        error=>{
          console.error('failed to select exercise');
          console.error(error);

        }
      );
    }
    findRestaurantsByState(): void{
      this.RestaurantService.findRestaurantsByState(this.selectedAd).subscribe(
        good=>{
          this.restaurants = good;
          console.log('exercise selected');
        },
        error=>{
          console.error('failed to select exercise');
          console.error(error);

        }
      );
    }
}
