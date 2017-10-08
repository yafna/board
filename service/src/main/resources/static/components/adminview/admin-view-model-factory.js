'use strict';
angular.module('myApp.adminviewMF', [])
    .factory('adminviewMF', function (adminviewHS, $modal) {
        var page = {};
        page.loadUsers = function () {
            return adminviewHS.loadUsers();
        };
        page.loadTeams = function () {
            return adminviewHS.loadTeams();
        };
        page.loadImgs = function () {
            return adminviewHS.loadImgs();
        };
        page.removeTeam = function (uuid) {
            return adminviewHS.removeTeam(uuid);
        };
        page.removeUser = function (uuid) {
            return adminviewHS.removeUser(uuid);
        };
        page.removeImg = function (uuid) {
            return adminviewHS.removeImg(uuid);
        };
        return page;
    });