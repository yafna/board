'use strict';
angular.module('myApp.settingsModifyFactory', [])
    .factory('settingsModifyFactory', function ($http) {
        var settingsModel = {};

        settingsModel.switchEditable = function () {
             return $http.get("/settings/switchEditable");
        };
        settingsModel.get = function () {
             return $http.get("/settings/get");
        };

        return settingsModel;
    });