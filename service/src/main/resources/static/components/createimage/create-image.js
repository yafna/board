'use strict';

var appInstalled = angular.module('myApp.createimage', ['ngRoute']);

appInstalled
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/modifyImage', {
            templateUrl: 'components/createimage/create-image.html',
            controller: 'CreateImageCtrl'
        });
    }])

    .controller('CreateImageCtrl', ['imageModifyFactory', function (imageModifyFactory) {
        var self = this;

        self.result = "";

        self.send = function () {
            imageModifyFactory.save(self.img.uuid, self.img.desc)
                .success(function (data, status, headers, config) {
                    self.result = data;
                    $location.path( "/adminview" );
                })
                .error(function (data, status, headers, config) {
                    self.result = "failure message: " + JSON.stringify({data: data});
                });
        };
    }]);