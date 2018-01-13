var mongoose = require('mongoose');
var User = mongoose.model('User');
var LocalStrategy = require('passport-local').Strategy;
var bCrypt = require('bcrypt-nodejs');

module.export = function(passport){
  
  passport.serializeUser(function(user, done){
      done(null, user._id);
  });

  passport.deserializeUser(function(id, done){
      User.findById(id, function(err, user){
          done(err, user);
      });
  });

  // Passport Signup
  passport.use('signup', new LocalStrategy({
      passReqToCallback : true
    },

    function(req, username, password, done){
      
      findOrCreateUser = function(){
        User.findOne({'username': username}, function(err, user){
          
          if(err){
              return done(err);
          }

          if(user){
              return done(null, false);
          } else {
              var newUser = new User();
              newUser.username =  username;
              newUser.password = createHash(password);
              newUser.save(function(err){
                  if(err){
                      throw err;
                  }
                  return done(null, newUser);
              });
          }


        });
      }; 
      process.nextTick(findOrCreateUser);
    })
  
  );

  // Passport Signin
  passport.use('signin', new LocalStrategy({
      passReqToCallback : true
    },

      function (req, username, password, done){
        
        User.findOne({'username' : username},
            function(err, user){
                if(err){
                    return done(err);
                }
                if(!user){
                    return done(null, false);
                }
                if (!isPasswordValid(user, password)) {
                  return done(null, false);
                }
                return done(null, user);
            }
        );

      }

  ));

  // Password validation
  var isPasswordValid = function(user, password){
      return bCrypt.compareSync(password, user.password);
  };

  // Create Hash password
  var createHash = function(password){
      return bCrypt.hashSync(password, bCrypt.genSaltSync(10), null);
  };


};   // End of passport module