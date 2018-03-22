import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {RoleService} from "../../service/role.service";

@Component({
  selector: 'app-update-role',
  templateUrl: './update-role.component.html',
  styleUrls: ['./update-role.component.css']
})
export class UpdateRoleComponent implements OnInit {
  private idRole;
  public role;
  constructor(public activatedRoute:ActivatedRoute,public roleService:RoleService,public route:Router) {
    this.idRole=activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.roleService.getRole(this.idRole)
      .subscribe(data=>{
        this.role=data;
      },
        err=>{
            console.log(this.role);
        });
  }

  updateRole(){
    this.roleService.updateRole(this.role)
      .subscribe(data=>{
        alert("Update Successfully")
        this.route.navigateByUrl("/role");
      },
        err=>{
        console.log(this.role);
        alert("Error ");
        });
  }

  deleteRole(){
    this.roleService.deleteRole(this.role)
      .subscribe(data=>{
          alert("delete Successfully")
          this.route.navigateByUrl("/role");
        },
        err=>{
          console.log(this.role);
          alert("Error ");
        });
  }
}
