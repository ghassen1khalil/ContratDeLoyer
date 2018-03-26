import { Component, OnInit } from '@angular/core';
import {Authentification} from "../../service/authentification";
import {RoleService} from "../../service/role.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-role',
  templateUrl: './new-role.component.html',
  styleUrls: ['./new-role.component.css']
})
export class NewRoleComponent implements OnInit {
  roleName:any;
  constructor(private roleService:RoleService,private router:Router) { }

  ngOnInit() {
  }

  onSaveRole(role) {
    this.roleService.saveRole(role)
      .subscribe(resp => {
        this.roleName = resp;
        this.router.navigateByUrl('/role');
      }, err => {
        console.log(role);
      })
  }

}
