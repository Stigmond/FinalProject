import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Restaurant } from '../models/restaurant';
import { catchError} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  private baseUrl = 'http://localhost:8090/';
  url = this.baseUrl + 'api/restaurants/';

  constructor(private http: HttpClient) { }

  index(): Observable<Restaurant[]>{
    return this.http.get<Restaurant[]>(this.url + '?sorted=true').pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('RestaurantService.index(): error');

      })
    );
  }

  show(id: number){
    return this.http.get<Restaurant>(this.url + '/' + id
    + '?sorted=true').pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('RestaurantService.show(): error');
    })
    );
  }

  create(newRestaurant: Restaurant){
    return this.http.post<Restaurant>(this.url, newRestaurant).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('RestaurantService.create(): error');
    })
    );
  }

  update(id: number, restaurant: Restaurant){
    return this.http.put<Restaurant>(this.url + '/' + id, restaurant).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('RestaurantService.update(): error');
    })
    );
  }
  delete(id: number){
    return this.http.delete<Restaurant>(this.url + '/' + id).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('RestaurantService.delete(): error');
    })
    );
  }

}
