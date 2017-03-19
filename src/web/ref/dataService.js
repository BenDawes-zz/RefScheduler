angular.module('refScheduler')
    .service('dataService', ['$http', function ($http) {
        var baseUrl = 'http://localhost:8090/';

        this.get = function (url) {
            return $http.get(baseUrl + url);
        }

        this.post = function (url, data) {
            return $http.post(baseUrl + url, preProcess(data));
        }

        this.put = function (url, data) {
            return $http.put(baseUrl + url, preProcess(data));
        }

        this.delete = function (url) {
            return $http.delete(baseUrl + url);
        }

        function preProcess(data) {
            for (var key in data) {
                if (data.hasOwnProperty(key) && data[key] === ""){
                    data[key] = null;
                }
            }
            return data;
        }
}]);