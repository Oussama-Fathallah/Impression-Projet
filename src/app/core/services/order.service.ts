import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Injectable({
providedIn:'root'
})
export class OrderService {


private api =
'http://localhost:8080/api/orders';



constructor(
private http:HttpClient
){}




create(order:any){


 return this.http.post(
  this.api,
  order
 );


}




getMyOrders(){


 return this.http.get(
  this.api
 );


}



}