import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from "@angular/router";
import { AppComponents, AppRoutes } from "./app.routing";

import { AppComponent } from './app.component';
import { ContactComponent } from './contact/contact.component';
import { FoodComponent } from './food/food.component';
import { ClothingComponent } from './clothing/clothing.component';
import { HomeComponent } from './home/home.component';
import { FoodMenuComponent } from './food-menu/food-menu.component';
import { MeatFishPoultryComponent } from './meat-fish-poultry/meat-fish-poultry.component';
import { DiaryEggsMilkComponent } from './diary-eggs-milk/diary-eggs-milk.component';
import { FruitsVegetablesComponent } from './fruits-vegetables/fruits-vegetables.component';
import { DrinksComponent } from './drinks/drinks.component';
import { MenComponent } from './men/men.component';
import { KidsComponent } from './kids/kids.component';

@NgModule({
  declarations: [
    AppComponent,
    ContactComponent,
    FoodComponent,
    ClothingComponent,
    HomeComponent,
    FoodMenuComponent,
    MeatFishPoultryComponent,
    DiaryEggsMilkComponent,
    FruitsVegetablesComponent,
    DrinksComponent,
    MenComponent,
    KidsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    RouterModule.forRoot(AppRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
