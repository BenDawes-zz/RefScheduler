var myApp = angular.module('refScheduler', []).controller('teamAffiliationCtrl', function($scope, $http) {
    $http.get('http://localhost:8090/affiliations')
        .then(function success(response){
            $scope.teamAffiliations = response.data;
        }, function error(response) {
            $scope.errors = response.status;
        });
});