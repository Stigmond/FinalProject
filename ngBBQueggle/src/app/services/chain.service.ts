import { Chain } from './../models/chain';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ChainService {
  private baseUrl = 'http://localhost:8090/';
  url = this.baseUrl + 'api/chain/'

  constructor(private http: HttpClient) { }

  index(): Observable<Chain[]>{
    return this.http.get<Chain[]>(this.url + '?sorted=true').pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('ChainService.index(): error');

      })
    );
  }

  show(id: number){
    return this.http.get<Chain>(this.url + '/' + id
    + '?sorted=true').pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('ChainService.show(): error');
    })
    );
  }

  create(newChain: Chain){
    return this.http.post<Chain>(this.url, newChain).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('ChainService.create(): error');
    })
    );
  }

  update(id: number, chain: Chain){
    return this.http.put<Chain>(this.url + '/' + id, chain).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('ChainService.update(): error');
    })
    );
  }

  delete(id: number){
    return this.http.delete<Chain>(this.url + '/' + id).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('ChainService.delete(): error');
    })
    );
  }
}
