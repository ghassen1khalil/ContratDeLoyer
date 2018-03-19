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
import {NewUserComponent} from "./new-user/new-user.component";
import { RoleComponent } from './role/role.component';
import { NewRoleComponent } from './new-role/new-role.component';
import {RoleService} from "../service/role.service";
import {UserService} from "../service/user.service";

const appRoutes:Routes=[
  {path:"login",component:LoginComponent},
  {path:"user",component:UserComponent},
  {path:"role",component:RoleComponent},
  {path:"new-user",component:NewUserComponent},
  {path:"new-role",component:NewRoleComponent},
  {path:"",redirectTo:"/login",pathMatch:'full'}
];
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent,
    NewUserComponent,
    RoleComponent,
    NewRoleComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,RouterModule.forRoot(appRoutes),FormsModule,HttpClientModule
  ],
  providers: [Authentification,RoleService,UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
