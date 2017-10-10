'use strict';
angular.module('myApp.userModifyFactory', [])
    .factory('userModifyFactory', function ($http) {
        var userModel = {};
        userModel.saveUser = function(uuid, name, team){
            var dataObj = {
                uuid: uuid,
                name: name,
                team: team
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
        userModel.loadUsers = function () {
            return $http.get("/users/list");
        };
        userModel.getUser = function (uuid) {
            return $http.get("/user/get/" + uuid);
        };
        userModel.removeUser = function (uuid) {
            return $http.get("/users/remove/" + uuid);
        };
        return userModel;
    });