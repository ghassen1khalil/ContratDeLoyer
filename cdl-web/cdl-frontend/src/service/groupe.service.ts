import {Injectable} from "@angular/core";
import {Authentification} from "./authentification";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable()
export class GroupeService{
  constructor(private authService:Authentification, private http:HttpClient){}

  getGroupes(){
    if(this.authService.jwtToken==null) this.authService.loadToken();
    return this.http.get(this.authService.host+"/groupe",
      {headers : new HttpHeaders({"Authorization":this.authService.jwtToken})});
  }
  getGroupe(id){
    if(this.authService.jwtToken==null) this.authService.loadToken();
    return this.http.get(this.authService.host+"/groupe/"+id,
      {headers : new HttpHeaders({"Authorization":this.authService.jwtToken})});
  }
  saveGroupe(groupe){
    return this.http.post(this.authService.host+"/groupe",groupe,{headers:new HttpHeaders({'Authorization':this.authService.jwtToken})});
  }

  updateGroupe(groupe){
    return this.http.put(this.authService.host+"/groupe/"+groupe.idGroupe,groupe,{headers:new HttpHeaders({'Authorization':this.authService.jwtToken})});
  }
  deleteGroupe(id){
    return this.http.delete(this.authService.host+"/groupe/"+id,{headers:new HttpHeaders({'Authorization':this.authService.jwtToken})});
  }

}
