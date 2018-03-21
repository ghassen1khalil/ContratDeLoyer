import { Component, OnInit } from '@angular/core';
import {Authentification} from "../../service/authentification";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  mode :number=0;
  constructor(private authService:Authentification, private router:Router) { }

  ngOnInit() {
    if (this.authService.open()==true){
      this.router.navigateByUrl("/user");
    }
  }

  onLogin(user){
    this.authService.login(user)
      .subscribe(resp=>{
          let jwt = resp.headers.get('Authorization');
          this.authService.saveToken(jwt);
          this.router.navigateByUrl("/user")
        },
        err=>{
          this.mode=1
        })
  }

}
