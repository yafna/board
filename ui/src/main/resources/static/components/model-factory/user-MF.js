'use strict';
angular.module('myApp.userModifyFactory', [])
    .factory('userModifyFactory', function ($http) {
        var userModel = {};
        userModel.saveUser = function(uuid, name, team){
            var dataObj = {
                uuid: uuid,
                name: name,
                team: "",
                teamUuids: team
            };
            return $http({
                method: 'POST',
                url: '/users/modify',
                data: dataObj,
                headers: {
                    'Content-Type': 'application/json'
                }
            });
        };
        userModel.preloadData = function () {
            return $http.get("/calendar/preload");
        };
        userModel.loadUsers = function () {
            return $http.get("/users/list");
        };
        userModel.getUser = function (uuid) {
            return $http.get("/users/get/" + uuid);
        };
        userModel.removeUser = function (uuid) {
            return $http.get("/users/remove/" + uuid);
        };
        return userModel;
    });