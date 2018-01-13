// Required packages
var gulp = require('gulp');                      //  Including Gulp
var uglify = require('gulp-uglify');             //  CSS and JS minifier
var plumber = require('gulp-plumber');           //  Error Handeler
var htmlmin = require('gulp-htmlmin');           //  Minify HTML
var imagemin = require('gulp-imagemin');         //  Compress image
var concat = require('gulp-concat');             //  Concat files
var livereload = require('gulp-livereload');     //  Automatically reload the web page when made chnage in file
var browserSync = require('browser-sync');       //  On change in file reload server or destination
var reload = browserSync.reload;                 //  Reload function for browserSync
var rename = require('gulp-rename');             //  Rename File
var autoprefixer = require('gulp-autoprefixer'); //  Add automatic browser prefix
var del = require('del');                        //  Delete file or folder
var install = require("gulp-install");           //  Gulp dependancies install

// Deactive Packages
// var sass = require('gulp-ruby-sass');         //  Convert SASS to CSS file
// var changed = require('gulp-changed');        //  Move changed file one dir to another dir
// var iconfont = require('gulp-iconfont');      //  Convert SVG icon into font 
// var cache = require('gulp-cached');           //  To cache js file
// var plugins = require('gulp-load-plugins');   //  Manage plugins also need to add package.json
// var less = require('gulp-less');              //  Convert LESS into CSS
// var minifyCSS = require('gulp-minify-css');   //  Minify CSS
// var compass = require('gulp-compass');        //  Convert SASS to CSS
// var jshint = require('gulp-jshint');
// var stylus = require('gulp-stylus');



// Install gulp packages  
gulp.task('install', function(){  // CMD: gulp script
	gulp.src('package.json')
	.pipe(install());
});

// Delete unwanted files
gulp.task('clearfolder', function(){
	del([
		'build/**'
	])
})

// SASS to CSS convert task
gulp.task('compass', function(){
	gulp.scr('app/scss/style.scss')
	    .pipe(plumber())
	    .pipe(
	    	compass({
		    	config_file: './config.rb',
		    	css: 'app/css',
		    	sass: 'app/sass',
		    	require: ['susy']
	    	})
    	)
    	.pipe(autoprefixer('last 2 version'))
    	.pipe(reload({stream:true}));
})

// File Rename Task 
gulp.task('rename', function(){  
	gulp.src('js/*.js')
	.pipe(plumber())
	.pipe(rename({suffix:'.min'}))
	.pipe(uglify())
	.pipe(gulp.dest('build/js'));
});

// Error Handaling with gulp
function errorLog(error){
	console.error.bind(error);
	this.emit('end');
}

// LESS to CSS Convert Task
gulp.task('less', function(){
	gulp.src('less/*.less')
		.pipe(less())
		.pipe(gulp.dest('build/less'));
});

// JS Files Concat Task
gulp.task('concat', function(){
	return gulp.src('js/*.js')
		.pipe(concat('all.js'))
		.pipe(gulp.dest('build/js'));
});

// Reload HTML page using Browser-sync 
gulp.task('browser-sync', function(){  // CMD: gulp browser-sync
	browserSync.init({
		server:{
			baseDir:'./dist'
		},
		open: false
	});

	gulp.watch('src/*.html', ['html']);
});

// Reload php server with browser sync
gulp.task('connect-sync', function() {
    connect.server({}, function (){
        browserSync({
            //proxy: '127.0.0.1:8000'
            proxy: 'http://localhost/alwindows'
        });
    });

    gulp.watch('css/frontend/css/base.css').on('change', function () {
        browserSync.reload();
    });
});

// HTML Minification Task
gulp.task('html', function(){     // CMD: gulp html
	return gulp.src('src/*.html')
		.pipe(htmlmin({collapseWhitespace: true}))
    	.pipe(gulp.dest('build/html'))
    	.pipe(browserSync.stream());
});

// JS Minification Task 
gulp.task('scripts', function(){  // CMD: gulp script
	gulp.src('js/*.js')
	.pipe(plumber())
	.pipe(uglify())
	.pipe(gulp.dest('build/js'));
});

// CSS Minification Task
gulp.task('styles', function(){  // CMD: gulp styles
	gulp.src('css/*.css')
	.pipe(plumber())
	.pipe(uglify())
	.pipe(gulp.dest('build/css'));
});

// SASS to CSS Convert and CSS Minification Task
gulp.task('sass', function(){
	gulp.src('sass/**/*.scss')
	.pipe(plumber())
	.pipe(sass({
		style: 'compressed'       // or expend
	}))
	.pipe(gulp.dest('build/css'));
})

// Image Compression Task 
gulp.task('image', function(){  // CMD: gulp image
	gulp.src('image/*')
	.pipe(imagemin())
	.pipe(gulp.dest('build/image'));
});

// Watch Task 
gulp.task('watch', function(){  // CMD: gulp watch
	gulp.watch('js/*.js', ['scripts']);
});

// Default Task
gulp.task('default', [           // CMD: gulp
	'scripts', 
	'styles',
	'watch'
 ]); 


// .on('error', errorLog)
// .pipe(prefix('last 2 versions'))
// .pipe(livereload())
