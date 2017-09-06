import { Component, OnInit } from '@angular/core';
import { Location} from '@angular/common';
import{NgSwitch} from '@angular/common';

@Component({
  selector: 'app-kids',
  templateUrl: './kids.component.html',
  styleUrls: ['./kids.component.css']
})
export class KidsComponent  {

  kids = [
    { Gender: 'Boy', category: 'Clothing', categoryType: 'Shorts' , itemName: "Puma boy shorts", photolink: "../assets/puma-boys-basic-shorts-big-kid.jpg", price: 100 },
    { Gender: 'Girl', category: 'Accessories', categoryType: 'Jewellery' , itemName: "Heart Pendant Necklace ", photolink: "../assets/heart-pendant-necklace-girls.jpg", price: 50 },
    { Gender: 'Boy', category: 'Shoes', categoryType: 'Sneakers' , itemName: "Boy Sneakers", photolink: "../assets/gucci-new-ace-gg-tennis-shoe-youth.jpg", price: 200},
    { Gender: 'Boy', category: 'Clothing', categoryType: 'Tops' , itemName: "Boy Shirt", photolink: "../assets/shirt-blue-size-2-14.jpg", price: 250 },
    { Gender: 'Girl', category: 'Clothing', categoryType: 'Dresses & Skirts' , itemName: "Fitch Shoulder Dress", photolink: "../assets/abercrombie-fitch-cold-shoulder-dress.jpg", price: 350},
    { Gender: 'Girl', category: 'Shoes', categoryType: 'Boots' , itemName: "Quilted gloss rain boots", photolink: "../assets/quilted-gloss-rain-boots.jpg", price: 400 },
  ];
  desserts = this.kids;
  constructor(private location: Location) { }
  goBack() {
      this.location.back();
  }
  refresh(){
    window.location.reload();
  }

}
