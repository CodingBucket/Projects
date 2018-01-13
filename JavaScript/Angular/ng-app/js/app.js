// Create angular module
var module = angular.module("myApp", []);

// Define angular controller
module.controller("MainCtrl", Main);

function Main($scope){
	console.log('In main method');

	$scope.result = 100;

	var currentDate = new Date();
	$scope.timeString = currentDate.toTimeString();

	$scope.updateTime = function(){
		console.log('Button Clicked');
		var currentDate = new Date();
		$scope.timeString = currentDate.toTimeString();
	}

	$scope.textChange = function(){
		console.log('Text changed');
	}

	$scope.myList = [
		{'name': "Hasan", 'age': 26},
		{'name': "Ahmed", 'age': 27},
		{'name': "Khan", 'age': 28}
	]

}