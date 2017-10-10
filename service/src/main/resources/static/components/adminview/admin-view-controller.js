'use strict';

angular.module('myApp.adminviewview', ['ngRoute', 'ui.bootstrap', 'ui.bootstrap.tpls', 'myApp.spinner'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/adminview', {
            templateUrl: 'components/adminview/admin-view.html',
            controller: 'AdminViewCtrl'
        });
    }])
    .controller('AdminViewCtrl', function (imageModifyFactory, teamModifyFactory,userModifyFactory) {
            var self = this;

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
                         teamModifyFactory.loadUsers().then(
                             function (resp){
                                 self.users = resp.data;
                         })
                     })
            };
             self.removeImage = function (uuid) {
                imageModifyFactory.removeImg(uuid).then(
                    function (resp2){
                         teamModifyFactory.loadImgs().then(
                             function (resp){
                                 self.images = resp.data;
                         })
                     })
            };
            self.teams = [];
            self.users = [];
            self.images = [];
            self.preLoad = function () {
               teamModifyFactory.loadTeams().then(
                   function (resp){
                       self.teams = resp.data;
                   })
                imageModifyFactory.loadImgs().then(
                   function (resp){
                       self.images = resp.data;
                   })
                userModifyFactory.loadUsers().then(
                   function (resp){
                       self.users = resp.data;
                   })
            };
    })