import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Address } from '../models/address';

@Injectable({
  providedIn: 'root',
})
export class AddressService {
  constructor(private http: HttpClient) {}

  private baseUrl = 'http://localhost:8090/';

  private url = this.baseUrl + 'api/address';

  index(): Observable<Address[]> {
    return this.http.get<Address[]>(this.url + '?sorted=true').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('error loading address list');
      })
    );
  }

  show(id: number) {
    return this.http.get<Address>(this.url + '/' + id + '?sorted=true').pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('AddressService.show(): error');
      })
    );
  }

  public create(address: Address): Observable<Address> {
    const httpOptions = {
      headers: {
        'Content-type': 'application/json',
      },
    };
    return this.http.post<Address>(this.url, address, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error creating address');
      })
    );
  }
  public update(address: Address): Observable<Address> {
    const httpOptions = {
      headers: {
        'Content-type': 'application/json',
      },
    };
    return this.http
      .put<Address>(this.url + '/' + address.id, address, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Error updating address');
        })
      );
  }

  public disable(id: number): Observable<boolean> {
    return this.http.delete<boolean>(this.url + '/' + id).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error deleting address');
      })
    );
  }
}
