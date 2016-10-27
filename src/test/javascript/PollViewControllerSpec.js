describe("PollViewController", function() {
    var controller, httpBackend;

    beforeEach(module('dot-voting'));

    beforeEach(inject(function($controller, $httpBackend, $http) {
        httpBackend = $httpBackend;
        controller = $controller('PollViewController', { $http : $http });
    }));

    describe("when created", function() {
        it("requests a list of choices", function() {
            httpBackend.when('GET', '/api/list').respond({});
            httpBackend.expectGET('/api/list');
            httpBackend.flush();
        });

        it("attaches list to controller", function() {
           httpBackend.when('GET', '/api/list').respond([1,2,3,4]);
           httpBackend.flush();
           expect(controller.poll).toEqual([1,2,3,4]);
        });
    });
});