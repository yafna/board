'use strict';

var appInstalled = angular.module('myApp.createuser', ['ngRoute']);

appInstalled
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/modifyUser', {
            templateUrl: 'components/createuser/create-user.html',
            controller: 'CreateUserCtrl'
        });
    }])

    .controller('CreateUserCtrl', ['userModifyFactory', function (userModifyFactory) {
        var self = this;

        self.result = "";

        self.send = function () {
            userModifyFactory.saveUser(self.user.uuid, self.user.name, self.user.teamId)
                .success(function (data, status, headers, config) {
                    self.result = data;
                })
                .error(function (data, status, headers, config) {
                    self.result = "failure message: " + JSON.stringify({data: data});
                });
        };
    }]);