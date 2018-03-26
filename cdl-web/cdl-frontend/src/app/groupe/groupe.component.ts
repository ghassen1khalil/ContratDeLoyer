import { Component, OnInit } from '@angular/core';
import {GroupeService} from "../../service/groupe.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-groupe',
  templateUrl: './groupe.component.html',
  styleUrls: ['./groupe.component.css']
})
export class GroupeComponent implements OnInit {
   private groupes;
  constructor(public groupeService:GroupeService,public router:Router) { }

  ngOnInit() {
    this.groupeService.getGroupes()
      .subscribe(data=> {
          this.groupes  = data;
          console.log(this.groupes)
        },
        err=>{
          console.log(err);
        })
  }

  OnUpdateGroupe(idGroupe:number){
    this.router.navigateByUrl('update-groupe/'+idGroupe);
  }


  OnDeleteGroupe(idGroupe:number){
    this.groupeService.deleteGroupe(idGroupe)
      .subscribe(data=> {
          window.location.reload();
        },
        err=>{
          console.log(err);
        })

  }

}
