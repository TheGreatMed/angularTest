import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
  title = 'angular-crud';
  show:boolean=true;
constructor(private route:Router){
  
}
ngOnInit(): void {
  this.road();
}
  road(){
    setTimeout(
      ()=>{
        this.route.navigate(['users']);
        this.show=false;
      },2000
    )
  }
}
