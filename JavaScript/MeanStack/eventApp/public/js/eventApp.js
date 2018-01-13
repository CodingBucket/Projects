var app = angular.module('eventApp',['ngRoute','ngResource']);

// Angular routing
app.config(function($routeProvider){
	$routeProvider
		.when('/',{
			templateUrl: 'main.html',
			controller: 'mainController'
		})
		.when('/contactus',{
			templateUrl: 'contactus.html',
		})
		.when('/signin',{
			templateUrl: 'signin.html',
			controller: 'authController'
		})
		.when('/signup',{
			templateUrl: 'signup.html',
			controller: 'authController'
		})
});

// Angular factory sevice
app.factory('eventService', function($resource){
	return $resource('/api/events');
});

// MainController
app.controller('mainController', function($scope, eventService){
  
  $scope.events = [];
  $scope.newEvent = {title: '',venue: '',date: ''};

  $scope.events = eventService.query();   // Get all events using eventService

  // Save event in the db
  $scope.post = function(){
  	eventService.save($scope.newEvent, function(){
  		// Displaying the new event
  		$scope.events.push($scope.newEvent);
    	$scope.newEvent = {title: '',venue: '',date: ''};
  	}); 
  };

});


// AuthController
app.controller('authController', function($scope){
  
  $scope.newEvent = {
  	username: '',
  	password: ''
  };
  $scope.msg = '';

  $scope.signin = function(){
  	$scope.msg = 'signin request received from user:' + $scope.user.username
  };

  $scope.signup = function(){
  	$scope.msg = 'signup request received from user:' + $scope.user.username
  };

});