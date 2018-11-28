'use strict';
angular.module('myApp.teamModifyFactory', [])
    .factory('teamModifyFactory', function ($http) {
        var teamModel = {};

        teamModel.saveTeam = function(uuid, name){
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
        teamModel.loadTeams = function () {
             return $http.get("/team/list");
        };
        teamModel.getTeam = function (uuid) {
             return $http.get("/team/get/" + uuid);
        };
        teamModel.removeTeam = function (uuid) {
             return $http.get("/team/remove/" + uuid);
        };

        return teamModel;
    });