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

    describe('when new item button is clicked', function() {
        it('should add a new item text area', function() {
            var pollItems = []

            controller.addItem();

            expect(controller.pollItems.length).toEqual(1);
            expect(controller.pollItems[0].description).toEqual("");
        })
    });
});