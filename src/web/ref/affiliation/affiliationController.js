angular.module('refScheduler')
    .controller('affiliationCtrl', ['$scope', 'dataService', '$location', '$routeParams', function($scope, dataService, $location, $routeParams) {
    dataService.get('affiliations')
        .then(function success(response){
            $scope.affiliations = response.data;
            return dataService.get('teams');
        })
        .then(function success(response){
            $scope.teams = response.data;
            return dataService.get('persons');
        })
        .then(function success(response) {
            $scope.persons = response.data;
            if ($routeParams.id) {
                $scope.edit = true;
                dataService.get('affiliation/' + $routeParams.id)
                    .then(function success(response) {
                        $scope.id = response.data.id;
                        $scope.team = findById($scope.teams, response.data.team);
                        $scope.person = findById($scope.persons, response.data.person);
                        $scope.affiliationType = response.data.affiliation;
                    }, function error(response) {
                        window.alert("Couldn't retrieve affiliation`");
                        $location.path("/affiliation");
                    });
            } else {
                $scope.id = '';
                $scope.team = '';
                $scope.person = '';
                $scope.affiliationType = '';
            }
        });

        $scope.submit = function() {
          dataService.post('affiliation',
            {
                id: $scope.id,
                team: $scope.team,
                person: $scope.person,
                affiliation: $scope.affiliationType,
            })
          .then(function success(response) {
                $location.path("/affiliation");
          }, function error(response) {
                $scope.errors = response.status;
                window.alert("Created failed");
          });
        };

        $scope.submitAndCreateAnother = function() {
          dataService.post('affiliation',
            {
                id: $scope.id,
                team: $scope.team,
                person: $scope.person,
                affiliation: $scope.affiliationType,
            })
          .then(function success(response) {
                window.alert("Create successful");
                $scope.team = '';
                $scope.person = '';
                $scope.affiliationType = '';
          }, function error(response) {
                $scope.errors = response.status;
                window.alert("Create failed");
          });
        };

        $scope.delete = function(affiliation) {
            dataService.delete('affiliation/' + affiliation.id)
            .then(function success(response) {
                $scope.affiliations.splice($scope.affiliations.indexOf(affiliation), 1);
            }, function error(response) {
                window.alert("Delete failed!");
            });
        };

        function findById(list, findItem) {
            if (list && findItem) {
                for (var i = 0; i < list.length; i++) {
                    if (list[i] && list[i].id === findItem.id) {
                        return list[i];
                    }
                }
            }

            return null;
        }
}]);