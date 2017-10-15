'use strict';
angular.module('myApp.imageModifyFactory', [])
    .factory('imageModifyFactory', function ($http) {
        var imgModel = {};

        imgModel.loadImgs = function () {
             return $http.get("/imgs/list");
        };
//        imgModel.removeImg = function (uuid) {
//             return $http.get("/imgs/remove/" + uuid);
//        };
        imgModel.get = function (uuid) {
             return $http.get("/imgs/get/" + uuid);
        };
        imgModel.enable = function (uuid) {
             return $http.get("/imgs/enable/" + uuid);
        };
        imgModel.updateDesc = function (uuid, desc) {
              return $http.get("/imgs/updateDescripton/" + uuid+ "/"+ desc);
        };
        return imgModel;
    });