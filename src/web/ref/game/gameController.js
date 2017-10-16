angular.module('refScheduler')
.controller('gameCtrl', ['$scope', 'dataService', '$location', '$routeParams', function($scope, dataService, $location, $routeParams) {
    dataService.get('game')
        .then(function success(response) {
            $scope.games = response.data;
            return dataService.get('teams');
        })
        .then(function success(response) {
            $scope.teams = response.data;
            return dataService.get('timeslots');
        })
        .then(function success(response) {
            $scope.timeslots = response.data;
            return dataService.get('persons')
        })
        .then(function success(response) {
            $scope.persons = response.data;
        })
        .then(function success(response) {
            if ($routeParams.id) {
                $scope.edit = true;
                dataService.get('game/' + $routeParams.id)
                    .then(function success(response) {
                        $scope.id = response.data.id;
                        $scope.teamA = findById($scope.teams, response.data.teamA);
                        $scope.teamB = findById($scope.teams, response.data.teamB);
                        $scope.pitch = response.data.pitch;
                        $scope.timeslot = findById($scope.timeslots, response.data.timeslot);
                        $scope.headReferee = findById($scope.persons, response.data.headReferee);
                        $scope.assistantReferees = findById($scope.persons, response.data.assistantReferees);
                        $scope.snitchReferee = findById($scope.persons, response.data.snitchReferee);
                        $scope.snitch = findById($scope.persons, response.data.snitch);
                    }, function error(response) {
                        window.alert("Couldn't retrieve game");
                        $location.path("/game");
                    });
            } else {
                $scope.edit = false;
                $scope.id = '';
                $scope.teamA = '';
                $scope.teamB = '';
                $scope.pitch = '';
                $scope.headReferee = '';
                $scope.assistantReferees = [];
                $scope.snitchReferee = '';
                $scope.snitch = '';
            }
        });

        $scope.submit = function() {
          dataService.post('game',
            {
                id: $scope.id,
                teamA: $scope.teamA,
                teamB: $scope.teamB,
                pitch: $scope.pitch,
                timeslot: $scope.timeslot,
                headReferee: $scope.headReferee,
                assistantReferees: $scope.assistantReferees,
                snitchReferee: $scope.snitchReferee,
                snitch: $scope.snitch
            })
          .then(function success(response) {
                $location.path("/game");
          }, function error(response) {
                $scope.errors = response.status;
                window.alert("Created failed");
          });
        };

        $scope.delete = function(game) {
            dataService.delete('game/' + game.id)
            .then(function success(response) {
                $scope.games.splice($scope.games.indexOf(game), 1);
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