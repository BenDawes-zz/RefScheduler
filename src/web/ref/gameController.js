var myApp = angular.module('refScheduler', [])
.controller('gameCtrl', ['$scope', 'dataService', function($scope, dataService) {
    dataService.get('games')
        .then(function success(response){
            $scope.games = response.data;
        }, function error(response) {
            $scope.errors = response.status;
        });
}]);