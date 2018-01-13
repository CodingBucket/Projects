var mongoose = require('mongoose');

var UserSchema = new mongoose.Schema({            // Table schema for the user
  username: 'string',
  password: 'string'
});

var User = mongoose.model('User',UserSchema);   // Declare the User models

