import { Component, OnInit } from '@angular/core';

import { PropertyBindingComponent } from './property-binding.component';

@Component({
  selector: 'databinding',
  templateUrl: './databinding.component.html',
  styleUrls: ['./databinding.component.css']
})
export class DatabindingComponent implements OnInit {

  stringInterpolation = 'String Interpolation'

  constructor() { }

  ngOnInit() {
  }

  onTest(){
    return true;
  }

  eventResponse(value: string){
    alert(value);
  }

}
