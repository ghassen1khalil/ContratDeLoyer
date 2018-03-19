import {Injectable} from "@angular/core";
import {Authentification} from "./authentification";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable()
export class RoleService{
  constructor(private authService:Authentification, private http:HttpClient){}

  getRoles(){
    if(this.authService.jwtToken==null) this.authService.loadToken();
    return this.http.get(this.authService.host+"/role",
      {headers : new HttpHeaders({"Authorization":this.authService.jwtToken})});
  }

  saveRole(role){
    return this.http.post(this.authService.host+"/role",role,{headers:new HttpHeaders({'Authorization':this.authService.jwtToken})});
  }

}
