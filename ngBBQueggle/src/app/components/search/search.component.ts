import { Address } from './../../models/address';
import { Restaurant } from './../../models/restaurant';
import { RestaurantService } from './../../services/restaurant.service';
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
restaurants = [];
address = [];
selected: Restaurant = null;
selected2: Address = null;
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
        this.selected = good;
        console.log('restaurant selected');
      },
      error=>{
        console.error('failed to select exercise');
        console.error(error);

      }
    );
  }

  findRestaurantsByState(): void{
    this.RestaurantService.findRestaurantsByState(this.selected2.state).subscribe(
      good=>{
        this.selected2 = good;
        console.log('exercise selected');
      },
      error=>{
        console.error('failed to select exercise');
        console.error(error);

      }
    );
  }
}
