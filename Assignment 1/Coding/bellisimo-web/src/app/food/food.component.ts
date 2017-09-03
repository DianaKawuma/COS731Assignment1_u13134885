import { Component} from '@angular/core';
import { Location} from '@angular/common';
import { Directive,ElementRef, Input} from '@angular/core';
declare var $: any;

@Component({
  selector: 'app-food',
  templateUrl: './food.component.html',
  styleUrls: ['./food.component.css']
})
export class FoodComponent {

  title = 'Food';
  constructor(private location: Location) { }
 
    goBack() {
        this.location.back();
    }
    refresh(){
      window.location.reload();
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

 