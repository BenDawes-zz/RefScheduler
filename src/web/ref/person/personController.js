angular.module('refScheduler')
    .controller('personCtrl', ['$scope', 'dataService', function($scope, dataService) {
    dataService.get('persons')
        .then(function success(response){
            $scope.persons = response.data;
        }, function error(response) {
            $scope.errors = response.status;
        });

        $scope.firstName = '';
        $scope.lastName = '';
        $scope.email = '';
        $scope.hrLevel = '';
        $scope.arLevel = '';
        $scope.srLevel = '';
        $scope.snitch = '';

        $scope.submit = function() {
          dataService.post('person',
            {
                firstName: $scope.firstName,
                lastName: $scope.lastName,
                emailAddress: $scope.email,
                headRefereeLevel: $scope.hrLevel,
                assistantRefereeLevel: $scope.arLevel,
                snitchRefereeLevel: $scope.srLevel,
                snitch: $scope.snitch
            })
          .then(function success(response) {
                $scope.response = response.data;
                window.alert("Person created")
          }, function error(response) {
                $scope.errors = response.status;
                window.alert("Created failed")
          });
        };

        $scope.delete = function(person) {
            dataService.delete('person/' + person.id)
            .then(function success(response) {
                $scope.persons.splice($scope.persons.indexOf(person), 1);
            }, function error(response) {
                window.alert("Delete failed!")
            });
        }
}]);