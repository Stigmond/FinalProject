import { UserService } from './../../services/user.service';
import { RestaurantService } from './../../services/restaurant.service';
import { Restaurant } from './../../models/restaurant';
import { ReviewService } from './../../services/review.service';
import { Component, OnInit } from '@angular/core';
import { Review } from 'src/app/models/review';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {

  reviews: Review[];
  score: number;
  restaurantId: number = 2;
  restaurant: Restaurant;
  userId: number = 1;

  newReview: Review = new Review();


  constructor(private reviewService: ReviewService, private restService: RestaurantService, private userService: UserService) { }

  ngOnInit(): void {
    this.getRestaurant(this.restaurantId);
    this.loadReviews(this.restaurantId);
    this.getScore(this.restaurantId);
  }

  loadReviews(restaurantId: number): void {
    this.reviewService.list(restaurantId).subscribe(
      data=>{
        this.reviews = data;
        console.log(this.reviews);
        console.log('reviewsComponent.loadReviews(): reviews retrieved');

      },
      err=>{
        console.error('reviewsComponent.loadReviews(): retrieval failed');
        console.error(err);

      }
    );
  }

  addReview(newReview: Review, restaurantId: number, userId: number): void {
    this.reviewService.create(newReview, restaurantId, userId).subscribe(
      data=>{
        this.newReview = data;
        console.log(this.newReview);
        console.log('reviewsComponent.addReview(): Review Posted');
        this.loadReviews(this.restaurantId);
        this.clearForm();
      },
      err=>{
        console.error('reviewsComponent.addReview(): Posting failed');
        console.error(err);
        this.loadReviews(this.restaurantId);

      }
    );
  }

  getScore(restaurantId: number): void {
    this.reviewService.score(restaurantId).subscribe(
    data=>{
      this.score = data;
      console.log(this.score);
      console.log('reviewsComponenet.getScore(): score retrieved');

    },
    err=>{
      console.error('reviewsComponenet.getScore(): retrieve failed');
      console.error(err);

    }
  );
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


  clearForm(): void {
    this.newReview = new Review();
  }

}
