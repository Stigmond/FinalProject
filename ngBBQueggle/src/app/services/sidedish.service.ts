import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { SideDish } from '../models/side-dish';

@Injectable({
  providedIn: 'root',
})
export class SideDishService {
  constructor(private http: HttpClient) {}

  private baseUrl = 'http://localhost:8090/';

  private url = this.baseUrl + 'api/sideDish';

  index(): Observable<SideDish[]> {
    return this.http.get<SideDish[]>(this.url + '?sorted=true').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('error loading side dish list');
      })
    );
  }

  show(id: number) {
    return this.http.get<SideDish>(this.url + '/' + id + '?sorted=true').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('SideDishService.show() error');
      })
    );
  }

  public create(sideDish: SideDish): Observable<SideDish> {
    const httpOptions = {
      headers: {
        'Content-type': 'application/json',
      },
    };
    return this.http.post<SideDish>(this.url, sideDish, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error creating side dish');
      })
    );
  }
  public update(sideDish: SideDish): Observable<SideDish> {
    const httpOptions = {
      headers: {
        'Content-type': 'application/json',
      },
    };
    return this.http
      .put<SideDish>(this.url + '/' + sideDish.id, sideDish, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Error updating side dish');
        })
      );
  }

  public disable(id: number): Observable<boolean> {
    return this.http.delete<boolean>(this.url + '/' + id).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error deleting side dish');
      })
    );
  }
}
