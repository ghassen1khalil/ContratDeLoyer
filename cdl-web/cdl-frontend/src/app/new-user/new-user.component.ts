import { Component, OnInit } from '@angular/core';
import {Authentification} from "../../service/authentification";

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit {
  user:any;
  constructor(private authService:Authentification ) { }
  constructor() { }

  ngOnInit() {
  }

  onSaveUser(user) {
    this.authService.saveUser(user)
      .subscribe(resp => {
        this.user = resp;
      }, err => {

        console.log(err);
      })
  }

}
