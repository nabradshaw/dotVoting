module.exports = function(config) {
  config.set({

    basePath: '',
    frameworks: ['jasmine'],
    files: [
      'node_modules/jquery/dist/jquery.min.js',
      'node_modules/angular/angular.js',
      'node_modules/angular-route/angular-route.js',
      'node_modules/angular-mocks/angular-mocks.js',
      'src/main/webapp/dist/dot-voting.js',
      'src/test/javascript/**/*.js'
    ],
    exclude: [
    ],
    preprocessors: {
    },
    reporters: ['progress'],
    port: 9876,
    colors: true,
    logLevel: config.LOG_INFO,
    autoWatch: true,
    browsers: ['PhantomJS'],
    singleRun: false
  });
};