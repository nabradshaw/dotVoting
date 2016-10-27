function appConfig($routeProvider, $locationProvider) {

    $routeProvider
        .when('/', {
            templateUrl: 'html/PollView.html',
            controller: 'PollViewController',
            controllerAs: 'ctrl'
        })
        .otherwise({
            redirectTo: '/'
        });

}

angular.module('dot-voting', ['ngRoute']).config(appConfig);