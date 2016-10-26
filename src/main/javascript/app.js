function appConfig($routeProvider, $locationProvider) {

    $routeProvider
        .when('/helloworld', {
            templateUrl: 'html/HelloWorld.html',
            controller: 'HelloWorldCtrl',
            controllerAs: 'ctrl'
        })
        .otherwise({
            redirectTo: '/helloworld'
        });

}

angular.module('dot-voting', ['ngRoute']).config(appConfig);