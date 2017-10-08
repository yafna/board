'use strict';

angular.module('myApp.adminviewview', ['ngRoute', 'ui.bootstrap', 'ui.bootstrap.tpls', 'myApp.spinner'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/adminview', {
            templateUrl: 'components/adminview/admin-view.html',
            controller: 'AdminViewCtrl'
        });
    }])
    .controller('AdminViewCtrl', ['adminviewMF', function (adminviewMF) {
            var self = this;

            self.removeTeam = function (uuid) {
                adminviewMF.removeTeam(uuid);
            };
//             self.teams = adminviewMF.loadTeams();


            self.removeUser = function (uuid) {
                adminviewMF.removeUser(uuid);
            };
            self.users =  adminviewMF.loadUsers();

            self.preLoad = function () {
                self.teams = adminviewMF.loadTeams();
            };
    }])