function PollCreateController($http, $location) {
    this.title = "";
    this.pollItems = [{
        description: ""
    },{
        description: ""
    }];

    this.createPoll = function() {
        $http.post('/api/list', { title: this.title, pollItems: this.pollItems }).then(function() {
            $location.url('/');
        });
    }

    this.addItem = function() {
        this.pollItems.push({
            description: ""
        });
    }

    this.deleteItem = function(index) {
        this.pollItems.splice(index, 1);
    }

    this.canDelete = function() {
        return this.pollItems.length > 2;
    }

}

angular
    .module('dot-voting')
    .controller('PollCreateController', PollCreateController);