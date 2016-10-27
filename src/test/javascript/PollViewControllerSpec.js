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

        it("attaches list to controller", function() {
               inject(function($controller, $httpBackend, $http) {
                   httpBackend = $httpBackend;

                   $httpBackend.when('GET', '/api/list').respond([1,2,3,4]);
                   controller = $controller('PollViewController', { $http : $http });

                   httpBackend.flush();
                   expect(controller.list).toEqual([1,2,3,4]);
               });
           });

    });
});