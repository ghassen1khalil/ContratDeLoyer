import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../../service/user.service";
import {RoleService} from "../../service/role.service";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users;
  newUser;
  constructor(private userService:UserService, private router:Router) { }

  ngOnInit() {

    this.userService.getUsers()
      .subscribe(data=> {
          this.users  = data;
          console.log(this.users);
        },
        err=>{
          this.router.navigateByUrl('/login');
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
          this.router.navigateByUrl('/user');
        },
        err => {
          console.log(err);
        })
  }

  OnUpdateUser(idUser:number){
    this.router.navigateByUrl('update-user/'+idUser);
  }

  OnDeleteUser(idUser:number){
    this.userService.deleteUser(idUser)
      .subscribe(data=> {
          window.location.reload();
        },
        err=>{
          console.log(err);
        })

  }



}
