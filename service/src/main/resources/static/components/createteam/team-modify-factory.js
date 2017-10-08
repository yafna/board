'use strict';
angular.module('myApp.teamModifyFactory', [])
    .factory('teamModifyFactory', function ($http) {
        var userModel = {};

        userModel.saveTeam = function(uuid, name){
            var dataObj = {
                uuid: uuid,
                name: name
            };
            return $http({
                method: 'POST',
                url: '/team/modify',
                data: dataObj,
                headers: {
                    'Content-Type': 'application/json'
                }
            });
        };
        userModel.empty = function(){
            return {
                uuid : "",
                name : ""
            }
        };
        return userModel;
    });