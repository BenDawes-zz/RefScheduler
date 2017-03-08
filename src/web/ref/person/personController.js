angular.module('refScheduler')
    .controller('personCtrl', ['$scope', 'dataService', '$location', '$routeParams', function($scope, dataService, $location, $routeParams) {
    dataService.get('persons')
        .then(function success(response){
            $scope.persons = response.data;
        }, function error(response) {
            $scope.errors = response.status;
        });

        if ($routeParams.id) {
            dataService.get('person/' + $routeParams.id)
                .then(function success(response) {
                    $scope.id = response.data.id;
                    $scope.firstName = response.data.firstName;
                    $scope.lastName = response.data.lastName;
                    $scope.email = response.data.emailAddress;
                    $scope.hrLevel = response.data.headRefereeLevel;
                    $scope.arLevel = response.data.assistantRefereeLevel;
                    $scope.srLevel = response.data.snitchRefereeLevel;
                    $scope.snitch = response.data.snitch;
                }, function error(response) {
                    window.alert("Couldn't retrieve person");
                    $location.path("/person");
                });
        } else {
            $scope.id = '';
            $scope.firstName = '';
            $scope.lastName = '';
            $scope.email = '';
            $scope.hrLevel = '';
            $scope.arLevel = '';
            $scope.srLevel = '';
            $scope.snitch = '';
        }

        $scope.submit = function() {
          dataService.post('person',
            {
                id: $scope.id,
                firstName: $scope.firstName,
                lastName: $scope.lastName,
                emailAddress: $scope.email,
                headRefereeLevel: $scope.hrLevel,
                assistantRefereeLevel: $scope.arLevel,
                snitchRefereeLevel: $scope.srLevel,
                snitch: $scope.snitch
            })
          .then(function success(response) {
                $location.path("/person");
          }, function error(response) {
                $scope.errors = response.status;
                window.alert("Created failed");
          });
        };

        $scope.delete = function(person) {
            dataService.delete('person/' + person.id)
            .then(function success(response) {
                $scope.persons.splice($scope.persons.indexOf(person), 1);
            }, function error(response) {
                window.alert("Delete failed!");
            });
        };
}]);