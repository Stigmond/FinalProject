import { ɵLocaleDataIndex } from '@angular/core';

export class Review {
  id: number;
  reviewScore: number;
  review: string;
  reviewDate: string;

  constructor(
    id?: number,
    reviewScore?: number,
    review?: string,
    reviewDate?: string,
  ){
    this.id = id;
    this.reviewScore = reviewScore;
    this.review = review;
    this.reviewDate = reviewDate;
  }
}
