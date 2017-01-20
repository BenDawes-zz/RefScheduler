var myApp = angular.module('refScheduler', []).controller('personCtrl', function($scope, $http) {
    $http.get('http://localhost:8090/persons')
        .then(function success(response){
            $scope.persons = response.data;
        }, function error(response) {
            $scope.errors = response.status;
        });
});