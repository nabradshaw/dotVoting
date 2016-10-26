var gulp = require('gulp');

var del = require('del');
var rename = require('gulp-rename');
var concat = require('gulp-concat');
var addsrc = require('gulp-add-src');

var htmlmin = require('gulp-htmlmin');
var html2js = require('gulp-html2js');
var ngAnnotate  = require('gulp-ng-annotate');
var uglify = require('gulp-uglify');
var sourcemaps = require('gulp-sourcemaps');
var wrap = require('gulp-wrap');

var karma = require('karma').server;

var PROJECT_NAME = 'dot-voting';
var BUILD_OUTPUT_PATH = 'src/main/webapp/dist/'

gulp.task('clean', function() {
    del(BUILD_OUTPUT_PATH + '/*');
});

gulp.task('copy-dependencies', function() {
    return gulp.src([
        'node_modules/bootstrap/dist/**/*',
        'node_modules/jquery/dist/jquery.min.js',
        'node_modules/angular/angular.*',
        'node_modules/angular-route/angular-route.*'])
        .pipe(gulp.dest(BUILD_OUTPUT_PATH + '/vendor'));
});

gulp.task('build', ['copy-dependencies'],function() {

    return gulp.src('src/main/html/**/*.html')
        .pipe(htmlmin({ collapseWhitespace: true, removeComments: true }))
        .pipe(html2js({ outputModuleName: PROJECT_NAME, base: 'src/main' }))
        .pipe(concat('views.js'))

        .pipe(addsrc(['src/main/javascript/app.js', 'src/main/javascript/**/*.js']))

        //Wrap the concatenated files in an IIFE to prevent global namespace pollution
        .pipe(wrap('(function(){\r\n\r\n<%= contents %>\r\n\r\n}(angular));'))

        //Start Source Mapping
        .pipe(sourcemaps.init())

        //Add Angular annotations
        .pipe(ngAnnotate())

        //Concat sources into single file
        .pipe(concat(PROJECT_NAME + '.js'))

        //Output concatenated source
        .pipe(gulp.dest(BUILD_OUTPUT_PATH))

        //Minify source
        .pipe(rename(PROJECT_NAME + '.min.js'))
        .pipe(uglify())

        //Output source map
        .pipe(sourcemaps.write('.'))

        //Output minified source
        .pipe(gulp.dest(BUILD_OUTPUT_PATH));
});

//Test
gulp.task('test', ['build'], function (done) {
    karma.start({
        configFile: __dirname + '/karma.conf.js',
        singleRun: true
    }, done);
});


//Test watcher
gulp.task('test:watch', function (done) {
    karma.start({
        configFile: __dirname + '/karma.conf.js',
    }, done);
    gulp.watch('src/main/javascript/**/*.js', ['build']);
    gulp.watch('src/main/html/**/*.html', ['build']);
});

// Default Task
gulp.task('default', ['build']);