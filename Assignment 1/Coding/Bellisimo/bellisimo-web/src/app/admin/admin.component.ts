import { Component, OnInit } from '@angular/core';
import { Location} from '@angular/common';
import{NgSwitch} from '@angular/common';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  userNameholder = "Enter Username";
  passwordholder = "Enter Passoword";
  constructor(private location: Location) { }
  goBack() {
      this.location.back();
  }
  refresh(){
    window.location.reload();
  }

}
