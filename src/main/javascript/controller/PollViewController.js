function PollViewController($http) {
    var self = this;

    $http.get('/api/list', {}).then(function(response) {
        self.poll = response.data;
    });

    self.doSubmit = function() {
        //do the thing
        alert("I voted!");
    }

    self.voteTotal = function() {
        var pollItems = self.poll.pollItems;
        return pollItems.reduce(function(acc, item){
            return acc.voteCount + item.voteCount;
        });
    }
}

angular
    .module('dot-voting')
    .controller('PollViewController', PollViewController);