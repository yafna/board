'use strict';

var appInstalled = angular.module('myApp.createuser', ['ngRoute']);

appInstalled
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
        .when('/modifyUser', {
            templateUrl: 'components/createuser/create-user.html',
            controller: 'CreateUserCtrl'
        })
        .when('/modifyUser/:id', {
             templateUrl: 'components/createuser/create-user.html',
              controller: 'CreateUserCtrl'
         });
    }])
    .controller('CreateUserCtrl', function (userModifyFactory, teamModifyFactory, $routeParams, $location) {
        var self = this;

        self.result = "";
        self.env.loading = true;
        self.editmode = false;
//        self.teams = teamModifyFactory.loadTeams().then(
//             function (resp){
//                self.teams = resp.data;
//             });
//        if($routeParams.id !== undefined){
//            self.editmode = true;
//            self.user = userModifyFactory.getUser($routeParams.id).then(
//                function (resp){
//                     self.user = resp.data;
//            })
//        }
        self.loadUserData = function (spinnerService) {
            spinnerService.show('user-loading');
            if($routeParams.id !== undefined){
                 self.editmode = true;
                 userModifyFactory.getUser($routeParams.id).then(
                   function (resp2){
                       self.user = resp.data2;
                       self.env.loading = false;
                  })
             }else{
                 self.env.loading = false;
                 spinnerService.hide('user-loading');
             }
            teamModifyFactory.loadTeams().then(
                 function (resp) {
                     self.teams = resp.data;
                     spinnerService.hide('user-loading');
                 }
            );

        }

        self.send = function () {
            userModifyFactory.saveUser(self.user.uuid, self.user.name, self.user.teamUuid)
                .success(function (data, status, headers, config) {
                    self.result = data;
                    $location.path( "/adminview" );
                })
                .error(function (data, status, headers, config) {
                    self.result = "failure message: " + JSON.stringify({data: data});
                });
        };
    });