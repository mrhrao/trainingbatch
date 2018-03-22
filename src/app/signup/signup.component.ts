import { Component, OnInit } from '@angular/core';
import{MainService}from '../service/mainService'
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private mainService:MainService) { }

  ngOnInit() {
    console.log(this.mainService.obj)
    console.log(this.mainService.succes())
  }

}
