import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {RouterModule, Routes} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {AuthenticationServie} from "../service/authenticationservice";
import { UsersComponent } from './users/users.component';
import { GroupesComponent } from './groupes/groupes.component';
import { RolesComponent } from './roles/roles.component';

const appRoutes:Routes=[
  {path:"login",component:LoginComponent},
  {path:"groupes",component:GroupesComponent},
  {path:"roles",component:RolesComponent},
  {path:"users",component:UsersComponent},
  {path:"",redirectTo:"/login",pathMatch:"full"}
];
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UsersComponent,
    GroupesComponent,
    RolesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,RouterModule.forRoot(appRoutes),FormsModule,HttpClientModule
  ],
  providers: [AuthenticationServie],
  bootstrap: [AppComponent]
})
export class AppModule { }
