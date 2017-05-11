angular.module('refScheduler')
    .controller('timeslotCtrl', ['$scope', 'dataService', '$location', '$routeParams', function($scope, dataService, $location, $routeParams) {
    dataService.get('timeslots')
        .then(function success(response){
            $scope.timeslots = response.data;
        }, function error(response) {
            $scope.errors = response.status;
        });

        if ($routeParams.id) {
            dataService.get('/timeslot' + $routeParams.id)
                .then(function success(response) {
                    $scope.id = response.data.id;
                    $scope.time = response.data.time;
                }, function error(response) {
                    window.alert("Couldn't retrieve timeslot");
                    $location.path("/timeslot");
                });
        } else {
            $scope.id = '';
            $scope.time = '';
        }

        $scope.submit = function() {
          var dateTime = new Date($scope.time);
          dataService.post('timeslot',
            {
                id: $scope.id,
                time: dateTime.toISOString()
            })
          .then(function success(response) {
                $location.path("/timeslot");
          }, function error(response) {
                $scope.errors = response.status;
                window.alert("Create failed");
          });
        };

        $scope.delete = function(timeslot) {
            dataService.delete('timeslot/' + timeslot.id)
            .then(function success(response) {
                $scope.timeslots.splice($scope.persons.indexOf(timeslot), 1);
            }, function error(response) {
                window.alert("Delete failed!");
            });
        };
}]);