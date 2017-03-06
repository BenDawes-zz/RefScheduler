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
        .when('/affiliation', {
            templateUrl: 'ref/affiliation/affiliations.html',
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
        .when('/timeslot', {
            templateUrl: 'ref/timeslot/timeslots.html',
            controller: 'timeslotCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });
});

refScheduler.controller('mainCtrl', ['$scope', function($scope) {}]);
