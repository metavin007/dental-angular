/* global angular */

angular.module('employee', []);
angular.module('employee')
        .controller('EmployeeController', function ($scope, $http) {
            $scope.keyword = null;
            $scope.employees = {};
            $scope.employee = {};

            $scope.addauthority = {};
            $scope.bankaccount = {};
            $scope.contactpersion = {};
            $scope.departments = {};
            $scope.authoritys = {};
            $scope.error = {};
            load();
            function load() {
                $http.get('/users').success(function (data) {
                    $scope.employees = data;
                }).error(function (data, status, header, config) {

                });
            }
            loaddepartment();
            function loaddepartment() {
                $http.get('/department').success(function (data) {
                    $scope.departments = data;
                }).error(function (data, status, header, config) {

                });
            };
            loadauthority();
            function loadauthority() {
                $http.get('/authoritytest').success(function (data) {
                    $scope.authoritys = data;
                    console.log(data);
                }).error(function (data, status, header, config) {

                });
            };


            $scope.clear = function () {
                $scope.error = {};
            };

            $scope.save = function () {
                $http.post('/userssave', $scope.employee).success(function (data) {
                    load();
                    $scope.error = {};
                }).error(function (data, status, header, config) {
                    $scope.error = data;
                });
            };
            $scope.delete = function (emp) {
                $http.post('/usersdelete', emp).success(function (data) {
                    load();
                }).error(function (data, status, header, config) {

                });
            };
            $scope.searchUser = function () {
                if (!$scope.keyword) {
                    load();
                }
                $http.post('/users/search', $scope.keyword).success(function (data) {
                    $scope.employees = data;
                });
            };

            $scope.saveaddauthority = function () {
                $http.post('/authoritysave', $scope.addauthority).success(function (data) {

                }).error(function (data, status, header, config) {

                });
            };
            $scope.savebankaccount = function () {
                $http.post('/bankAccountsave', $scope.bankaccount).success(function (data) {

                }).error(function (data, status, header, config) {

                });
            };
            $scope.savecontactPersion = function () {
                $http.post('/contactPersionsave', $scope.contactpersion).success(function (data) {

                }).error(function (data, status, header, config) {

                });
            };
        });