import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { StorageService } from '../../storage/storage.service';
import { map, tap } from 'rxjs';

const BASIC_URL = ['http://localhost:8080/']
export const AUTH_HEADER = "authorization";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private storage: StorageService) { }

  login(email: string, password: string): Observable<any> {

    let headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post(
      BASIC_URL + 'api/v1/auth/authenticate',
      { email, password },
      { headers, responseType: 'text', observe: 'response' }
    )
      .pipe(
        tap(__ => this.log("User Authorization")),
        map((res: HttpResponse<any>) => {
          let body: JSON = JSON.parse(res.body);
          this.storage.saveUser(body['name']);
          this.storage.saveToken(body['jwt']);
          return res;
        }))
  }

  log(message: string) {
    console.log(message);
  }
}


