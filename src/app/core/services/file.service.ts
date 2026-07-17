import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export interface DocumentResponse {

  id:number;
  fileName:string;
  filePath:string;
  pages:number;

}



@Injectable({
 providedIn:'root'
})
export class FileService {


 private api =
 'http://localhost:8080/api/files';



 constructor(
  private http:HttpClient
 ){}



 upload(file:File){


   const formData = new FormData();


   formData.append(
    'file',
    file
   );



   return this.http.post<DocumentResponse>(
    `${this.api}/upload`,
    formData
   );


 }



}