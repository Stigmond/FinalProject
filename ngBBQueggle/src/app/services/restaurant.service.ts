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
}
