'use strict';

angular.module('myApp', [
    'ngRoute',
    'myApp.teamModifyFactory',
    'myApp.userModifyFactory',
    'myApp.imageModifyFactory',
    'myApp.settingsModifyFactory',
    'myApp.calendarview',
    'myApp.viewSrv',
    'myApp.viewTableFactory',
    'myApp.adminviewview',
    'myApp.statisticsview',
    'myApp.createteam',
    'myApp.createuser',
    'myApp.createimg',
    'myApp.allTeamsCalendarview',
    'myApp.allviewSrv',
    'myApp.dummyviewview',
    'myApp.allviewTableFactory'

])
  .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.otherwise({redirectTo: '/dummypage'});
    }]);
