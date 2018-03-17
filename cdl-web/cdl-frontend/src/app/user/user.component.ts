import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Authentification} from "../../service/authentification";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users;
  constructor(private authService:Authentification, private router:Router) { }

  ngOnInit() {

    this.authService.getUsers()
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
