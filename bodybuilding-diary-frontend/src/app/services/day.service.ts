import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DayService {

  private baseUrl = 'http://localhost:8080/days';
  phase: any;

  constructor(private http: HttpClient) {
    
  }

  saveDay(day: any) {
    return this.http.post<any>(this.baseUrl, day);
  }

  deleteDay(dayId: number) {
    return this.http.delete<any>(this.baseUrl + "/" + dayId);
  }
}
