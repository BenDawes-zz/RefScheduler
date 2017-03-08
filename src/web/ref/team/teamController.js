angular.module('refScheduler')
    .controller('teamCtrl', ['$scope', 'dataService', '$location', '$routeParams', function($scope, dataService, $location, $routeParams) {
    dataService.get('teams')
        .then(function success(response){
            $scope.teams = response.data;
        }, function error(response) {
            $scope.errors = response.status;
        });

        if ($routeParams.id) {
            dataService.get('/timeslot' + $routeParams.id)
                .then(function success(response) {
                    $scope.id = response.data.id;
                    $scope.name = response.data.name;
                    $scope.location = response.data.location;
                }, function error(response) {
                    window.alert("Couldn't retrieve team");
                    $location.path("/team");
                });
        } else {
            $scope.id = '';
            $scope.name = '';
            $scope.location = '';
        }

        $scope.submit = function() {
          dataService.post('team',
            {
                id: $scope.id,
                name: $scope.name,
                location: $scope.location
            })
          .then(function success(response) {
                $location.path("/team");
          }, function error(response) {
                $scope.errors = response.status;
                window.alert("Create failed");
          });
        };

        $scope.delete = function(team) {
            dataService.delete('team/' + team.id)
            .then(function success(response) {
                $scope.teams.splice($scope.persons.indexOf(team), 1);
            }, function error(response) {
                window.alert("Delete failed!");
            });
        };
}]);