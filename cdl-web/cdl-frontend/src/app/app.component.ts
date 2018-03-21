import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Authentification} from "../service/authentification";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'app';
  constructor(public authService:Authentification, private router:Router) { }

}
