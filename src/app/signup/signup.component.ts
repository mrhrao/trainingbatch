import { Component, OnInit } from '@angular/core';
import { SignUpService } from './signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  private formData:any = {};

  constructor(public signupService: SignUpService) { }

  ngOnInit() {
    this.formData.country = ""
  }
submitLogin()
{
  this.signupService.submitLogin(this.formData).then(response => {
    if (response) {
      //  this.data = response.data.data;
    } else if (response) {
        // 
    }
});
}

changedValue(country){
   if(country == 'select'){
     alert("country should be there");
   }
}
}
