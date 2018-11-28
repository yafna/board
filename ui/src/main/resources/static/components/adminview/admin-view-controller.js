'use strict';

angular.module('myApp.adminviewview', ['ngRoute', 'ui.bootstrap', 'ui.bootstrap.tpls', 'myApp.spinner'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/adminview', {
            templateUrl: 'components/adminview/admin-view.html',
            controller: 'AdminViewCtrl'
        });
    }])
    .controller('AdminViewCtrl', function (imageModifyFactory, teamModifyFactory, userModifyFactory, settingsModifyFactory) {
            var self = this;
            self.editAll = false;
            self.loadSettings = function (spinnerService) {
                spinnerService.show('settings-loading');
                settingsModifyFactory.get().then(
                    function (resp) {
                          spinnerService.hide('settings-loading');
                          self.settings = resp.data;
                     }
                 );
             };
            self.switchEditable = function () {
                settingsModifyFactory.switchEditable().then(
                    function (resp2) {
                        settingsModifyFactory.get().then(
                            function (resp) {
                                 spinnerService.hide('settings-loading');
                                 self.settings = resp.data;
                             }
                         );
                     }
                 );
             };
            self.removeTeam = function (uuid) {
                teamModifyFactory.removeTeam(uuid)
                .then(
                    function (resp2){
                         teamModifyFactory.loadTeams().then(
                             function (resp){
                                 self.teams = resp.data;
                         })
                     })
            };
            self.removeUser = function (uuid) {
                userModifyFactory.removeUser(uuid).then(
                    function (resp2){
                         userModifyFactory.loadUsers().then(
                             function (resp){
                                 self.users = resp.data;
                         })
                     })
            };
            self.enableImg = function (uuid) {
                imageModifyFactory.enable(uuid).then(
                 function (resp2){
                      teamModifyFactory.loadImgs().then(
                         function (resp){
                             self.images = resp.data;
                      })
                 })
            };
//            self.removeImage = function (uuid) {
//                imageModifyFactory.removeImg(uuid).then(
//                    function (resp2){
//                         teamModifyFactory.loadImgs().then(
//                             function (resp){
//                                 self.images = resp.data;
//                         })
//                     })
//            };
            self.loadImgTable = function (spinnerService) {
                spinnerService.show('img-table-loading');
                imageModifyFactory.loadImgs().then(
                    function (resp) {
                          spinnerService.hide('img-table-loading');
                          self.images = resp.data;
                     }
                 );
             };
            self.loadTeamTable = function (spinnerService) {
                spinnerService.show('team-table-loading');
                teamModifyFactory.loadTeams().then(
                    function (resp) {
                          spinnerService.hide('team-table-loading');
                          self.teams = resp.data;
                     }
                 );
             };
            self.loadUserTable = function (spinnerService) {
                spinnerService.show('user-table-loading');
                userModifyFactory.loadUsers().then(
                    function (resp) {
                          spinnerService.hide('user-table-loading');
                          self.users = resp.data;
                     }
                 );
             };
    })