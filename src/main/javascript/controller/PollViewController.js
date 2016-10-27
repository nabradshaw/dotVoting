function PollViewController($http) {
    var self = this;

    $http.get('/api/list', {}).then(function(response) {
        self.poll = response.data;
    });

    self.doSubmit = function() {
        //do the thing
        alert("I voted!");
    }
}

angular
    .module('dot-voting')
    .controller('PollViewController', PollViewController);