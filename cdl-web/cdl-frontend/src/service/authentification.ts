import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class Authentification{
  private host:string="http://127.0.0.1:8085";
  constructor(private http:HttpClient){

  }
  login(user){
    return this.http.post(this.host+"/login",user,{observe:'response'});
  }
}
