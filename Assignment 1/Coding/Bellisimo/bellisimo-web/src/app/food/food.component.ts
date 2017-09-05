import { Component} from '@angular/core';
import { Location} from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { Directive,ElementRef, Input} from '@angular/core';
declare var $: any;

@Component({
  selector: 'app-food',
  templateUrl: './food.component.html',
  styleUrls: ['./food.component.css']
})
export class FoodComponent {

  title = 'Food';
  constructor(private location: Location,private router: Router) { }
    
    goBack() {
        this.location.back();
    }
    refresh(){
      window.location.reload();
    }
        navigate() {
        this.router.navigate(["foodMenu"]);
    }

}
@Directive({ selector: '[myTest]' })
export class TestDirective{
  contructor(){
      $(document).ready(function(){ 
    $(".bt-menu-trigger").toggle( 
    function(){
      $('.bt-menu').addClass('bt-menu-open'); 
    }, 
    function(){
      $('.bt-menu').removeClass('bt-menu-open'); 
    } 
  ); 
}) 
  }
}

 