// Include mongoose for connecting the MongoDB
var mongoose = require('mongoose');

// Table schema for the events
var EventSchema = new mongoose.Schema({            
  title: 'string',
  venue: 'string',
  date: Date
});

// Declare the Event models
var Event = module.exports = mongoose.model('Event', EventSchema);

// Get all events
module.exports.getEvents = function(callback){
	Event.find(callback);
}

// Save event
module.exports.saveEvent = function(req, callback){

	var event = new Event();

	event.title = req.body.title;
	event.venue = req.body.venue;
	event.date = req.body.date;

	event.save(callback);

}




