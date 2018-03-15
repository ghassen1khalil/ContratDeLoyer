import { Component, OnInit } from '@angular/core';
import {AuthenticationServie} from "../../service/authenticationservice";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  mode :number=0;
  constructor(private authService:AuthenticationServie,private router:Router) { }

  ngOnInit() {
  }

  onLogin(user){
    this.authService.login(user)
      .subscribe(resp=>{
        let jwt = resp.headers.get('Authorization');
        this.authService.saveToken(jwt);
        this.router.navigateByUrl("/users")
      },
        err=>{
            this.mode=1
        })
  }

}
