import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { MainDish } from '../models/main-dish';

@Injectable({
  providedIn: 'root',
})
export class MainDishService {
  constructor(private http: HttpClient, private authService: AuthService) {}

  private baseUrl = 'http://localhost:8090/';

  private url = this.baseUrl + 'api/mainDish';

  index(): Observable<MainDish[]> {
    const credentials = this.authService.getCredentials();
    const httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${credentials}`,
      'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<MainDish[]>(this.url + '?sorted=true', httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('error loading main dish list');
      })
    );
  }

  show(id: number) {
    return this.http.get<MainDish>(this.url + '/' + id + '?sorted=true').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('MainDishService.show() error');
      })
    );
  }

  public create(mainDish: MainDish): Observable<MainDish> {
    const httpOptions = {
      headers: {
        'Content-type': 'application/json',
      },
    };
    return this.http.post<MainDish>(this.url, mainDish, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error creating main dish');
      })
    );
  }
  public update(mainDish: MainDish): Observable<MainDish> {
    const httpOptions = {
      headers: {
        'Content-type': 'application/json',
      },
    };
    return this.http
      .put<MainDish>(this.url + '/' + mainDish.id, mainDish, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Error updating main dish');
        })
      );
  }

  public disable(id: number): Observable<boolean> {
    return this.http.delete<boolean>(this.url + '/' + id).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error deleting main dish');
      })
    );
  }
}
