import { Component, OnInit } from '@angular/core';
import {GroupeService} from "../../service/groupe.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-update-groupe',
  templateUrl: './update-groupe.component.html',
  styleUrls: ['./update-groupe.component.css']
})
export class UpdateGroupeComponent implements OnInit {

  private idGroupe;
  public groupe;
  constructor(public activatedRoute:ActivatedRoute,public groupeService:GroupeService,public route:Router) {
    this.idGroupe=activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.groupeService.getGroupe(this.idGroupe)
      .subscribe(data=>{
          this.groupe=data;
        },
        err=>{
          console.log(this.groupe);
        });
  }

  updateGroupe(){
    this.groupeService.updateGroupe(this.groupe)
      .subscribe(data=>{
          alert("Update Successfully")
          this.route.navigateByUrl("/groupe");
        },
        err=>{
          console.log(this.groupe);
          alert("Error ");
        });
  }

}
