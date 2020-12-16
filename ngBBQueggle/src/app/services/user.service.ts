import { AuthService } from './auth.service';
import { User } from './../models/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError} from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = environment.baseUrl;                    // Production
  url = this.baseUrl + 'api/user/';

  constructor(private http: HttpClient, private authService: AuthService) { }

  index(): Observable<User[]>{
    const credentials = this.authService.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<User[]>(this.url + '?sorted=true', httpOptions).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('UserService.index(): error');

      })
    );
  }

  findById(id) {
    return this.http.get<User>(this.url  + id, this.httpOptions)
    .pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('Error listing user');
      })
    );

  }

  findByUsername(username: String) {
    return this.http.get<User>(this.url +  "/" + username , this.httpOptions)
    .pipe(
      catchError((err: any) => {
        console.error(err);
        console.log(this.url);

        return throwError('Error finding username');
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
    const credentials = this.authService.getCredentials();
    const httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${credentials}`,
      'Content-type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.put<User>(this.url + id, user, httpOptions).pipe(
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

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': `Basic ${this.authService.getCredentials()}`,
      'X-Requested-With': 'XMLHttpRequest'
    })
  };
}
