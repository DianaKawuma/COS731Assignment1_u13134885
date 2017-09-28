import { Injectable } from '@angular/core';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import {User} from "./user";

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class UserService {
  //URL for CRUD operations
  userUrl = "http://localhost:9005/api/user";
  //Create constructor to get Http instance
  constructor(private http:Http) {
  }

  //Create user
  createUser(user: User):Observable<number> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: cpHeaders });
    return this.http.post(this.userUrl+"/", user, options)
      .map(success => success.status)
      .catch(this.handleError);
  }
  //Fetch user by id
  getUserById(userId: string): Observable<User> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: cpHeaders });
    console.log(this.userUrl +"/"+ userId);
    return this.http.get(this.userUrl +"/"+ userId)
      .map(this.extractData)
      .catch(this.handleError);
  }
  //Update user
  updateUser(user: User):Observable<number> {
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: cpHeaders });
    return this.http.put(this.userUrl +"/"+ user.id, user, options)
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
