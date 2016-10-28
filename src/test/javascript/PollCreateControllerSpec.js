describe("PollCreateController", function() {
    var controller, httpBackend;

    beforeEach(module('dot-voting'));

    beforeEach(inject(function($controller, $httpBackend, $http) {
       httpBackend = $httpBackend;
       controller = $controller('PollCreateController', { $http : $http });
    }));

    describe("when create poll is clicked", function() {

        it("creates a poll with all attributes", function() {
            var expectedTitle = "some title";
            var expectedItems = ['item 1', 'item 2'];

            controller.title = expectedTitle;
            controller.pollItems = expectedItems;
            controller.createPoll();

            httpBackend.when('POST', '/api/list').respond({});
            httpBackend.expectPOST('/api/list', { title: expectedTitle, pollItems: expectedItems });
            httpBackend.flush();
        });


    });
});