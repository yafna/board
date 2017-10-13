'use strict';

angular.module('myApp', [
    'ngRoute',
    'myApp.teamModifyFactory',
    'myApp.userModifyFactory',
    'myApp.imageModifyFactory',
    'myApp.calendarview',
    'myApp.viewSrv',
    'myApp.viewTableFactory',
    'myApp.adminviewview',
    'myApp.statisticsview',
    'myApp.createteam',
    'myApp.createuser',
    'myApp.allTeamsCalendarview'
])
  .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.otherwise({redirectTo: '/adminview'});
    }]);
