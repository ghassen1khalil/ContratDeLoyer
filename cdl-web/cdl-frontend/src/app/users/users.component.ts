import { Component, OnInit } from '@angular/core';
import {AuthenticationServie} from "../../service/authenticationservice";
import {Router} from "@angular/router";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users;
  constructor(private authService:AuthenticationServie,private router:Router) { }

  ngOnInit() {
    this.authService.getUsers()
      .subscribe(data=> {
        this.users  = data;
      },
      err=>{
        this.router.navigateByUrl('/login')
      })
  }

}
