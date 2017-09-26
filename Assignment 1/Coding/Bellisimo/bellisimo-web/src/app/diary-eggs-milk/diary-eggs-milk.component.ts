import { Component, OnInit } from '@angular/core';
import { Location} from '@angular/common';
import{NgSwitch} from '@angular/common';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import {ProductService} from "../product-service/product.service";
import {Food} from "../product-service/food";

@Component({
  selector: 'app-diary-eggs-milk',
  templateUrl: './diary-eggs-milk.component.html',
  styleUrls: ['./diary-eggs-milk.component.css']
})
export class DiaryEggsMilkComponent implements OnInit {
  //===============================================================================
                            //Food Section
  //===============================================================================
  //Component properties
  allFoods: Food[];
  statusCode: number;
  requestProcessing = false;
  foodIdToUpdate = null;
  processValidation = false;
  //Create form
  foodForm = new FormGroup({
    itemName: new FormControl('', Validators.required),
    price: new FormControl('', Validators.required),
    photolink: new FormControl('', Validators.required),
    category: new FormControl('', Validators.required),
    categoryType: new FormControl('', Validators.required)
  });
  //Create constructor to get service instance
  constructor(private productService: ProductService) {
  }
  //Create ngOnInit() and and load foods
  ngOnInit(): void {
    this.getAllFoods();
  }
  //Fetch all foods
  getAllFoods() {
    this.productService.getAllFoods()
      .subscribe(
        data => this.allFoods = data,
        errorCode =>  this.statusCode = errorCode);
  }
  //Handle create and update food
  onFoodFormSubmit() {
    this.processValidation = true;
    if (this.foodForm.invalid) {
      return; //Validation failed, exit from method.
    }
    //Form is valid, now perform create or update
    this.preProcessConfigurations();
    let food = this.foodForm.value;
    if (this.foodIdToUpdate === null) {
      //Generate food id then create food
      this.productService.getAllFoods()
        .subscribe(foods => {

          //Generate food id
          let maxIndex = foods.length - 1;
          let foodWithMaxIndex = foods[maxIndex];
          let foodId = foodWithMaxIndex.id + 1;
          food.id = foodId;

          //Create food
          this.productService.createFood(food)
            .subscribe(successCode => {
                this.statusCode = successCode;
                this.getAllFoods();
                this.backToCreateFood();
              },
              errorCode => this.statusCode = errorCode
            );
        });
    } else {
      //Handle update food
      food.id = this.foodIdToUpdate;
      this.productService.updateFood(food)
        .subscribe(successCode => {
            this.statusCode = successCode;
            this.getAllFoods();
            this.backToCreateFood();
          },
          errorCode => this.statusCode = errorCode);
    }
  }
  //Load food by id to edit
  loadFoodToEdit(foodId: string) {
    this.preProcessConfigurations();
    this.productService.getFoodById(foodId)
      .subscribe(food => {
          this.foodIdToUpdate = food.id;
          this.foodForm.setValue({ title: food.itemName, price: food.price, photolink: food.photolink, category: food.category, categoryType: food.categoryType});
          this.processValidation = true;
          this.requestProcessing = false;
        },
        errorCode =>  this.statusCode = errorCode);
  }
  //Delete food
  deleteFood(foodId: string) {
    this.preProcessConfigurations();
    this.productService.deleteFoodById(foodId)
      .subscribe(successCode => {
          //this.statusCode = successCode;
          //Expecting success code 204 from server
          this.statusCode = 204;
          this.getAllFoods();
          this.backToCreateFood();
        },
        errorCode => this.statusCode = errorCode);
  }
  //Perform preliminary processing configurations
  preProcessConfigurations() {
    this.statusCode = null;
    this.requestProcessing = true;
  }
  //Go back from update to create
  backToCreateFood() {
    this.foodIdToUpdate = null;
    this.foodForm.reset();
    this.processValidation = false;
  }

//===============================================================================
                          //Clothing Section
//===============================================================================


  /*diaryEggsMilk = [
      { category: 'DiaryEggsMilk', categoryType: 'Fresh Milk' , itemName: "Fullcream Milk", photolink: "../assets/fullcream.jpg", price: 15 },
      { category: 'DiaryEggsMilk', categoryType: 'Cheese' , itemName: "Chedder Cheese", photolink: "../assets/fullcream.jpg", price: 30 },
      { category: 'DiaryEggsMilk', categoryType: 'Cheese' , itemName: "Blue Cheese", photolink: "../assets/BlueCheese.jpg", price: 14 },
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
    } */

}
