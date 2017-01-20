var myApp = angular.module('refScheduler', []).controller('gameCtrl', function($scope, $http) {
    $http.get('http://localhost:8090/games')
        .then(function success(response){
            $scope.games = response.data;
        }, function error(response) {
            $scope.errors = response.status;
        });
});