import { Component, OnInit } from '@angular/core';
import {Authentification} from "../../service/authentification";
import {RoleService} from "../../service/role.service";

@Component({
  selector: 'app-new-role',
  templateUrl: './new-role.component.html',
  styleUrls: ['./new-role.component.css']
})
export class NewRoleComponent implements OnInit {
  roleName:any;
  constructor(private roleService:RoleService ) { }

  ngOnInit() {
  }

  onSaveRole(role) {
    this.roleService.saveRole(role)
      .subscribe(resp => {
        this.roleName = resp;
        console.log(role);
      }, err => {

        console.log(role);
      })
  }

}
