/**
 * http://usejsdoc.org/
 */
angular.module('Modules', ['ui.bootstrap', 'ui.utils']);
var app = angular.module('springcurd', ['Modules']);
app.controller('BodyController', ['$scope', function ($scope) {
    $scope.projectName = "Spring MVC CRUD";
}]);
app.service('userservice', ['$rootScope', '$http'
                            ,
    function ($rootScope, $http) {
        var userservicefactory = {};
        userservicefactory.findall = function () {
            $http.get('Userlist').success(function (response) {
                // console.log(response.userlist);
                $rootScope.userlistdata = response.userlist
            }).error(function (response) {
                alert(response);
            });
        };
        return userservicefactory;
                            }]);
app.controller('crudController', ['$scope', '$http', 'userservice', function ($scope, $http, userservice) {
    var config = {
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        }
    };
    userservice.findall();
    $scope.selected = {};
    $scope.getTemplate = function (u) {
        if (u.id === $scope.selected.id) return 'edit.html';
        else return 'view.html';
    };
    $scope.edit = function (u) {
        $scope.selected = angular.copy(u);
    };
    $scope.deleteuser = function (u) {
        var data = $.param({
            id: u.id,
        });
        $http.post('Deleteuser', data, config).then(function (response) {
            $scope.selected = {};
            userservice.findall();
            alert("Successfully Deleted");
        }, function (response) {
            alert("Request Failed!.." + response);
        });
    };
    $scope.save = function () {
        var data = $.param({
            id: $scope.selected.id,
            firstname: $scope.selected.firstname,
            lastname: $scope.selected.lastname
        });
        $http.post('Updateuser', data, config).then(function (response) {
            $scope.selected = {};
            userservice.findall();
            alert("Successfully Stored");
        }, function (response) {
            alert("Request Failed!.." + response);
        });
    };
    $scope.cancel = function () {
        $scope.selected = {};
    };
    $scope.submit = function () {
        var data = $.param({
            firstname: $scope.firstname,
            lastname: $scope.lastname
        });
        $http.post('adduser', data, config).then(function (response) {
            userservice.findall();
            alert("Successfully Stored");
            
        }, function (response) {
            alert("Request Failed!.." + response);
        });
    };
    $scope.validationOpt = {
        rules: {},
        submitHandler: function () {
            $scope.submit();
            // 
        }
    };
}]);