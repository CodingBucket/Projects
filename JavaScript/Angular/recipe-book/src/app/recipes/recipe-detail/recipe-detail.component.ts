import { Component, Input, OnInit } from '@angular/core';

import { Recipe } from '../recipe'
import { ShoppingListService } from '../../shopping-list/shopping-list.service';

@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html'
})
export class RecipeDetailComponent implements OnInit {

  @Input() selectedRecipe: Recipe;

  constructor(private shoppingListService: ShoppingListService){}

  ngOnInit(){}

  onAddToShoppingList(){
    console.log(this.selectedRecipe);
    this.shoppingListService.addItems(this.selectedRecipe.ingredients)
  }

}
