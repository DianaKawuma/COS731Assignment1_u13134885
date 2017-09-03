import { FoodComponent } from './food/food.component';
import { ClothingComponent } from './clothing/clothing.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';

export const AppRoutes: any = [
    { path: "contact", component: ContactComponent },
    { path: "food", component: FoodComponent },
    { path: "clothing", component: ClothingComponent },
    { path: "home", component: HomeComponent },
];
 
export const AppComponents: any = [
    ContactComponent,
    FoodComponent,
    ClothingComponent,
    HomeComponent
];
