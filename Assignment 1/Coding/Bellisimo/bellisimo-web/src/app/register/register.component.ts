import { Component, OnInit } from '@angular/core';
import {AlertService} from "../user-service/alert.service";
import {UserService} from "../user-service/user.service";
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {User} from "../user-service/user";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
    model: any = {};
    loading = false;
    statusCode: number;
    //private userService: UserService;
    private router: Router;
    private alertService: AlertService;

    constructor(private userService: UserService) {
    }

    /*foodForm = new FormGroup({
      name: new FormControl('', Validators.required),
      surname: new FormControl('', Validators.required),
      profilePicture: new FormControl('', Validators.required),
      userName: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    }); */

    //user = this.foodForm.value;

      register() {
        this.loading = true;
        this.userService.createUser(this.model)
          .subscribe(
            successCode => {
              this.statusCode = successCode;
              this.router.navigate(['/login']);
            },
            error => {
              this.statusCode = error;
              this.loading = false;
            });
      }

}
