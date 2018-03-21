import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { SettingComponent } from './setting/setting.component';
import { BuyComponent } from './buy/buy.component';
import { SellComponent } from './sell/sell.component';
import { SubmitComponent } from './submit/submit.component';


const appRoutes: Routes = [
  { path: 'signup', component: SignupComponent },
   { path: 'login', component: LoginComponent },
   { path: 'dashboard', component: DashboardComponent },
   { path: 'resetPassword', component: ResetPasswordComponent },
   { path: 'forgetPassword', component: ForgetPasswordComponent },
   { path: 'setting', component: SettingComponent },
   { path: 'buy', component: BuyComponent },
   { path: 'sell', component: SellComponent },
  { path: '',
    redirectTo: '/signup',
    pathMatch: 'full'
  },
  { path: '**', component: LoginComponent }
];


@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    DashboardComponent,
    ResetPasswordComponent,
    ForgetPasswordComponent,
    SettingComponent,
    BuyComponent,
    SellComponent,
    SubmitComponent
  ],
  
  imports: [
    BrowserModule,
    RouterModule.forRoot(

      appRoutes,
      // { enableTracing: true } // <-- debugging purposes only
    ),
    // other imports here
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
