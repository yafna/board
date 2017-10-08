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
            self.loadTeamsTable = function (spinnerService) {
                spinnerService.show('team-table-loading');
                adminviewMF.loadTeamsTable().then(
                    function (resp) {
                        spinnerService.hide('team-table-loading');
                        self.teams = resp.data;
                    }
                );
            };

            self.removeUser = function (uuid) {
                adminviewMF.removeUser(uuid);
            };
            self.loadUsersTable = function (spinnerService) {
                spinnerService.show('user-table-loading');
                adminviewMF.loadUsersTable().then(
                    function (resp) {
                        spinnerService.hide('user-table-loading');
                        self.users = resp.data;
                    }
                );
            };
    }