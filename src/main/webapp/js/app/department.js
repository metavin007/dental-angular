/* global angular */

angular.module('department', []);
angular.module('department')
        .controller('departmentController', function ($scope, $http) {

            $scope.departments = {};
            $scope.department = {};
            $scope.error = {};
            $scope.keyword = null;
            load();
            function load () {
                $http.get('/department',{params:{page:0,size:20,sort:'name,desc'}}).success(function (data) {
                    $scope.departments = data;
                }).error(function (data, status, header, config) {

                });
            };
            
            $scope.clear = function (){
              $scope.error = {};  
            };
            
            $scope.save = function() {
                $http.post('/department', $scope.department).success(function (data) {
                    load();
                    $scope.error = {};
                }).error(function (data, status, header, config) {
                      $scope.error = data;
                });
            };
            
            $scope.delete = function(dep) {
                $http.post('/departmentdelete',dep).success(function (data) {
                    load();
                }).error(function (data, status, header, config) {

                });
            };
            $scope.searchDepartment = function() {
                if (!$scope.keyword) {
                    load();
                }
                $http.post('/department/search', $scope.keyword).success(function(data){
                    $scope.departments = data;
                });
            };
        });