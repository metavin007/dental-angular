angular.module('customertest', []);
angular.module('customertest')
        .controller('CustomerController', function ($scope, $http) {
            $scope.customers = {};
            $scope.customer = {};
          
            $http.get('/customers').success(function (data) {
                $scope.customers = data;
            }).error(function (data, status, header, config) {

            });

            $scope.showCustomer = function () {
                $http.get('/customers').success(function (data) {
                    $scope.customers = data;
                }).error(function (data, status, header, config) {

                });
            };


///////////////// Update //////////////////////////////////////////////////////////////            
            $scope.callUpdateCustomer = function (id, name, email, mobile) {
                $scope.customer = {'id': id, 'name': name, 'email': email, 'mobile': mobile};
            };

///////////////// Clear /////////////////////////////////////////////////////////////////            
            $scope.Cleardatacustomer = function () {
                $scope.customer = {'id': "", 'name': "", 'email': "", 'mobile': ""};
            };


////////////// Save and SaveUpdate /////////////////////////////////////////////////////// 
            $scope.saveCustomer = function () {
                $scope.showCustomer();
                $http.post('/customers', $scope.customer)
                        .success(function (data) {
                            
                            $scope.showCustomer();
                        }).error(function (data) {
                    console.log(data);
                    $scope.errors = data;
                });

            };


///////////////// Delete ///////////////////////          
            $scope.callDeleteCustomer = function (id, name, email, mobile) {
                $scope.customers = {'id': id, 'name': name, 'email': email, 'mobile': mobile};
                $http.post('/customerde', $scope.customerde)
                        .success(function (data) {
                            $scope.closeDialogDelete();
                            $scope.showCustomer();

                        }).error(function (data) {
                });
            };
/////////////////////////////// login ////////////////////////////////////////////////////
            $scope.useradmin = {};
            $scope.loginadmin = function (email, password) {
              $scope.useradmin = {'email': email, 'password': password};   
                $http.post('/login', $scope.useradmin)
                        .success(function (data) {     
                        }).error(function (data) {
                });  
            };



/////////////////////////////////////// show dialogDelete ///////////////////////////////
            $scope.showdialogDelete = function (id, name, email, mobile) {
                $scope.customerde = {'id': id, 'name': name, 'email': email, 'mobile': mobile};
                document.getElementById('popup-delete').style.display = 'initial';
                document.getElementById('warpbody').style.display = 'initial';
            };


//////////////////////////////////////  close dialogDelete //////////////////////////////
            $scope.closeDialogDelete = function () {
                document.getElementById('popup-delete').style.display = 'none';
                document.getElementById('warpbody').style.display = 'none';
            };
        });
        
        