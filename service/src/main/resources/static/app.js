'use strict';

angular.module('myApp', [
    'ngRoute',
    'myApp.calendarview',
    'myApp.adminviewview',
    'myApp.statisticsview',
    'myApp.createteam',
    'myApp.teamModifyFactory',
    'myApp.userFactory',
    'myApp.userModifyFactory'
])
  .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.otherwise({redirectTo: '/adminviewview'});
    }]);
