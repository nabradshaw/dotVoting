function PollCreateController($http) {
    this.title = "";

    this.createPoll = function() {
        $http.post('/api/list', { title: this.title });
    }

}

angular
    .module('dot-voting')
    .controller('PollCreateController', PollCreateController);