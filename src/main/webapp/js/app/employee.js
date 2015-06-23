/* global angular */

angular.module('employee', []);
angular.module('employee')
        .controller('EmployeeController', function ($scope, $http) {

            $scope.employees = {};
            $scope.employee = {};
            $scope.error = {};
            load();
            function load () {
                $http.get('/users').success(function (data) {
                    $scope.employees = data;
                }).error(function (data, status, header, config) {

                });
            };
            
            $scope.clear = function (){
              $scope.error = {};  
            };
            
            $scope.save = function() {
                $http.post('/userssave', $scope.employee).success(function (data) {
                    load();
                    $scope.error = {};
                }).error(function (data, status, header, config) {
                      $scope.error = data;
                });
            };
            $scope.delete = function(emp) {
                $http.post('/usersdelete',emp).success(function (data) {
                    load();
                }).error(function (data, status, header, config) {

                });
            };
        });