import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {GroupeService} from "../../service/groupe.service";

@Component({
  selector: 'app-new-groupe',
  templateUrl: './new-groupe.component.html',
  styleUrls: ['./new-groupe.component.css']
})
export class NewGroupeComponent implements OnInit {
  label:any;
  constructor(private groupeService:GroupeService,private router:Router) { }

  ngOnInit() {
  }

  onSaveGroupe(groupe) {
    this.groupeService.saveGroupe(groupe)
      .subscribe(resp => {
        this.label = resp;
        this.router.navigateByUrl('/groupe');
      }, err => {
        console.log(err);
      })
  }

}
