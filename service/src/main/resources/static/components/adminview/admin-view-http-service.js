'use strict';
angular.module('myApp.adminviewSrv', [])
    .service('adminviewHS', function ($http) {
        return({
            loadUsers: loadUsers,
            loadImgs: loadImgs,
            loadTeams: loadTeams,
            removeTeam: removeTeam,
            removeUser: removeUser,
            removeImg: removeImg
        });

        function loadUsers() {
            return $http.get("/users/list");
        }
        function loadTeams() {
            return $http.get("/team/list");
        }
        function loadImgs() {
            return $http.get("/imgs/list");
        }

        function removeTeam(uuid) {
            return $http.get("/team/remove/" + uuid);
        }
        function removeUser(uuid) {
            return $http.get("/users/remove/" + uuid);
        }
        function removeImg(uuid) {
            return $http.get("/img/remove/" + uuid);
        }
    });