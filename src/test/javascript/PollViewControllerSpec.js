describe("PollViewController", function() {
    var controller, httpBackend;

    beforeEach(module('dot-voting'));

    describe("when created", function() {
        it("requests a list of choices", function() {
            inject(function($controller, $httpBackend, $http) {
                httpBackend = $httpBackend;

                $httpBackend.when('GET', '/api/list').respond({});

                httpBackend.expectGET('/api/list');
                controller = $controller('PollViewController', { $http : $http });
                httpBackend.flush();
            });
        })

    });
});