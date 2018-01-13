var express = require('express');
var router = express.Router();

var mongoose = require('mongoose');
var Event = mongoose.model('Event');

// Get all events from MongoDB
router.get('/events', function(req, res, next){

	Event.getEvents(function(err, events) {
    	if(err){
			return res.send(500, err);
		} 
		return res.send(events);
  	});

});

// Save event data in the MongoDB
router.post('/events', function(req, res, next){

	Event.saveEvent(req, function(err, event) {
		console.log(event);
    	if(err){
			return res.send(500, err);
		} 
		return res.send(event);
  	});

});

module.exports = router;


