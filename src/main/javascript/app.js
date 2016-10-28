function appConfig($routeProvider, $locationProvider) {

    $routeProvider
        .when('/poll/:id', {
            templateUrl: 'PollView.html',
            controller: 'PollViewController',
            controllerAs: 'ctrl'
        })
        .when('/results/:id', {
            templateUrl: 'PollResults.html',
            controller: 'PollViewController',
            controllerAs: 'ctrl'
        })
        .when('/create', {
            templateUrl: 'PollCreate.html',
            controller: 'PollCreateController',
            controllerAs: 'ctrl'
        })
        .otherwise({
            redirectTo: '/create'
        });

}

angular.module('dot-voting', ['ngRoute', 'views']).config(appConfig);