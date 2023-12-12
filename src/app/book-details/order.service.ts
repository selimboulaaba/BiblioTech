import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { order } from '../models/order';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private baseUrl = 'http://localhost:8081/ORDER'

  constructor(private http: HttpClient) { }

  getallbooks(): Observable<order[]> {
    return this.http.get<order[]>(this.baseUrl+"/findAllOrder");
  }

  post(order: order): Observable<order> {

    const params = new HttpParams()
      .set('idUser', order.idUser)
      .set('idBook', order.idBook)
      .set('pickupDate', order.pickupDate.toString())
      .set('returnDate', order.returnDate.toString())
      .set('orderStatus', order.orderStatus);
    return this.http.get<order>(this.baseUrl+"/addOrder", {params});
  }

}
