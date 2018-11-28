'use strict';

angular.module('myApp.allTeamsCalendarview', ['ngRoute', 'ui.bootstrap', 'ui.bootstrap.tpls', 'myApp.spinner'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
        .when('/allTeamsCalendarview', {
            templateUrl: 'components/allteams-calendarview/view.html',
            controller: 'AllTeamsCtrl'
        })
        .when('/teamview/:id', {
                    templateUrl: 'components/allteams-calendarview/view.html',
                    controller: 'AllTeamsCtrl'
        });
    }])
    .controller('AllTeamsCtrl', function (allviewModelFactory, $routeParams, $location) {
        var self = this;
        self.loaded = false;
        if($routeParams.id !== undefined){
            allviewModelFactory.loadTableForTeam($routeParams.id).then(
                function (resp) {
                    self.paintable = resp.data;
                    spinnerService.hide('allteam-loading');
                    self.loaded = true;
                }
            );
        }else{
            allviewModelFactory.loadTable().then(
            function (resp) {
                self.paintable = resp.data;
                spinnerService.hide('allteam-loading');
                self.loaded = true;
                }
            );
        }
        self.dostatus = function(imgid, userid,day){
                allviewModelFactory.dostatus(userid,day,imgid).then(
                     function (resp2){
                        if($routeParams.id !== undefined){
                                allviewModelFactory.loadTableForTeam($routeParams.id).then(
                                    function (resp) {
                                        self.paintable = resp.data;
                                        spinnerService.hide('allteam-loading');
                                        self.loaded = true;
                                    }
                                );
                            }else{
                                allviewModelFactory.loadTable().then(
                                function (resp) {
                                    self.paintable = resp.data;
                                    spinnerService.hide('allteam-loading');
                                    self.loaded = true;
                                    }
                                );
                    }
                })
          }
     });