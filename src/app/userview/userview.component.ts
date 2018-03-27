import { Component, OnInit, AfterViewInit } from '@angular/core';

@Component({
  selector: 'app-userview',
  templateUrl: './userview.component.html',
  styleUrls: ['./userview.component.css']
})
export class UserviewComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    !function ($) {
      $(document).on("click","#left ul.nav li.parent > a > span.sign", function(){          
          $(this).find('i:first').toggleClass("icon-minus");      
      }); 
      // Open Le current menu
      $("#left ul.nav li.parent.active > a > span.sign").find('i:first').addClass("icon-minus");
      $("#left ul.nav li.current").parents('ul.children').addClass("in");
  
  };
  }
}
