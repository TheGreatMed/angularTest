import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-crud';
  show:boolean=true;
constructor(private route:Router){
  
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
