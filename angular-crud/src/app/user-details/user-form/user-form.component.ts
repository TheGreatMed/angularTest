import { UserServiceService } from './../../Services/user-service.service';
import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder, FormGroupDirective, ControlContainer } from '@angular/forms';
import { User } from 'src/app/Models/user.model';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
 
  user=new User();
  idUser=new FormControl(0,Validators.required);
  nom=new FormControl(this.userService.userData.nom,Validators.required);
  prenom=new FormControl(this.userService.userData.prenom,Validators.required);
  email=new FormControl(this.userService.userData.email,Validators.compose([Validators.email,Validators.required])) 
  isExist:boolean;
  constructor(fb:FormBuilder,public userService:UserServiceService,private toastr: ToastrService) { 
    this.userService.form=fb.group({
      "idUser":this.idUser,
      "nom":this.nom,
      "prenom":this.prenom,
      "email":this.email
    });
    
  }

  ngOnInit() {
    
    this.userService.NotUpdate=true;
    this.isExist=false;
    
  }
 
  getAllUsers(){
    this.userService.getUsers()
    .toPromise().then(res=>{
       this.userService.userList= res as User[];
    })
  }
  
  submitForm(){
    console.log(this.userService.form.controls.idUser.value)
    if(this.userService.form.controls.idUser.value===0){
      console.log('coucouc');
      this.insertUser();
    }else{
      this.updateUser();
    }
    
  }
  insertUser(){
    
    this.userService.saveUser(this.userService.form.value).subscribe(
      res =>{
        this.userService.getPageUsers(this.userService.page);
        this.toastr.success('User added successfuly','User.Registry');
         this.restForm();
      },
      err=>{
        console.log(err);
      }
    )
  }

  updateUser(){
    this.userService.updateUser(this.userService.form.value).subscribe(
      res=>{
        this.userService.getPageUsers(this.userService.page);
        this.toastr.info('User edited successfuly','User.Registry');
        this.restForm();
      },err=>{
        console.log(err);
      }
    )
  }
  restForm(){
    this.userService.form.reset({
      "idUser":0,
      "nom":null,
      "prenom":null,
      "email":null
    });
    this.userService.NotUpdate=true;
    this.userService.form.controls.email.enable();
    this.isExist=false;
  }

 values:string
  onWrite(value:string){
    this.values='';
    this.values+=value;
    if(this.values.length!=0){
      this.isExistByEmail(value);
      console.log(this.values);
      
    }else{
      this.isExist=false;
    }

  }
  isExistByEmail(email:string):any{
    this.userService.existByEmail(email).subscribe(
      (res:boolean)=>{
         if(res){
           this.isExist=true;
           this.userService.form.controls.email.setErrors({incorrect:true});
         }
      }
    )
  }

}
