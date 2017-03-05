angular.module('refScheduler')
    .controller('affiliationCtrl', ['$scope', 'dataService', function($scope, dataService) {
    dataService.get('affiliations')
        .then(function success(response){
            $scope.teamAffiliations = response.data;
        }, function error(response) {
            $scope.errors = response.status;
        });
}]);