import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {RouterModule, Routes} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {Authentification} from "../service/authentification";
import { UserComponent } from './user/user.component';

const appRoutes:Routes=[
  {path:"login",component:LoginComponent},
  {path:"user",component:UserComponent},
  {path:"",redirectTo:"/login",pathMatch:'full'}
];
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,RouterModule.forRoot(appRoutes),FormsModule,HttpClientModule
  ],
  providers: [Authentification],
  bootstrap: [AppComponent]
})
export class AppModule { }
