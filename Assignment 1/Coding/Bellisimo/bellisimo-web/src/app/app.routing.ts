import { FoodComponent } from './food/food.component';
import { ClothingComponent } from './clothing/clothing.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { FoodMenuComponent } from './food-menu/food-menu.component';
import { MeatFishPoultryComponent } from './meat-fish-poultry/meat-fish-poultry.component';
import { DiaryEggsMilkComponent } from './diary-eggs-milk/diary-eggs-milk.component';
import { FruitsVegetablesComponent } from './fruits-vegetables/fruits-vegetables.component';
import { DrinksComponent } from './drinks/drinks.component';

export const AppRoutes: any = [
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    { path: "contact", component: ContactComponent },
    { path: "CatalogueFood", component: FoodComponent },
    { path: "clothing", component: ClothingComponent },
    { path: "home", component: HomeComponent },
    { path: "foodMenu", component: FoodMenuComponent },
    { path: "MeatFishPoultry", component: MeatFishPoultryComponent },
    { path: "DiaryEggsMilk", component: DiaryEggsMilkComponent },
    { path: "FruitsVegetables", component: FruitsVegetablesComponent },
    { path: "Drinks", component: DrinksComponent },
];
 
export const AppComponents: any = [
    ContactComponent,
    FoodComponent,
    ClothingComponent,
    HomeComponent,
    FoodMenuComponent,
    MeatFishPoultryComponent,
    DiaryEggsMilkComponent,
    FruitsVegetablesComponent,
    DrinksComponent

];
