import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MainService } from './../service/mainService'
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private SignInData: any = {};
  constructor(private mainService:MainService, private router:Router) { }

  ngOnInit() {
    console.log(this.mainService.obj);
    console.log(this.mainService.succes());
    this.mainService.overallDetails().subscribe(
      succes=>
      {
        console.log('succes',succes)
      })
  }

  submitSignin() {
    this.mainService.submitSignin(this.SignInData).subscribe(
      succes=>
      {
        this.router.navigate(['/dashboard']);
        console.log('succes',succes)
      })
  }
}
