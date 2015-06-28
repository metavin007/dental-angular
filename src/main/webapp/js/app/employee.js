/* global angular */

angular.module('employee', ['checklist-model']);
angular.module('employee')
        .controller('EmployeeController', function ($scope, $http) {
            $scope.keyword = null;
            $scope.employees = {};
            $scope.employee = {};
            
            $scope.authorities = {};
            $scope.departments = {
                content : []
            };


            $scope.error = {};
            $scope.page = 1;
            load();
            function load() {
                $http.get('/employees').success(function (data) {
                    $scope.employees = data;
                    angular.forEach(data.content, function(item){
                        console.log(item.department);
                    });
                }).error(function (data, status, header, config) {
                });
            }
            /////////////////////////////////////////////////////////////////////////////////////
            loaddepartment();
            function loaddepartment() {
                $http.get('/department').success(function (data) {
                    $scope.departments = data;
                    console.log(data);
                }).error(function (data, status, header, config) {
                });
            }
            
            loadauthority();
            function loadauthority() {
                $http.get('/authority').success(function (data) {
                    $scope.authorities = data;
                }).error(function (data, status, header, config) {
                });
            }
            loadauthority();
//            $scope.selectDepartment = function(){
//                console.log($scope.dep);
//            };
            
            $scope.savedepartment = function () {
                $http.post('/department', $scope.departments).success(function (data) {
                    loaddepartment();
                    $scope.error = {};
                }).error(function (data, status, header, config) {
                });
            };
            $scope.deletedepartment = function (dep) {
                $http.post('/departmentdelete', dep).success(function (data) {
                    loaddepartment();
                }).error(function (data, status, header, config) {
                });
            };
            ////////////////////////////////////////////////////////////////////////////////////////
            $scope.click = function () {
                $scope.employees = $scope.departments;
            };

            $scope.clear = function () {
                $scope.error = {};
            };

            $scope.save = function () {
                $http.post('/employeessave', $scope.employee).success(function (data) {
                    load();
                    $scope.error = {};
                }).error(function (data, status, header, config) {
                    $scope.error = data;
                });
            };
            $scope.delete = function (emp) {
                $http.post('/employeesdelete', emp).success(function (data) {
                    load();
                }).error(function (data, status, header, config) {

                });
            };
            $scope.searchUser = function () {
                if (!$scope.keyword) {
                    load();
                }
                $http.post('/employees/search', $scope.keyword).success(function (data) {
                    $scope.employees = data;
                });
            };
            $scope.nextPage = function () {
                $scope.page++;
            };
            $scope.backPage = function () {
                $scope.page--;
            };


        });