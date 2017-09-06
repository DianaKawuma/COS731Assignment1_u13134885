import { Component, OnInit } from '@angular/core';
import { Location} from '@angular/common';
import{NgSwitch} from '@angular/common';

@Component({
  selector: 'app-diary-eggs-milk',
  templateUrl: './diary-eggs-milk.component.html',
  styleUrls: ['./diary-eggs-milk.component.css']
})
export class DiaryEggsMilkComponent{
diaryEggsMilk = [
    { category: 'DiaryEggsMilk', categoryType: 'Fresh Milk' , itemName: "Fullcream Milk", photolink: "../assets/fullcream.jpg", price: 15 },
    { category: 'DiaryEggsMilk', categoryType: 'Cheese' , itemName: "Chedder Cheese", photolink: "../assets/chedderCheese.jpg", price: 30 },
    { category: 'DiaryEggsMilk', categoryType: 'Cheess' , itemName: "Blue Cheese", photolink: "../assets/BlueCheese.jpg", price: 14 },
    { category: 'DiaryEggsMilk', categoryType: 'Yogurt' , itemName: "Double Cream", photolink: "../assets/yogurt.jpg", price: 15 },
    //{ category: 'diaryEggsMilk', categoryType: 'Croissants' , itemName: "Butter Croissants", photolink: "../assets/page3_img5.jpg", price: 16},
    //{ category: 'MeatFishPoultry', categoryType: 'Cake' , itemName: "Red velvet", photolink: "../assets/page3_img6.jpg", price: 40 },
  ];
  desserts = this.diaryEggsMilk;
   constructor(private location: Location) { }
  goBack() {
      this.location.back();
  }
  refresh(){
    window.location.reload();
  }
  
}
