import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = environment.baseUrl;                    // Production

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }


login(username, password): Observable<User> {
  // Make credentials
  const credentials = this.generateBasicAuthCredentials(username, password);
  // Send credentials as Authorization header (this is spring security convention for basic auth)
  const httpOptions = {
    headers: new HttpHeaders({
      'Authorization': `Basic ${credentials}`,
      'X-Requested-With': 'XMLHttpRequest'
    })
  };

  // create request to authenticate credentials
  return this.http
    .get<User>(this.baseUrl + 'authenticate', httpOptions)
    .pipe(
      tap((res) => {
        localStorage.setItem('credentials' , credentials);
        localStorage.setItem('userId', res.id.toString()); //retrieve with localStorage.getItem('userId');
        // localStorage.setItem('username',res.id.toString());
        localStorage.setItem('role', res.role);
        return res;
      }),
      catchError((err: any) => {
        console.log(err);
        return throwError('AuthService.login(): Error logging in.');
      })
    );
}

register(user): Observable<User> {
  // create request to register a new account
  return this.http.post<User>(this.baseUrl + 'register', user)
  .pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError('AuthService.register(): error registering user.');
    })
  );
}

logout() {
  localStorage.removeItem('credentials');
  localStorage.removeItem('userId');
  localStorage.removeItem('role');
  this.router.navigateByUrl('home');
  }

checkLogin() {
  if (localStorage.getItem('credentials')) {
    return true;
  }
  return false;
}

generateBasicAuthCredentials(username, password) {
  return btoa(`${username}:${password}`);
}

getCredentials() {
  return localStorage.getItem('credentials');
}

}
