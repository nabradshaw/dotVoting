function PollViewController($http) {
    $http.get('/api/list', {});
}

angular
    .module('dot-voting')
    .controller('PollViewController', PollViewController);