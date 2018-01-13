// Create angular module
var module = angular.module("calculatorApp", []);

// Define angular controller
module.controller("CalculatorCtrl", CalculatorCtrl);

function CalculatorCtrl(){
	
	this.resultValue = 0;

	this.buttonClicked = function(button){
		console.log('button clicked');
 		this.selectedOption = button
	}

	this.computeResult = function(){
		var num1 = parseFloat(this.input1);
		var num2 = parseFloat(this.input2);

		if(this.selectedOption === '+'){
			this.resultValue = num1 + num2;
		} else if (this.selectedOption === '-'){
			this.resultValue = num1 - num2;
		} else if (this.selectedOption === '*'){
			this.resultValue = num1 * num2;
		} else if (this.selectedOption === '/'){
			this.resultValue = num1 / num2;
		}
	}

}