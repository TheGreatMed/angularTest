import { UserServiceService } from './../Services/user-service.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

 
  
  constructor(private fb:FormBuilder,private userService :UserServiceService) { 
   
  }

  ngOnInit() {
   
   
  }

}
