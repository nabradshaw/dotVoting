function appConfig($routeProvider, $locationProvider) {

    $routeProvider
        .when('/', {
            templateUrl: 'PollView.html',
            controller: 'PollViewController',
            controllerAs: 'ctrl'
        })
        .otherwise({
            redirectTo: '/'
        });

}

angular.module('dot-voting', ['ngRoute', 'views']).config(appConfig);