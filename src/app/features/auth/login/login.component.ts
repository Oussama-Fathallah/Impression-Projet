import { Component } from '@angular/core';
import { AuthService } from '../../../core/services/auth.service';
import { Router } from '@angular/router';
import { FormBuilder, ReactiveFormsModule, Validators  } from '@angular/forms';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatSnackBarModule } from '@angular/material/snack-bar';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSnackBarModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {


  loginForm;


constructor(
  private fb: FormBuilder,
  private auth: AuthService,
  private router: Router,
  private snackBar: MatSnackBar
){

    this.loginForm = this.fb.nonNullable.group({

    email: ['', Validators.required],
    password: ['', Validators.required]

  });

  }



login(){

  this.auth.login(this.loginForm.getRawValue())
  .subscribe({

    next:(response)=>{


      localStorage.setItem(
        'token',
        response.token
      );


this.snackBar.open(
  'Connexion réussie ✅',
  'Fermer',
  {
    duration:3000,
    horizontalPosition:'right',
    verticalPosition:'top',
    panelClass:'success-snackbar'
  }
);


      setTimeout(()=>{

        this.router.navigate(['/upload']);

      },1500);



    },


    error:(err)=>{


this.snackBar.open(
  'Email ou mot de passe incorrect ❌',
  'Fermer',
  {
    duration:3000,
    horizontalPosition:'right',
    verticalPosition:'top',
    panelClass:'error-snackbar'
  }
);


    }


  });


}


}