
import { Component, OnInit } from '@angular/core';
import { MainService } from './../service/mainService'
@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  private formData: any = {};
  constructor(private mainService:MainService) { }

  ngOnInit() {
    console.log(this.mainService.obj);
    console.log(this.mainService.succes());
    this.mainService.overallDetails().subscribe(
      succes=>
      {
        console.log('succes',succes)
      })
  }

  submitLogin() {
    console.log(this.formData)
  }
}
