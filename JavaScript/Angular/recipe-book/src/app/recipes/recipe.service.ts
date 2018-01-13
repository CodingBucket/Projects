import { Injectable } from '@angular/core';

// Importing models
import { Recipe } from './recipe';
import { Ingredient } from './ingredient'

@Injectable()
export class RecipeService {

  private recipes: Recipe[] = [
    new Recipe('Recipe 1', 'Recipe 1 description', 'assets/images/1.jpg', 
              [new Ingredient('Ingredient 1', 10),
               new Ingredient('Ingredient 2', 10)]),
    new Recipe('Recipe 2', 'Recipe 2 description', 'assets/images/2.jpg',
              [new Ingredient('Ingredient 3', 11)]),
    new Recipe('Recipe 3', 'Recipe 3 description', 'assets/images/3.jpg',
              [new Ingredient('Ingredient 4', 12)])    
  ];

  constructor() { }

  getRecipes(){
    return this.recipes;
  }

}
