import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Authentification} from "../../service/authentification";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users;
  constructor(private userService:UserService, private router:Router) { }

  ngOnInit() {

    this.userService.getUsers()
      .subscribe(data=> {
          this.users  = data;
        },
        err=>{
          this.router.navigateByUrl('/login');
        })

  }
  onNewUser(){
    this.router.navigateByUrl('/new-user')
  }

}
