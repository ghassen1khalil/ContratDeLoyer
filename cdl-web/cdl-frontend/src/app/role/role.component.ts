import { Component, OnInit } from '@angular/core';
import {Authentification} from "../../service/authentification";
import {Router} from "@angular/router";
import {RoleService} from "../../service/role.service";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit {
  roles;
  constructor(private roleService:RoleService, private router:Router) { }

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

  onNewRole(){
    this.router.navigateByUrl('/new-role')
  }

}
