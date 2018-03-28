import { Component, OnInit } from '@angular/core';
import { MainService } from './../service/mainService';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {

 private formData: any = {}; 
      constructor(private mainService:MainService) { } 

  ngOnInit() { console.log(this.mainService.obj); 
  
    console.log(this.mainService.succes()); 
    
    this.mainService.overallDetails().subscribe
    (
       succes=> { console.log('succes',succes
      ) 
    }) 
 } 
 ForgetPasswordComponent() {
console.log(this.formData) 
} 
}

