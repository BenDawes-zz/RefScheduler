var refScheduler = angular.module('refScheduler', ['ngRoute']);

refScheduler.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'ref/home.html',
            controller: 'mainCtrl'
        })
        .when('/person', {
            templateUrl: 'ref/person/persons.html',
            controller: 'personCtrl'
        })
        .when('/person/create', {
            templateUrl: 'ref/person/personInput.html',
            controller: 'personCtrl'
        })
        .when('/person/:id', {
            templateUrl: 'ref/person/personInput.html',
            controller: 'personCtrl'
        })
        .when('/game', {
            templateUrl: 'ref/game/games.html',
            controller: 'gameCtrl'
        })
        .when('/game/create', {
            templateUrl: 'ref/game/gameInput.html',
            controller: 'gameCtrl'
        })
        .when('/game/:id', {
            templateUrl: 'ref/game/gameInput.html',
            controller: 'gameCtrl'
        })
        .when('/affiliation', {
            templateUrl: 'ref/affiliation/affiliations.html',
            controller: 'affiliationCtrl'
        })
        .when('/affiliation/create', {
            templateUrl: 'ref/affiliation/affiliationInput.html',
            controller: 'affiliationCtrl'
        })
        .when('/affiliation/:id', {
            templateUrl: 'ref/affiliation/affiliationInput.html',
            controller: 'affiliationCtrl'
        })
        .when('/team', {
            templateUrl: 'ref/team/teams.html',
            controller: 'teamCtrl'
        })
        .when('/team/create', {
            templateUrl: 'ref/team/teamInput.html',
            controller: 'teamCtrl'
        })
        .when('/team/:id', {
            templateUrl: 'ref/team/teamInput.html',
            controller: 'teamCtrl'
        })
        .when('/timeslot', {
            templateUrl: 'ref/timeslot/timeslots.html',
            controller: 'timeslotCtrl'
        })
        .when('/timeslot/create', {
            templateUrl: 'ref/timeslot/timeslotInput.html',
            controller: 'timeslotCtrl'
        })
        .when('/timeslot/:id', {
            templateUrl: 'ref/timeslot/timeslotInput.html',
            controller: 'timeslotCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });
});

refScheduler.controller('mainCtrl', ['$scope', 'dataService', function($scope, dataService) {
    $scope.schedule = function() {
        dataService.get('game/schedule');
    };
}]);
