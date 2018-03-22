import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule,Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import {AccordionModule} from 'primeng/accordion';     
import {MenuItem} from 'primeng/api';                
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import{MainService}from './service/mainService'
import { BuyComponent } from './buy/buy.component';
import { SellComponent } from './sell/sell.component';
import { SettingComponent } from './setting/setting.component';


const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'forgotPassword', component:ForgotPasswordComponent},
  { path: 'resetPassword', component:ResetPasswordComponent  },
  { path: 'sell', component: SellComponent },
  { path: 'buy', component:BuyComponent},
  { path: 'setting', component:SettingComponent  },
   
   
  { path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  { path: '**', component: LoginComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    DashboardComponent,
    ResetPasswordComponent,
    ForgotPasswordComponent,
    
   
    BuyComponent,
    SellComponent,
    SettingComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    BrowserAnimationsModule,
  ],
  providers: [MainService],
  bootstrap: [AppComponent]
})
export class AppModule { }
