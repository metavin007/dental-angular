angular.module('customer', []);
angular.module('customer', ['checklist-model']).controller('customerController', function ($scope, $http) {

    $scope.customer = {};
    $scope.medicalhistorys = {};
    $scope.medicalhistory = {};
    $scope.error = {};
    $scope.saveCustomer = function () {
        console.log($scope.customer);
        $http.post('/customers', $scope.customer).success(function (data) {

        }).error(function (data) {
            $scope.error = data;
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