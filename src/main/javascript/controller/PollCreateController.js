function PollCreateController($http) {
    this.title = "";
    this.pollItems = [{
        description: ""
    },{
        description: ""
    }];

    this.createPoll = function() {
        $http.post('/api/list', { title: this.title, pollItems: this.pollItems });
    }

    this.addItem = function() {
        this.pollItems.push({
            description: ""
        });
    }

}

angular
    .module('dot-voting')
    .controller('PollCreateController', PollCreateController);