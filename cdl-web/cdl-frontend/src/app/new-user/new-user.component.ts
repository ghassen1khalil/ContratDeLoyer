import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../../service/user.service";
import {RoleService} from "../../service/role.service";

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit {
  roles:any;
  newUser:any
  constructor(private roleService:RoleService,private userService:UserService , private router:Router ) { }

  ngOnInit() {
    this.roleService.getRoles()
      .subscribe(data=> {
          this.roles  = data;
          console.log(this.roles)
        },
        err=>{
          console.log(err);
        })
  }

  onSaveUser(user) {
    this.newUser = {
      userName: user.userName,
      password: user.password,
      role:{"idRole": user.idRole}
    }
    this.userService.saveUser(this.newUser)
      .subscribe(resp => {
        this.newUser = resp;
        console.log(resp)
      }, err => {

        console.log(resp);
      })
  }

}
