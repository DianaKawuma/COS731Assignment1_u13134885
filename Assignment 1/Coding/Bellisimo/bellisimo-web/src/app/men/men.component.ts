import { Component, OnInit } from '@angular/core';
import { Location} from '@angular/common';
import{NgSwitch} from '@angular/common';

@Component({
  selector: 'app-men',
  templateUrl: './men.component.html',
  styleUrls: ['./men.component.css']
})
export class MenComponent {

  men = [
    { Gender: 'Men', category: 'Clothing', categoryType: 'Shirts' , itemName: "Grey Shirt", photolink: "../assets/gray-polyester-shirts.jpg", price: 100 },
    { Gender: 'Men', category: 'Accessories', categoryType: 'Watches' , itemName: "Blue Watch", photolink: "../assets/blue-mens-watches.jpg", price: 350 },
    { Gender: 'Men', category: 'Shoes', categoryType: 'Sneakers' , itemName: "Grey Sneaker", photolink: "../assets/gray-sneakers.jpg", price: 300},
    { Gender: 'Men', category: 'Clothing', categoryType: 'T-Shirts' , itemName: "T-Shirt", photolink: "../assets/logo-print-t-shirt.jpg", price: 250 },
    { Gender: 'Men', category: 'Clothing', categoryType: 'Shorts' , itemName: "Grey Short", photolink: "../assets/men-grey-ash-42.jpg", price: 150},
    { Gender: 'Men', category: 'Shoes', categoryType: 'Sandels' , itemName: "Leather Sandel", photolink: "../assets/leather-thong-sandals.jpg", price: 400 },
  ];
  desserts = this.men;
  constructor(private location: Location) { }
  goBack() {
      this.location.back();
  }
  refresh(){
    window.location.reload();
  }

}
