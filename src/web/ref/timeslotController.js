var myApp = angular.module('refScheduler', [])
    .controller('timeslotCtrl', ['$scope', 'dataService', function($scope, dataService) {
    dataService.get('timeslots')
        .then(function success(response){
            $scope.timeslots = response.data;
        }, function error(response) {
            $scope.errors = response.status;
        });
}]);