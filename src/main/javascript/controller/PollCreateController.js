function PollCreateController($http) {
    this.title = "";
    this.pollItems = [];

    this.createPoll = function() {
        $http.post('/api/list', { title: this.title, pollItems: this.pollItems });
    }

}

angular
    .module('dot-voting')
    .controller('PollCreateController', PollCreateController);