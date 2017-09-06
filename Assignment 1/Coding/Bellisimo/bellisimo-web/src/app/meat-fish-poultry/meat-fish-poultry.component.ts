import { Component} from '@angular/core';
import { Location} from '@angular/common';
import{NgSwitch} from '@angular/common';

@Component({
  selector: 'app-meat-fish-poultry',
  templateUrl: './meat-fish-poultry.component.html',
  styleUrls: ['./meat-fish-poultry.component.css']
})
export class MeatFishPoultryComponent {
  title = 'meat,fish & poultry';
  meatFishPoultry = [
    { category: 'MeatFishPoultry', categoryType: 'Poultry' , itemName: "Chicken", photolink: "../assets/page3_img4.jpg", price: 50 },
    { category: 'MeatFishPoultry', categoryType: 'Beef' , itemName: "Steak", photolink: "../assets/box_img4.jpg", price: 300},
    { category: 'MeatFishPoultry', categoryType: 'Lamb' , itemName: "Lamb Chops", photolink: "../assets/Lamb-Chopsjpg.jpg", price: 200},
    { category: 'MeatFishPoultry', categoryType: 'Pork' , itemName: "Roasted Pork", photolink: "../assets/Roasted-Pork.jpg", price: 250},
    //{ category: 'MeatFishPoultry', categoryType: 'Rolls' , itemName: "Brown hotdog", photolink: "../assets/page3_img3.jpg", price: 18 },
   //{ category: 'MeatFishPoultry', categoryType: 'Muffins' , itemName: "BlueBerry Muffin", photolink: "../assets/page3_img4.jpg", price: 15 },
    //{ category: 'MeatFishPoultry', categoryType: 'Croissants' , itemName: "Butter Croissants", photolink: "../assets/page3_img5.jpg", price: 16},
    //{ category: 'MeatFishPoultry', categoryType: 'Cake' , itemName: "Red velvet", photolink: "../assets/page3_img6.jpg", price: 40 },
  ];
  desserts = this.meatFishPoultry;
  constructor(private location: Location) { }
  goBack() {
      this.location.back();
  }
  refresh(){
    window.location.reload();
  }
}
