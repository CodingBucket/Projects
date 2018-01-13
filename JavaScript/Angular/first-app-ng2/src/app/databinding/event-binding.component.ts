import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-event-binding',
  template: `
    <button (click)="onClick()">Click me!</button>
  `,
  styles: []
})
export class EventBindingComponent {

  @Output() clickCustomEvent = new EventEmitter<string>();

  onClick(){ 
    //alert('It worked');
    this.clickCustomEvent.emit('Custom event fire and response');
  }

}
