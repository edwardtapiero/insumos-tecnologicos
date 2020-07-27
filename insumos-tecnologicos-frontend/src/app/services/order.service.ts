import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import {Observable, of} from 'rxjs';
import {Order} from '../models/Order';
import {apiUrl} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private orderUrl = `${apiUrl}/order`;

  constructor(private http: HttpClient) {
  }

  getPage(page = 1, size = 10): Observable<any> {
    return this.http.get(`${this.orderUrl}?page=${page}&size=${size}`).pipe();
  }

  show(id): Observable<Order> {
    return this.http.get<Order>(`${this.orderUrl}/${id}`).pipe(
      catchError(_ => of(null))
    );
  }

  cancel(id): Observable<Order> {
    return this.http.patch<Order>(`${this.orderUrl}/cancel/${id}`, null).pipe(
      catchError(_ => of(null))
    );
  }

  authorized(id): Observable<Order> {
    return this.http.patch<Order>(`${this.orderUrl}/authorized/${id}`, null).pipe(
      catchError(_ => of(null))
    );
  }

  received(id): Observable<Order> {
    return this.http.patch<Order>(`${this.orderUrl}/received/${id}`, null).pipe(
      catchError(_ => of(null))
    );
  }
}
