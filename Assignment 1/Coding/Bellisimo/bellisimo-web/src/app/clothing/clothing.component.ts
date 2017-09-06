import { Component, OnInit } from '@angular/core';
import { Location} from '@angular/common';
import{NgSwitch} from '@angular/common';

@Component({
  selector: 'app-clothing',
  templateUrl: './clothing.component.html',
  styleUrls: ['./clothing.component.css']
})
export class ClothingComponent {
  women = [
    { Gender: 'Women', category: 'Clothing', categoryType: 'Dresses' , itemName: "Minni Dress", photolink: "../assets/1.jpg", price: 100 },
    { Gender: 'Women', category: 'Accessories', categoryType: 'Jewellery' , itemName: "3 Pack Hoop Earings", photolink: "../assets/gold-embellished-hoop-earrings-3-pack.jpg", price: 50 },
    { Gender: 'Women', category: 'Shoes', categoryType: 'Heels&Wedges' , itemName: "High Heels", photolink: "../assets/Heels.jpg", price: 200},
    { Gender: 'Women', category: 'Clothing', categoryType: 'Dresses' , itemName: "Long Dress", photolink: "../assets/long-dress.jpg", price: 250 },
    { Gender: 'Women', category: 'Clothing', categoryType: 'Dresses' , itemName: "Cocktail Dress", photolink: "../assets/project_img3.jpg", price: 350},
    { Gender: 'Women', category: 'Shoes', categoryType: 'Boots' , itemName: "Leather Boots", photolink: "../assets/boots.jpg", price: 400 },
  ];
  desserts = this.women;
  constructor(private location: Location) { }
  goBack() {
      this.location.back();
  }
  refresh(){
    window.location.reload();
  }
}
