import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class Authentification{
  private host:string="http://127.0.0.1:8085";
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
    return this.http.get(this.host+"/user",
      {headers : new HttpHeaders({"Authorization":this.jwtToken})});
  }
  loadToken(){
    this.jwtToken=localStorage.getItem('token')
  }
}
