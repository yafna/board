'use strict';
angular.module('myApp.viewTableFactory', [])
    .factory('viewModelFactory', function (viewHttpFactory, $modal) {
        var page = {};

        page.loadTable = function () {
            return viewHttpFactory.loadTable();
        };
        page.dostatus = function(userid, dayId, imgid) {
            return viewHttpFactory.dostatus(userid, dayId, imgid);
        }
        return page;
    });