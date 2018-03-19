import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Authentification} from "./authentification";

@Injectable()
export class UserService {

  constructor(private authService:Authentification, private http:HttpClient){}


  getUsers(){
    if(this.authService.jwtToken==null) this.authService.loadToken();
    return this.http.get(this.authService.host+"/user",
      {headers : new HttpHeaders({"Authorization":this.authService.jwtToken})});
  }

  saveUser(user){
    return this.http.post(this.authService.host+"/user",user,{headers:new HttpHeaders({'Authorization':this.authService.jwtToken})});
  }
}
