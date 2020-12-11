import { Address } from './../models/address';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Restaurant } from '../models/restaurant';
import { catchError} from 'rxjs/operators';
import { style } from '@angular/animations';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  private baseUrl = 'http://localhost:8090/';
  url = this.baseUrl + 'api/restaurants';

  constructor(private http: HttpClient) { }

  index(): Observable<Restaurant[]>{
    return this.http.get<Restaurant[]>(this.url + '/?sorted=true').pipe(
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

  findRestaurantsByState(state: string): Observable<Restaurant[]>{
    return this.http.get<Restaurant[]>(this.url + '/search/' + state).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('RestaurantService.findRestaurantByState(): error');
    })
    );
  }
  findRestaurantsByName(state: string, name: string): Observable<Restaurant[]>{
    return this.http.get<Restaurant[]>(this.url + '/search/' + state + '/name/' + name).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('RestaurantService.findRestaurantByName(): error');
    })
    );
  }
  findRestaurantsByMeatType(state: string, meatType: string): Observable<Restaurant[]>{
    return this.http.get<Restaurant[]>(this.url + '/search/' + state + '/meat/' + meatType).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('RestaurantService.findRestaurantByMeatType(): error');
    })
    );
  }
  findRestaurantsBySideDish(state: string, sideDish: string): Observable<Restaurant[]>{
    return this.http.get<Restaurant[]>(this.url + '/search/' + state + '/sideDish/' + sideDish).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('RestaurantService.findRestaurantBySideDish(): error');
    })
    );
  }

  findRestaurantsByStyle(state: string, style: string): Observable<Restaurant[]>{
    return this.http.get<Restaurant[]>(this.url + '/search/' + state + '/style/' + style).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('RestaurantService.findRestaurantByStyle(): error');
    })
    );
  }
}
