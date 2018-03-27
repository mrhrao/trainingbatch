import { Component, OnInit } from '@angular/core';
import { SignUpService } from './signup.service';
import {MainService} from './../service/mainService'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  private formData:any = {};

  constructor(public signupService: SignUpService,private mainService:MainService) { }

  ngOnInit() {
    this.formData.country = ""
  }
submitLogin()
{ 
  console.log(this.formData)
  this.mainService.submitLogin(this.formData).subscribe(
    succes =>
    {
      console.log("succes",succes);
    })
}

changedValue(country){
   if(country == 'select'){
     alert("country should be there");
   }
}
}
