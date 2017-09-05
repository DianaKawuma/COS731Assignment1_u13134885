import { Component} from '@angular/core';
import { Location} from '@angular/common';

@Component({
  selector: 'app-food-menu',
  templateUrl: './food-menu.component.html',
  styleUrls: ['./food-menu.component.css']
})
export class FoodMenuComponent {

 title = 'FoodMenu';
  constructor(private location: Location) { }
 
    goBack() {
        this.location.back();
    }
    refresh(){
      window.location.reload();
    }

}
