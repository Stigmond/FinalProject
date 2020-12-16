import { Pitmaster } from './../models/pitmaster';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError} from 'rxjs/operators';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class PitmasterService {
  private baseUrl = environment.baseUrl;                    // Production
  url = this.baseUrl + 'api/pitmaster/';

  constructor(private http: HttpClient) { }

  index(): Observable<Pitmaster[]>{
    return this.http.get<Pitmaster[]>(this.url + '?sorted=true').pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('PitmasterService.index(): error');

      })
    );
  }

  show(id: number){
    return this.http.get<Pitmaster>(this.url + '/' + id
    + '?sorted=true').pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('PitmasterService.show(): error');
    })
    );
  }
  create(newPitmaster: Pitmaster){
    return this.http.post<Pitmaster>(this.url, newPitmaster).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('PitmasterService.create(): error');
    })
    );
  }

  update(id: number, pitmaster: Pitmaster){
    return this.http.put<Pitmaster>(this.url + '/' + id, pitmaster).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('Pitmasterservice.update(): error');
    })
    );
  }

  delete(id: number){
    return this.http.delete<Pitmaster>(this.url + '/' + id).pipe(
      catchError((err:any)=>{
      console.log(err);
      return throwError('PitmasterService.delete(): error');
    })
    );
  }
}
