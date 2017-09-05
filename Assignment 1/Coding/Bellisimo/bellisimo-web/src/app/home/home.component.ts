import { Component} from '@angular/core';
import { Router, RouterModule } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  title = "Bellisimo is a company that provides an online platform for customers to browse clothing as well as food catalogues provided by the business located in Hatfield";
  constructor(private router: Router) { }
 
    navigate() {
        this.router.navigate(["contact"]);
    }
    refresh(){
      window.location.reload();
    }
}
