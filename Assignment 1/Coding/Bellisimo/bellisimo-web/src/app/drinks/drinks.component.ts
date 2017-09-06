import { Component, OnInit } from '@angular/core';
import { Location} from '@angular/common';
import{NgSwitch} from '@angular/common';

@Component({
  selector: 'app-drinks',
  templateUrl: './drinks.component.html',
  styleUrls: ['./drinks.component.css']
})
export class DrinksComponent {

drinks = [
    { category: 'Drinks', categoryType: 'Juices' , itemName: "Orange Juice", photolink: "../assets/OrangeJuice.jpg", price: 25 },
    { category: 'Drinks', categoryType: 'Sodas' , itemName: "Fanta Orange", photolink: "../assets/fantaOrange.jpg", price: 18 },
    { category: 'Drinks', categoryType: 'Water' , itemName: "Still Spring Water", photolink: "../assets/water.jpg", price: 30 },
    { category: 'Drinks', categoryType: 'Iced Tea' , itemName: "lemon Ice Tea", photolink: "../assets/icedTea.jpg", price: 22 },
    //{ category: 'Drinks', categoryType: 'Croissants' , itemName: "Butter Croissants", photolink: "../assets/box_img1.jpg", price: 16},
    //{ category: 'Drinks', categoryType: 'Cake' , itemName: "Red velvet", photolink: "../assets/page3_img2.jpg", price: 40 },
  ];
  desserts = this.drinks;
  constructor(private location: Location) { }
  goBack() {
      this.location.back();
  }
  refresh(){
    window.location.reload();
  }

}
