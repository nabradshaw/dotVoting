function PollViewController($http) {
    var self = this;

    $http.get('/api/list', {}).then(function(response) {
        self.list = response.data;
    });
}

angular
    .module('dot-voting')
    .controller('PollViewController', PollViewController);