import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { MatRadioModule } from '@angular/material/radio';
import { MatButtonModule } from '@angular/material/button';

import { Router } from '@angular/router';

import { OrderService } from '../../../core/services/order.service';


@Component({
  selector:'app-order-page',
  standalone:true,

  imports:[
    CommonModule,
    FormsModule,
    MatRadioModule,
    MatButtonModule
  ],

  templateUrl:'./order-page.component.html',
  styleUrl:'./order-page.component.css'
})
export class OrderPageComponent {

success=false;
pages = 0;

fileId = 0;

mode = "bw";

price = 0;



constructor(
 private orderService:OrderService,
 private router:Router
){


 const navigation =
 this.router.getCurrentNavigation();



 if(navigation?.extras.state){


   const data =
   navigation.extras.state;



   this.fileId =
   Number(data['fileId']);



   this.pages =
   Number(data['pages']);



   this.calculate();

 }


}




calculate(){


 if(this.mode === "bw"){


   this.price =
   this.pages * 0.20;


 }
 else{


   this.price =
   this.pages * 1;


 }


}





order(){

 const data={

   fileId:this.fileId,

   mode:this.mode,

   price:this.price

 };


 this.orderService.create(data)

 .subscribe({

  next:(response)=>{

    console.log(
      "Commande créée",
      response
    );

    this.success=true;

      setTimeout(()=>{

    this.router.navigate(['/upload']);

  },2500);

  }

 });

}



}