import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class RegistrationService {
  
  private http: HttpClient = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/v1/customers';

  saveCustomer(data: any): Observable<any> {
    return this.http.post(this.apiUrl, data);
  }

  getCustomers(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}
