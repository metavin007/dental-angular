angular.module('doctor',[]);
angular.module('doctor').controller('doctorController',function ($scope,$http){
    $scope.doctors = {};
    $scope.doctor = {};
    $scope.error = {};
    
   loaddoctor();
            function loaddoctor() {
                $http.get('/showdoctors').success(function (data) {
                    $scope.doctors = data; 
                }).error(function (data, status, header, config) {
                });
            }
            
             $scope.savedoctor = function () {
                $http.post('/savedoctors', $scope.doctor).success(function (data) {                  
                }).error(function (data, status, header, config) {
                    $scope.error = data;                   
                });
            };
});