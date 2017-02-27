var myApp = angular.module('refScheduler', [])
    .controller('teamsCtrl', ['$scope', 'dataService', function($scope, dataService) {
    dataService.get('teams')
        .then(function success(response){
            $scope.teams = response.data;
        }, function error(response) {
            $scope.errors = response.status;
        });

        $scope.name = '';
        $scope.location = '';

        $scope.submit = function() {
          dataService.post('team',
            {
                name: $scope.name,
                location: $scope.location
            })
          .then(function success(response) {
                $scope.response = response.data;
                window.alert("Team created")
          }, function error(response) {
                $scope.errors = response.status;
                window.alert("Create failed")
          });
        };
}]);