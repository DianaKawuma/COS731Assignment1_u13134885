import { Component} from '@angular/core';
import { Location} from '@angular/common';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  title = 'Contact Us';
  constructor(private location: Location) { }
 
    goBack() {
        this.location.back();
    }
    refresh(){
      window.location.reload();
    }

}
