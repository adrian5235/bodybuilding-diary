import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthenticationRequest } from '../models/authentication-request';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private baseUrl = 'http://localhost:8080/auth';

  constructor(private http: HttpClient) { }

  authenticate(authenticationRequest: AuthenticationRequest) {
    return this.http.post<any>(this.baseUrl + '/authenticate', authenticationRequest);
  }
}
