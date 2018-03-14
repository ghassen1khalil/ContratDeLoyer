import { Component, OnInit } from '@angular/core';
import {Authentification} from "../../service/authentification";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  mode :number=0;
  constructor(private authService:Authentification) { }

  ngOnInit() {
  }

  onLogin(user){
    this.authService.login(user)
      .subscribe(resp=>{
        let jwt = resp.headers.get('authorization');
        console.log(jwt)
      },
        err=>{
            this.mode=1
        })
  }

}
