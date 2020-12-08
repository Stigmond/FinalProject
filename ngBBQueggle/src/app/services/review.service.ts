import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Review } from '../models/review';

@Injectable({
  providedIn: 'root',
})
export class ReviewService {
  constructor(private http: HttpClient) {}

  private baseUrl = 'http://localhost:8090/';

  private url = this.baseUrl + 'api/review';

  index(): Observable<Review[]> {
    return this.http.get<Review[]>(this.url + '?sorted=true').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('error loading review list');
      })
    );
  }

  show(id: number) {
    return this.http.get<Review>(this.url + '/' + id + '?sorted=true').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('ReviewService.show(): error');
      })
    );
  }

  public create(review: Review): Observable<Review> {
    const httpOptions = {
      headers: {
        'Content-type': 'application/json',
      },
    };
    return this.http.post<Review>(this.url, review, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error creating review');
      })
    );
  }
  public update(review: Review): Observable<Review> {
    const httpOptions = {
      headers: {
        'Content-type': 'application/json',
      },
    };
    return this.http
      .put<Review>(this.url + '/' + review.id, review, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Error updating review');
        })
      );
  }

  public disable(id: number): Observable<boolean> {
    return this.http.delete<boolean>(this.url + '/' + id).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error deleting review');
      })
    );
  }
}
