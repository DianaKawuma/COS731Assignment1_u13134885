import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import {Food} from "./food";

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class ProductService {
  //URL for CRUD operations
  foodUrl = "http://localhost:9005/api/food";
  clothingUrl = "http://localhost:9005/api/clothing";
  //Create constructor to get Http instance
  constructor(private http:Http) {
  }
  //Fetch all foods
  getAllFoods(): Observable<Food[]> {
    return this.http.get(this.foodUrl+"/")
      .map(this.extractData)
      .catch(this.handleError);

  }
  //Create food
  createFood(food: Food):Observable<number> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: cpHeaders });
    return this.http.post(this.foodUrl+"/", food, options)
      .map(success => success.status)
      .catch(this.handleError);
  }
  //Fetch food by id
  getFoodById(foodId: string): Observable<Food> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: cpHeaders });
    console.log(this.foodUrl +"/"+ foodId);
    return this.http.get(this.foodUrl +"/"+ foodId)
      .map(this.extractData)
      .catch(this.handleError);
  }
  //Update food
  updateFood(food: Food):Observable<number> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: cpHeaders });
    return this.http.put(this.foodUrl +"/"+ food.id, food, options)
      .map(success => success.status)
      .catch(this.handleError);
  }
  //Delete food
  deleteFoodById(foodId: string): Observable<number> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: cpHeaders });
    return this.http.delete(this.foodUrl +"/"+ foodId)
      .map(success => success.status)
      .catch(this.handleError);
  }
  private extractData(res: Response) {
    let body = res.json();
    return body;
  }
  private handleError (error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.status);
  }
}
