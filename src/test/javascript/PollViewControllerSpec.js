describe("PollViewController", function() {
    var controller, httpBackend;

    beforeEach(module('dot-voting'));

    beforeEach(inject(function($controller, $httpBackend, $http) {
        httpBackend = $httpBackend;
        controller = $controller('PollViewController', { $http : $http });
    }));

    describe("when getPoll is called", function() {
        it("requests a list of choices", function() {
            httpBackend.when('GET', '/api/list').respond({});
            httpBackend.expectGET('/api/list');

            controller.getPoll();

            httpBackend.flush();
        });

        it("attaches list to controller", function() {
           httpBackend.when('GET', '/api/list').respond([1,2,3,4]);

           controller.getPoll();

           httpBackend.flush();
           expect(controller.poll).toEqual([1,2,3,4]);
        });

        it("Vote total is empty when no votes cast", function() {
            httpBackend.when('GET', '/api/list').respond(createMockJsonModel(0, 0));
            controller.getPoll();
            httpBackend.flush();

            expect(controller.voteTotal).toEqual(0);
        });

        it("Calculates Vote total", function() {
            httpBackend.when('GET', '/api/list').respond(createMockJsonModel(1, 2));
            controller.getPoll();
            httpBackend.flush();

            expect(controller.voteTotal).toEqual(3);
        });
    });

    describe("when doSubmit called", function() {
        it("posts the entire poll to the server", function() {
            controller.poll = createMockJsonModel(1, 2);
            httpBackend.expectPOST('/api/vote', createMockJsonModel(1, 2)).respond({});

            controller.doSubmit();

            httpBackend.flush();
        });
    });

    function createMockJsonModel(voteCount1, voteCount2){
        return {id:'test1',
            title:'test model',
            pollItems:[
                {
                    id:'testItem1',
                    description:'item 1',
                    voteCount:voteCount1
                },
                {
                    id:'testItem2',
                    description:'item 2',
                    voteCount:voteCount2
                }
            ]
         };
    }
});