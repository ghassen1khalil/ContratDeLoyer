import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {JwtHelper} from "angular2-jwt";
import "rxjs/add/operator/map";
@Injectable()
export class Authentification{
  public host:string="http://127.0.0.1:8085";
  public jwtToken=null;
  public role;
  constructor(private http:HttpClient){

  }
  login(user){
    return this.http.post(this.host+"/login",user,{observe:'response'});
  }

  saveToken(jwt:string){
    this.jwtToken=jwt;
    localStorage.setItem('token',jwt);
    let jwtHelper=new JwtHelper();
    this.role=jwtHelper.decodeToken(this.jwtToken).role;
  }


  loadToken(){
    this.jwtToken=localStorage.getItem('token')
  }
  logout(){
    this.jwtToken=null;
    localStorage.removeItem('token');
  }

  isAdmin(){

    for(let r of this.role){
      if ( r.authority=='ADMIN') return true;
    }
    return false;

  }



}
