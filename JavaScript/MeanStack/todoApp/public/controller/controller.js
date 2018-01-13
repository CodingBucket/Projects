function AppCtrl($scope, $http){
	console.log('Anguler Controller Start');                                     

	var getContactListData = function(){
		$http.get('/contactlist').success(function(response){          // Get request to the node server
			console.log('Controller received the data');
			$scope.contactlist = response;
			$scope.contact = "";
		});  
	}

	getContactListData();

	$scope.addContact = function(){
		console.log($scope.contact);
		$http.post('/contactlist', $scope.contact).success(function(response){
			console.log(response);
			getContactListData();
		});
	}    

	$scope.removeContact = function(id){
		console.log(id);
		$http.delete('/contactlist/' + id).success(function(response){
			getContactListData();
		});
	}  

	$scope.editContact = function(id){
		console.log(id);
		$http.get('/contactlist/' + id).success(function(response){
			$scope.contact = response;
		});
	}   

	$scope.updateContact = function(){
		console.log($scope.contact._id);
		$http.put('/contactlist/' + $scope.contact._id, $scope.contact).success(function(response){
			getContactListData();
		});
	}     

	$scope.clear = function(){
		$scope.contact = '';
	}   

}