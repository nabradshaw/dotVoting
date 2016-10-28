function PollViewController($http, $location, $routeParams) {
    var self = this;
    self.voteTotal = 0;

    self.getPoll = function() {
        $http.get('/api/poll/' + $routeParams.id, {}).then(function(response) {
            self.poll = response.data;
            self.pollItems = self.poll.pollItems;
            if (angular.isDefined(self.poll.pollItems)) {
                angular.forEach(self.pollItems, function(value, index) {
                    self.voteTotal += value.voteCount;
                })
            }
        });
    }

    self.doSubmit = function() {
        $http.post('/api/vote', self.poll).then(function(response){
            $location.url('/results');
        });
    }
}

angular
    .module('dot-voting')
    .controller('PollViewController', PollViewController);