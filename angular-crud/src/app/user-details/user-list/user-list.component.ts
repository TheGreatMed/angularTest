import { ToastrService } from 'ngx-toastr';
import { FormGroup } from '@angular/forms';
import { UserServiceService } from './../../Services/user-service.service';
import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { User } from 'src/app/Models/user.model';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  @Input() form:FormGroup;
  @Input() NotUpdate: boolean;

  constructor(public userService:UserServiceService,private toastr:ToastrService) { }
  
  ngOnInit() {
   
    this.userService.getPageUsers(this.userService.page);
  }

  test(user:User){
    this.populateUser(user);
    this.userService.form.controls.email.valid;
  }

  setPage(i,event:any){
    event.preventDefault();
    this.userService.page=i;
    this.userService.getPageUsers(this.userService.page);
  }

  getAllUsers(){
    this.userService.getUsers()
    .toPromise().then(res=>{
       this.userService.userList= res as User[];
    })
  }

  onDelete(idUser:number){
    if(confirm(" Are you sur to delete this user ?")){
        this.userService.deleteUser(idUser).subscribe(
          res=>{
              this.userService.getPageUsers(this.userService.page);
              this.toastr.warning('User deleted successfuly','User.Registry');
          },err=>{
            console.log(err);
          }
        )
    }
  }
 
  populateUser(user:User){
    this.userService.userData={
      idUser:user.idUser,
      nom:user.nom,
      prenom:user.prenom,
      email:user.email,
      active:user.active
    }
    this.userService.form.controls.email.disable();
    this.userService.form.patchValue(
      {
        idUser:this.userService.userData.idUser,
        nom:this.userService.userData.nom,
        prenom:this.userService.userData.prenom,
        email:this.userService.userData.email
      }
    )
    this.userService.NotUpdate=false;
    
  }

  enable(idUser:number){
      this.userService.enable(idUser).subscribe(
        res=>{
          this.userService.getPageUsers(this.userService.page);
        }
      )
  }
  disable(idUser:number){
    this.userService.disable(idUser).subscribe(
      res=>{
        this.userService.getPageUsers(this.userService.page);
      }
    )
}
}
