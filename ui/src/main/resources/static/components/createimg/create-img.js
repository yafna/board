'use strict';

var appInstalled = angular.module('myApp.createimg', ['ngRoute']);

appInstalled
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
        .when('/modifyImg', {
            templateUrl: 'components/createimg/create-img.html',
            controller: 'CreateImgCtrl'
        })
        .when('/modifyImg/:id', {
             templateUrl: 'components/createimg/create-img.html',
             controller: 'CreateImgCtrl'
        });
    }])

    .controller('CreateImgCtrl', function (imageModifyFactory, $routeParams, $location) {
        var self = this;
        self.result = "";
        self.editmode = false;
        if($routeParams.id !== undefined){
            self.editmode = true;
            self.img = imageModifyFactory.get($routeParams.id).then(
                function (resp){
                     self.img = resp.data;
            })
        }
        self.send = function () {
            imageModifyFactory.updateDesc(self.img.uuid, self.img.description)
                .then(function (data, status, headers, config) {
                    self.result = data;
                    $location.path( "/adminview" );
                 })
        };
    });