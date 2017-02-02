var myApp = angular.module('refScheduler', []).controller('teamsCtrl', function($scope, $http) {
    $http.get('http://localhost:8090/teams')
        .then(function success(response){
            $scope.teams = response.data;
        }, function error(response) {
            $scope.errors = response.status;
        });

        $scope.name = '';
        $scope.location = '';

        $scope.submit = function() {
          $http({
            method: 'POST',
            url: 'http://localhost:8090/team',
            data: {
                name: $scope.name,
                location: $scope.location
            }
          }).then(function success(response) {
                $scope.response = response.data;
          }, function error(response) {
                $scope.errors = response.status;
          });
        };
});