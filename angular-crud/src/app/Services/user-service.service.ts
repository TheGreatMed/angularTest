import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../Models/user.model';
import { Validators, FormGroup, FormControl } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {



  userList:User[];
  userData: User=new User();
  NotUpdate: boolean;

  readonly  rootURL =window['cfgApiBaseUrl']+'/api/users';
  form: FormGroup;
  idUser=new FormControl(0,Validators.required);
  nom=new FormControl(this.userData.nom,Validators.required);
  prenom=new FormControl(this.userData.prenom,Validators.required);
  email=new FormControl(this.userData.email,Validators.compose([Validators.email,Validators.required])) 
  constructor(private http: HttpClient) { }

getUsers(){
  return this.http.get(this.rootURL);
}
  page : number=0;
   pages:Array<any>;
   users:Array<any>;
  getPageUsers(page:number){
    this.http.get(this.rootURL+'/list?page='+page).subscribe(
      res=>{
        this.users=res['content'];
        this.pages=new Array(res['totalPages']);
      },
      err=>{
        console.log(err);
      }
    )
  }

saveUser(user :User){
  return this.http.post(this.rootURL,user);
}

updateUser(user: User){
  console.log(user);
  return this.http.put(this.rootURL+'/user/'+user.idUser,user);
}

deleteUser(idUser:number){
  return this.http.delete(this.rootURL+'/'+idUser);
}
existByEmail(email:string){
  return this.http.post(this.rootURL+'/exist',email);
}

enable(idUser:number){
  return this.http.post(this.rootURL+'/'+idUser+'/enable',idUser);
}
disable(idUser:number){
  return this.http.post(this.rootURL+'/'+idUser+'/disable',idUser);
}
}
