import { FoodComponent } from './food/food.component';
import { ClothingComponent } from './clothing/clothing.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { FoodMenuComponent } from './food-menu/food-menu.component';

export const AppRoutes: any = [
    { path: "contact", component: ContactComponent },
    { path: "CatalogueFood", component: FoodComponent },
    { path: "clothing", component: ClothingComponent },
    { path: "home", component: HomeComponent },
    { path: "foodMenu", component: FoodMenuComponent },
];
 
export const AppComponents: any = [
    ContactComponent,
    FoodComponent,
    ClothingComponent,
    HomeComponent,
    FoodMenuComponent
];
