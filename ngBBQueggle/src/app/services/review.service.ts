import { RestaurantService } from './restaurant.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Review } from '../models/review';
import { AuthService } from './auth.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ReviewService {

  constructor(private http: HttpClient, private authService: AuthService) {}

  private baseUrl = environment.baseUrl;                    // Production
  private url = this.baseUrl + 'api/reviews/';

  list(restaurantId: number): Observable<Review[]> {
    const credentials = this.authService.getCredentials();
    const httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${credentials}`,
      'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Review[]>(this.url + restaurantId + '?sorted=true', httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('error loading review list');
      })
    );
  }

score(restaurantId: number): Observable<number> {
  const credentials = this.authService.getCredentials();
    const httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${credentials}`,
      'X-Requested-With': 'XMLHttpRequest'
      })
    };
  return this.http.get<number>(this.url + restaurantId + '/score', httpOptions).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('error retrieving score');
    })
  );
}

  // show(id: number) {
  //   return this.http.get<Review>(this.url + '/' + id + '?sorted=true').pipe(
  //     catchError((err: any) => {
  //       console.log(err);
  //       return throwError('ReviewService.show(): error');
  //     })
  //   );
  // }

  public create(review: Review, restaurantId: number, userId: number): Observable<Review> {
    const credentials = this.authService.getCredentials();
    const httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${credentials}`,
      'Content-type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.post<Review>(this.url + restaurantId + '/' + userId, review, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error creating review');
      })
    );
  }

  public update(review: Review, restaurantId: number, reviewId: number): Observable<Review> {
    const credentials = this.authService.getCredentials();
    const httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${credentials}`,
      'Content-type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http
      .put<Review>(this.url + restaurantId + '/' + reviewId, review, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Error updating review');
        })
      );
  }

  public delete(restaurantId: number, reviewId: number): Observable<boolean> {
    const credentials = this.authService.getCredentials();
    const httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${credentials}`,
      'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.delete<boolean>(this.url + restaurantId + '/' + reviewId, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error deleting review');
      })
    );
  }
}
