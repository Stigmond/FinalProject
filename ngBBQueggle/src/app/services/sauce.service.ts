import { AuthService } from './auth.service';
import { Sauce } from './../models/sauce';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class SauceService {
  constructor(private http: HttpClient, private authService: AuthService) {}

  private baseUrl = environment.baseUrl;                    // Production

  private url = this.baseUrl + 'api/sauce';

  index(): Observable<Sauce[]> {
    const credentials = this.authService.getCredentials();
    const httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${credentials}`,
      'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Sauce[]>(this.url + '?sorted=true', httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('error loading sauce list');
      })
    );
  }

  show(id: number) {
    return this.http.get<Sauce>(this.url + '/' + id + '?sorted=true').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('SauceService.show(): error');
      })
    );
  }

  public create(sauce: Sauce): Observable<Sauce> {
    const httpOptions = {
      headers: {
        'Content-type': 'application/json',
      },
    };
    return this.http.post<Sauce>(this.url, sauce, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error creating sauce');
      })
    );
  }
  public update(sauce: Sauce): Observable<Sauce> {
    const httpOptions = {
      headers: {
        'Content-type': 'application/json',
      },
    };
    return this.http
      .put<Sauce>(this.url + '/' + sauce.id, sauce, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Error updating sauce');
        })
      );
  }

  public disable(id: number): Observable<boolean> {
    return this.http.delete<boolean>(this.url + '/' + id).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error deleting sauce');
      })
    );
  }
}
