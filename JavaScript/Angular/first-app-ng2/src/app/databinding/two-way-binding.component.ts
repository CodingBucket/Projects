import { Component } from '@angular/core';

@Component({
  selector: 'app-two-way-binding',
  template: `
    <input type="text" name="person-name" [(ngModel)]="person.name">
    <input type="text" name="person-name" [(ngModel)]="person.name">
  `,
  styles: []
})
export class TwoWayBindingComponent {

  person = {
    name: 'Hasan Ahmed Khan',
    age: 28
  };

}
