import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
  private idUser;
  public user;
  constructor(public activatedRoute:ActivatedRoute,public userService:UserService,public route:Router) {
    this.idUser=activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.userService.getUser(this.idUser)
      .subscribe(data=>{
          this.user=data;
        },
        err=>{
          console.log(this.user);
        });
  }

  updateUser(){
    this.userService.updateUser(this.user)
      .subscribe(data=>{
          alert("Update Successfully")
          this.route.navigateByUrl("/user");
        },
        err=>{
          console.log(this.user);
          alert("Error ");
        });
  }

  deleteUser(){
    this.userService.deleteUser(this.user)
      .subscribe(data=>{
          alert("delete Successfully")
          this.route.navigateByUrl("/user");
        },
        err=>{
          console.log(this.user);
          alert("Error ");
        });
  }



}
