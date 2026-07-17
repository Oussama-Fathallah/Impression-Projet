import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MatButtonModule } from '@angular/material/button';
import { FileService, DocumentResponse } from '../../../core/services/file.service';
import { Router } from '@angular/router';



@Component({
selector:'app-upload-page',

standalone:true,

imports:[
 CommonModule,
 MatButtonModule
],

templateUrl:'./upload-page.component.html',

styleUrl:'./upload-page.component.css'

})
export class UploadPageComponent {


fileName = '';

pages = 0;

file!: File;

fileId = 0;



constructor(
 private fileService:FileService,private router:Router
){}




onFileSelected(event:any){


 const selectedFile =
 event.target.files[0];


 if(selectedFile){


   this.file = selectedFile;


   this.fileName =
   this.file.name;


   this.uploadFile();


 }


}





uploadFile(){


 if(!this.file){
   return;
 }



 this.fileService
.upload(this.file)
.subscribe({

  next:(response:DocumentResponse)=>{


    console.log(response);


    this.fileId = response.id;

    this.pages = response.pages;


  },


  error:(error)=>{

    console.error(error);

  }


});


}




continue(){

 this.router.navigate(
   ['/order'],
   {
     state:{
       fileId:this.fileId,
       pages:this.pages
     }
   }
 );

}


}