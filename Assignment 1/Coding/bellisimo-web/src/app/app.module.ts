import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from "@angular/router";
import { AppComponents, AppRoutes } from "./app.routing";

import { AppComponent } from './app.component';
import { ContactComponent } from './contact/contact.component';
import { FoodComponent } from './food/food.component';
import { ClothingComponent } from './clothing/clothing.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    ContactComponent,
    FoodComponent,
    ClothingComponent,
    HomeComponent
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
