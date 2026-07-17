import { Routes } from '@angular/router';

import { authGuard } from './core/guards/auth.guard';

import { LoginComponent } 
from './features/auth/login/login.component';

import { OrderPageComponent } 
from './features/order/order-page/order-page.component';

import { UploadPageComponent } 
from './features/upload/upload-page/upload-page.component';



export const routes: Routes = [


{
  path: '',
  redirectTo: 'login',
  pathMatch: 'full'
},


{
  path:'login',
  component:LoginComponent
},


{
  path:'upload',
  component:UploadPageComponent,
  canActivate:[authGuard]
},


{
  path:'order',
  component:OrderPageComponent,
  canActivate:[authGuard]
},


{
  path:'**',
  redirectTo:'login'
}


];