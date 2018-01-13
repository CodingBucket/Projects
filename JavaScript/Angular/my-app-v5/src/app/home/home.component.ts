import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

   homeImageList = [
        {image: "assets/images/1.jpg", name:"Item 1", title:"Item 1", link:'/videos/item-1'},
        {image: "assets/images/2.jpg", name:"Item 1", title:"Item 2", link:'/videos/item-2'},
        {image: "assets/images/3.jpg", name:"Item 1", title:"Item 3", link:'/videos/item-3'}
   ]

  constructor(private router:Router) { }

  ngOnInit() {
  }

  preventNormal(event:MouseEvent, image:any){
      if (!image.prevented){
          event.preventDefault()
          //image.setAttribute("href", "/videos")
          //image.link = '/videos'
          //image.prevented = true;
          this.router.navigate(['./videos'])         
      }
  }

}