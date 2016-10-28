describe("PollCreateController", function() {
    var controller, httpBackend;

    beforeEach(module('dot-voting'));

    beforeEach(inject(function($controller, $httpBackend, $http) {
       httpBackend = $httpBackend;
       controller = $controller('PollCreateController', { $http : $http });
    }));

    describe("when create poll is clicked", function() {

        describe('creates a poll with', function() {
            it("a title", function() {
                var expected = "some title";
                controller.title = expected;
                controller.createPoll();

                httpBackend.when('POST', '/api/list').respond({});
                httpBackend.expectPOST('/api/list', { title: expected });
                httpBackend.flush();
            });
        });


    });
});