function appConfig($routeProvider, $locationProvider) {

    $routeProvider
        .when('/', {
            templateUrl: 'PollView.html',
            controller: 'PollViewController',
            controllerAs: 'ctrl'
        })
        .when('/results', {
            templateUrl: 'PollResults.html',
            controller: 'PollViewController',
        })
        .when('/create', {
            templateUrl: 'PollCreate.html',
            controller: 'PollCreateController',
            controllerAs: 'ctrl'
        })
        .otherwise({
            redirectTo: '/'
        });

}

angular.module('dot-voting', ['ngRoute', 'views']).config(appConfig);