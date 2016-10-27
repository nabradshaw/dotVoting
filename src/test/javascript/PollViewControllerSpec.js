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

    describe("when voteTotal called", function(){
        it("returns 0 when no votes cast", function(){
            controller.poll = createMockJsonModel(0,0);
            expect(controller.voteTotal()).toEqual(0);
        });

        it("returns the sum of the votes cast", function(){
            controller.poll = createMockJsonModel(1,2);
            expect(controller.voteTotal()).toEqual(3);
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