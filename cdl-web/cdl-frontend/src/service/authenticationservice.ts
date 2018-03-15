import {Injectable} from "@angular/core";
import {HttpClient, HttpHandler, HttpHeaders} from "@angular/common/http";

@Injectable()
export class AuthenticationServie{
  private host:string="http://localhost:8050";
  private jwtToken=null;
  constructor(private http:HttpClient){

  }
  login(user){
    return this.http.post(this.host+"/login",user,{observe:'response'});
  }

  saveToken(jwt:string){
    localStorage.setItem('token',jwt);
  }
  getUsers(){
    if(this.jwtToken==null) this.loadToken();
    return this.http.get(this.host+"/users",
      {headers:new HttpHeaders({'Authorization':this.jwtToken})});
  }
  loadToken(){
    this.jwtToken=localStorage.getItem('token')
  }
}
