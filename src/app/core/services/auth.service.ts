import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';


export interface LoginRequest {
  email:string;
  password:string;
}


export interface LoginResponse {
  token:string;
}



@Injectable({
  providedIn:'root'
})
export class AuthService {


  private api =
    'http://localhost:8080/api/auth';



  constructor(
    private http:HttpClient
  ){}



  login(
    data:LoginRequest
  ):Observable<LoginResponse>{


    return this.http.post<LoginResponse>(
      `${this.api}/login`,
      data
    )
    .pipe(

      tap(response=>{

        localStorage.setItem(
          'token',
          response.token
        );

      })

    );


  }




  register(
    data:LoginRequest
  ){


    return this.http.post(
      `${this.api}/register`,
      data,
      {
        responseType:'text'
      }
    );


  }




  logout(){

    localStorage.removeItem(
      'token'
    );

  }




  isLoggedIn():boolean{

    return !!localStorage.getItem(
      'token'
    );

  }



  getToken(){

    return localStorage.getItem(
      'token'
    );

  }



}