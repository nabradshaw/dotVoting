function PollViewController($http, $location) {
    var self = this;
    self.voteTotal = 0;
    self.maxVotes = 3;
    self.remainingVotes = self.maxVotes;
    self.hasNegativeVoteCount = false;

    self.getPoll = function() {
        $http.get('/api/list', {}).then(function(response) {
            self.poll = response.data;
            if (angular.isDefined(self.poll.pollItems)) {
                angular.forEach(self.poll.pollItems, function(value, index) {
                    self.voteTotal += value.voteCount;
                })
            }
        });
    }

    self.doSubmit = function() {
        if (self.remainingVotes >= 0) {
            $http.post('/api/vote', self.poll).then(function(response){
                $location.url('/results');
            });
        }
    }

    self.calculateRemainingVotes = function() {
        var votesCast = 0;
        self.hasNegativeVoteCount = false;

        angular.forEach(self.poll.pollItems, function(value, index) {
            if (value.voteCount < 0) {
                self.hasNegativeVoteCount = true;
            }
            votesCast += value.voteCount;
        });
        if (votesCast <= 0) {
            self.remainingVotes = self.maxVotes
        } else {
            self.remainingVotes = self.maxVotes - votesCast;
        }
    }
}

angular
    .module('dot-voting')
    .controller('PollViewController', PollViewController);