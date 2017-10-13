'use strict';

angular.module('myApp.allTeamsCalendarview', ['ngRoute', 'ui.bootstrap', 'ui.bootstrap.tpls', 'myApp.spinner'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/allteams-calendarview', {
            templateUrl: 'components/allteams-calendarview/view.html',
            controller: 'AllTeamsCtrl'
        });
    }])
    .controller('AllTeamsCtrl', ['viewModelFactory', function (viewModelFactory) {
            var self = this;
            self.teamsLoaded = false;
            self.loadAllTeams = function (spinnerService) {
                spinnerService.show('all-teams-list-loading');
                teamModifyFactory.loadTeams().then(
                    function (resp) {
                          spinnerService.hide('all-teams-list-loading');
                          self.teams = resp.data;
                          self.teamsLoaded = true;
                     }
                 );
             };

             self.loadTeam= function (uuid,spinnerService) {
                  spinnerService.show('teams-loading-'+ uuid);
                  teamModifyFactory.loadTeams().then(
                          function (resp) {
                            spinnerService.hide('teams-loading-'+ uuid);
                            self.teams = resp.data;
                            self.teamsLoaded = true;
                      }
                 );
             }



            self.dostatus = function(imgid, userid,day){
                 viewModelFactory.dostatus(userid,day,imgid).then(
                     function (resp2){
                         viewModelFactory.loadTable().then(
                             function (resp){
                                self.paintable = resp.data;
                             })
                         })
                     }
    }])