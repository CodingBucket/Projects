// Create angular module
var module = angular.module("todoApp", []);

// Define angular controller
module.controller("TodoCtrl", Todo);

// Controller method
function Todo($scope){
	console.log('In todo');

	$scope.editMode = false;

	$scope.todos = [
		"Learn angular1",
		"Learn JAVA and Spring",
		"Learn Python and Django"
	];

	$scope.addNewTodo = function(){
		$scope.todos.push($scope.newTodo);
		$scope.newTodo = '';
	} 

	$scope.triggerEditMode = function(){
		this.editMode = !this.editMode;
	}
}