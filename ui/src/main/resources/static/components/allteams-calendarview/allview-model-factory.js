'use strict';
angular.module('myApp.allviewTableFactory', [])
    .factory('allviewModelFactory', function (allviewHttpFactory, $modal) {
        var page = {};

        page.loadTable = function () {
            return allviewHttpFactory.loadTable();
        };
        page.loadTableForTeam = function (uuid) {
            return allviewHttpFactory.loadTableForTeam(uuid);
        };
        page.dostatus = function(userid, dayId, imgid) {
            return allviewHttpFactory.dostatus(userid, dayId, imgid);
        }
        return page;
    });