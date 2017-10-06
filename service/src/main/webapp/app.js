'use strict';

angular.module('myApp', [
    'ngRoute',
    'myApp.calendarview'
])
  .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.otherwise({redirectTo: '/calendarview'});
    }]);
