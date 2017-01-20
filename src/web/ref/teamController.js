var myApp = angular.module('refScheduler', []).controller('teamsCtrl', function($scope, $http) {
    $http.get('http://localhost:8090/teams')
        .then(function success(response){
            $scope.teams = response.data;
        }, function error(response) {
            $scope.errors = response.status;
        });
});