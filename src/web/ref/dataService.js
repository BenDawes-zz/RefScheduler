angular.module('refScheduler')
    .service('dataService', ['$http', function ($http) {
        var baseUrl = 'http://localhost:8090/';

        this.get = function (url) {
            return $http.get(baseUrl + url);
        }

        this.post = function (url, data) {
            return $http.post(baseUrl + url, data);
        }

        this.put = function (url, data) {
            return $http.put(baseUrl + url, data);
        }

        this.delete = function (url) {
            return $http.delete(baseUrl + url);
        }
}]);