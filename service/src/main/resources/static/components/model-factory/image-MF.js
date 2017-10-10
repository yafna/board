'use strict';
angular.module('myApp.imageModifyFactory', [])
    .factory('imageModifyFactory', function ($http) {
        var imgModel = {};

        imgModel.loadImgs = function () {
             return $http.get("/imgs/list");
        };
        imgModel.removeImg = function (uuid) {
             return $http.get("/img/remove/" + uuid);;
        };
        return imgModel;
    });