var express = require('express');
var router = express.Router();

module.export = function(passport){

	// sends successful login state back to amgular
	router.get('/success', function(req, res){
		res.send({state: 'success', user: req.user ? req.user : null});
	});

	// Sends failure login state back to angular
	router.get('/failure', function(req, res){
		res.send({state: 'failure', user: null, message: "Invalid username or password"});
	});

	// Login
	router.post('signin', passport.authenticate('signin',{
		successRedirect: '/auth/sucess',
		failureRedirect: '/auth/failure'
	}));

	// Signup
	router.post('signup', passport.authenticate('signup',{
		successRedirect: '/auth/sucess',
		failureRedirect: '/auth/failure'
	}));

	// Logout
	router.get('/signout', function(req, res){
		req.logout();
		res.redirect('/');
	});

	// Test
	router.get('/test', function(req, res){
		console.log('In test method');
	});

	return router;

};