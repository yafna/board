'use strict';

angular.module('myApp.calendarview', ['ngRoute', 'ui.bootstrap', 'ui.bootstrap.tpls', 'myApp.spinner'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/calendarview', {
            templateUrl: 'components/calendarview/view.html',
            controller: 'CalendarViewCtrl'
        });
    }])
    .controller('CalendarViewCtrl', ['viewModelFactory', function (viewModelFactory) {
            var self = this;

            self.dostatus = function(imgid, userid,day){
                 viewModelFactory.dostatus(userid,day,imgid).then(
                     function (resp2){
                         viewModelFactory.loadTable().then(
                             function (resp){
                                self.paintable = resp.data;
                             })
                         })
                     }
            self.preLoad = function () {
                viewModelFactory.loadTable().then(
                function (resp) {
                    self.paintable = resp.data;
                    }
                );
            };
    }])