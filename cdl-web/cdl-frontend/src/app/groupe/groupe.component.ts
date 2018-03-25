import { Component, OnInit } from '@angular/core';
import {GroupeService} from "../../service/groupe.service";

@Component({
  selector: 'app-groupe',
  templateUrl: './groupe.component.html',
  styleUrls: ['./groupe.component.css']
})
export class GroupeComponent implements OnInit {
   private groupes;
  constructor(public groupeService:GroupeService) { }

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

}
