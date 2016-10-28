describe("PollCreateController", function() {
    var controller, location, httpBackend;

    beforeEach(module('dot-voting'));

    beforeEach(inject(function($controller, $httpBackend, $http) {
       location = jasmine.createSpyObj('location', ['url']);
       httpBackend = $httpBackend;
       controller = $controller('PollCreateController', { $http : $http, $location: location });
    }));

    describe("when create poll is clicked", function() {

        it("creates a poll with all attributes", function() {
            var expectedTitle = "some title";
            var expectedItems = ['item 1', 'item 2'];

            controller.title = expectedTitle;
            controller.pollItems = expectedItems;
            controller.createPoll();

            httpBackend.when('POST', '/api/poll').respond({});
            httpBackend.expectPOST('/api/poll', { title: expectedTitle, pollItems: expectedItems });
            httpBackend.flush();
        });

        it('should redirect to the newly created poll', function() {
            controller.createPoll();

            httpBackend.when('POST', '/api/poll').respond({});
            httpBackend.flush();

            expect(location.url).toHaveBeenCalledWith('/');
        });


    });

     describe("when a delete button is clicked", function() {

            it("removes the poll item", function() {
                controller.pollItems = [1, 2];
                controller.deleteItem(0);

                expect(controller.pollItems.length).toEqual(1);
                expect(controller.pollItems[0]).toEqual(2);
            });

        });

    describe('when new item button is clicked', function() {
        it('should add a new item text area', function() {
            controller.pollItems = [];
            controller.addItem();

            expect(controller.pollItems.length).toEqual(1);
            expect(controller.pollItems[0].description).toEqual("");
        });
    });

    describe('when loading the page', function() {
        it('should default with two empty poll items', function() {
            expect(controller.pollItems.length).toEqual(2);
            expect(controller.pollItems[0].description).toEqual("");
            expect(controller.pollItems[1].description).toEqual("");
        });
    });

    describe('when there are more than two items', function() {
        it('should show the delete button on the poll items', function() {
            controller.pollItems = [1, 2, 3];

            expect(controller.canDelete()).toEqual(true);
        });
    });

    describe('when there are two or less items', function() {
            it('should not show the delete button on the poll items', function() {
                controller.pollItems = [1, 2];

                expect(controller.canDelete()).toEqual(false);
            });
        });
});