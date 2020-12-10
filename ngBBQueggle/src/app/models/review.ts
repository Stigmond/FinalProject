import { ɵLocaleDataIndex } from '@angular/core';
import { User } from './user';

export class Review {
  id: number;
  reviewScore: number;
  review: string;
  reviewDate: string;
  user: User;

  constructor(
    id?: number,
    reviewScore?: number,
    review?: string,
    reviewDate?: string,
    user?: User
  ){
    this.id = id;
    this.reviewScore = reviewScore;
    this.review = review;
    this.reviewDate = reviewDate;
    this.user = user;
  }
}
