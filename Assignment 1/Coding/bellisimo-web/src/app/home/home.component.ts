import { Component} from '@angular/core';
import { Router, RouterModule } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(private router: Router) { }
 
    navigate() {
        this.router.navigate(["contact"]);
    }
    refresh(){
      window.location.reload();
    }
}
