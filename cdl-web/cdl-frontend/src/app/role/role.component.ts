import { Component, OnInit } from '@angular/core';
import {Authentification} from "../../service/authentification";
import {ActivatedRoute, Router} from "@angular/router";
import {RoleService} from "../../service/role.service";
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit {
  roles;
  constructor(private roleService:RoleService, private router:Router) {

  }

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

  OnUpdateRole(idRole:number){
    this.router.navigateByUrl('update-role/'+idRole);
  }

  OnDeleteRole(idRole:number){
    this.roleService.deleteRole(idRole)
      .subscribe(data=> {
          window.location.reload();
        },
        err=>{
          console.log(err);
        })

  }


}
