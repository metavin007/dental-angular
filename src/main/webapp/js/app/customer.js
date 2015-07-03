angular.module('customer', []);
angular.module('customer', ['checklist-model']).controller('customerController', function ($scope, $http) {

    $scope.customer = {};
    $scope.customers = {};
    $scope.medicalhistorys = {};
    $scope.medicalhistory = {};
    $scope.error = {};

    loadcustomer();
    function loadcustomer() {
        $http.get('/customers').success(function (data) {
            $scope.customers = data;
        }).error(function (data, status, header, config) {
        });
    }

    $scope.saveCustomer = function () {
        console.log($scope.customer);
        $http.post('/customers', $scope.customer).success(function (data) {
            alert('saveข้อมูลเรียบร้อย');
        }).error(function (data) {
            $scope.error = data;
            alert('คุณกรอกข้อมูลไม่เรียบร้อย');
        });
    };
    loadMedicalHistory();
    function loadMedicalHistory() {
        $http.get('/medicalhistory').success(function (data) {
            $scope.medicalhistorys = data;
        })
                .error(function (data) {

                });
    }


});