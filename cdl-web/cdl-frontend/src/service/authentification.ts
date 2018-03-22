import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {JwtHelper} from "angular2-jwt";
import "rxjs/add/operator/map";
import {Router} from "@angular/router";
@Injectable()
export class Authentification{
  public host:string="http://127.0.0.1:8085";
  public jwtToken=null;
  public role:Array<any>;
  public twj2;
  public roleName;
  public userName;
  constructor(private http:HttpClient,private router:Router){

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
     this.router.navigateByUrl("/login")
  }
  onLogout(){
     this.logout();
     this.router.navigateByUrl('/login')
  }
  isAdmin(){
    this.twj2 =localStorage.getItem('token');
    if (this.twj2!=null){
    let jwtHelper=new JwtHelper();
    this.roleName=jwtHelper.decodeToken(this.twj2).role
    for ( let r of this.roleName){
        if(r.authority=="ADMIN"||r.authority=="SUPER_ADMIN") return true;
    }
    return false;
    }
    return false;

  }

  getName(){
    let jwtHelper=new JwtHelper();
    return this.userName=jwtHelper.decodeToken(this.twj2).sub
  }

  open(){
    if(localStorage.getItem('token')==null)
      return false;
    return true;
  }

}
