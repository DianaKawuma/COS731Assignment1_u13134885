import { Component, Directive} from '@angular/core';
import { Location} from '@angular/common';
import{NgSwitch} from '@angular/common';

@Component({
  selector: 'app-food-menu',
  templateUrl: './food-menu.component.html',
  styleUrls: ['./food-menu.component.css']
})
export class FoodMenuComponent {
 itemName: string;
 price: number;
 photolink: string;
 category: string;
 categoryType: string;
//foodTest: any[];  

 dessert = [
    { category: 'Desserts', categoryType: 'Scone' , itemName: "Banna Scone", photolink: "../assets/page3_img1.jpg", price: 20 },
    { category: 'Desserts', categoryType: 'Cake' , itemName: "Black Forrest", photolink: "../assets/box_img2.jpg", price: 50 },
    { category: 'Desserts', categoryType: 'Rolls' , itemName: "Brown hotdog", photolink: "../assets/box_img3.jpg", price: 18 },
    { category: 'Desserts', categoryType: 'Muffins' , itemName: "BlueBerry Muffin", photolink: "../assets/box_img4.jpg", price: 15 },
    { category: 'Desserts', categoryType: 'Croissants' , itemName: "Butter Croissants", photolink: "../assets/box_img1.jpg", price: 16},
    { category: 'Desserts', categoryType: 'Cake' , itemName: "Red velvet", photolink: "../assets/page3_img2.jpg", price: 40 },
  ];
  desserts = this.dessert;

  title = 'FoodMenu';
  constructor(private location: Location) { }
  goBack() {
      this.location.back();
  }
  refresh(){
    window.location.reload();
  }
  

    
}
/*@Directive({selector: '[ngSwitch]'})
class ngSwitch{
  set ngSwitch(newValue: any){}
} */

