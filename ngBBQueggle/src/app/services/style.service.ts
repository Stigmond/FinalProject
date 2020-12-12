import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Style } from '../models/style';

@Injectable({
  providedIn: 'root',
})
export class StyleService {
  constructor(private http: HttpClient, private authService: AuthService) {}

  private baseUrl = 'http://localhost:8090/';

  private url = this.baseUrl + 'api/style';

  index(): Observable<Style[]> {
    const credentials = this.authService.getCredentials();
    const httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${credentials}`,
      'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Style[]>(this.url + '?sorted=true', httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('error loading style list');
      })
    );
  }

  show(id: number) {
    return this.http.get<Style>(this.url + '/' + id + '?sorted=true').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('StyleService.show() error');
      })
    );
  }

  public create(style: Style): Observable<Style> {
    const httpOptions = {
      headers: {
        'Content-type': 'application/json',
      },
    };
    return this.http.post<Style>(this.url, style, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error creating style');
      })
    );
  }
  public update(style: Style): Observable<Style> {
    const httpOptions = {
      headers: {
        'Content-type': 'application/json',
      },
    };
    return this.http
      .put<Style>(this.url + '/' + style.id, style, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Error updating style');
        })
      );
  }

  public disable(id: number): Observable<boolean> {
    return this.http.delete<boolean>(this.url + '/' + id).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error deleting style');
      })
    );
  }
}
