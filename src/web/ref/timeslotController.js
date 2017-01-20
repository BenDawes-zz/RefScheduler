var myApp = angular.module('refScheduler', []).controller('timeslotCtrl', function($scope, $http) {
    $http.get('http://localhost:8090/timeslots')
        .then(function success(response){
            $scope.timeslots = response.data;
        }, function error(response) {
            $scope.errors = response.status;
        });
});