import { User } from './../models/user';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8090/';
  url = this.baseUrl + 'api/user/';

  constructor(private http: HttpClient) { }

  index(): Observable<User[]>{
    return this.http.get<User[]>(this.url + '?sorted=true').pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('UserService.index(): error');

      })
    );
  }

  show(id: number){
    return this.http.get<User>(this.url + '/' + id
    + '?sorted=true').pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('UserService.show(): error');
    })
    );
  }
  create(newUser: User){
    return this.http.post<User>(this.url, newUser).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('UserService.create(): error');
    })
    );
  }

  update(id: number, user: User){
    return this.http.put<User>(this.url + '/' + id, User).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('Userservice.update(): error');
    })
    );
  }

  delete(id: number){
    return this.http.delete<User>(this.url + '/' + id).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('UserService.delete(): error');
    })
    );
  }
}
