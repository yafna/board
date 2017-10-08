'use strict';

angular.module('myApp', [
    'ngRoute',
    'myApp.calendarview',
    'myApp.viewSrv',
    'myApp.viewTableFactory',
    'myApp.adminviewview',
    'myApp.adminviewMF',
    'myApp.adminviewSrv',
    'myApp.statisticsview',
    'myApp.createteam',
    'myApp.teamModifyFactory',
    'myApp.createuser',
    'myApp.userModifyFactory'
])
  .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.otherwise({redirectTo: '/calendarview'});
    }]);
