function PollViewController($http) {
    var self = this;
    self.voteTotal = 0;

    self.getPoll = function() {
        $http.get('/api/list', {}).then(function(response) {
            self.poll = response.data;
            if (angular.isDefined(self.poll.pollItems)){
                self.voteTotal = self.poll.pollItems.reduce(function(acc, item) {
                    return acc.voteCount + item.voteCount;
                })
            }
        });
    }

    self.doSubmit = function() {
        $http.post('/api/vote', self.poll);
    }
}

angular
    .module('dot-voting')
    .controller('PollViewController', PollViewController);