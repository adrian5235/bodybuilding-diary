import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PhaseService {

  private baseUrl = 'http://localhost:8080/phases';
  phase = {};

  constructor(private http: HttpClient) {
    
  }

  savePhase(phase: any) {
    return this.http.post<any>(this.baseUrl, phase);
  }

  getAllPhases() {
    return this.http.get<any>(this.baseUrl);
  }

  getPhase(id: number) {
    return this.http.get<any>(this.baseUrl + "/" + id);
  }
}
