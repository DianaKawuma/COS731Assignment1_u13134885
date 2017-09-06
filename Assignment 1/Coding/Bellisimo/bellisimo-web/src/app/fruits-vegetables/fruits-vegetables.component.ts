import { Component, OnInit } from '@angular/core';
import { Location} from '@angular/common';
import{NgSwitch} from '@angular/common';

@Component({
  selector: 'app-fruits-vegetables',
  templateUrl: './fruits-vegetables.component.html',
  styleUrls: ['./fruits-vegetables.component.css']
})
export class FruitsVegetablesComponent{
  fruitsVegetables = [
    { category: 'FruitsVegetables', categoryType: 'FreshFruit' , itemName: "Apple", photolink: "../assets/apple.jpg", price: 10},
    { category: 'FruitsVegetables', categoryType: 'FreshVegetables' , itemName: "Sweet Potatoes", photolink: "../assets/sweetPotato.jpg", price: 12},
    { category: 'FruitsVegetables', categoryType: 'FreshVegetables' , itemName: "Tomatoes", photolink: "../assets/Pink-Bumblebee.jpg", price: 10},
    { category: 'FruitsVegetables', categoryType: 'FreshFruit' , itemName: "Bananas", photolink: "../assets/bananas.jpg", price: 12},
   // { category: 'FruitsVegetables', categoryType: 'Croissants' , itemName: "Butter Croissants", photolink: "../assets/box_img1.jpg", price: 16},
    //{ category: 'FruitsVegetables', categoryType: 'Cake' , itemName: "Red velvet", photolink: "../assets/page3_img2.jpg", price: 40 },
  ];
  desserts = this.fruitsVegetables;
  constructor(private location: Location) { }
  goBack() {
      this.location.back();
  }
  refresh(){
    window.location.reload();
  }
  

}
