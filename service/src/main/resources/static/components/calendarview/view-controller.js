'use strict';

angular.module('myApp.calendarview', ['ngRoute', 'ui.bootstrap', 'ui.bootstrap.tpls', 'myApp.spinner'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/calendarview', {
            templateUrl: 'components/calendarview/view.html',
            controller: 'CalendarViewCtrl'
        });
    }])
    .controller('CalendarViewCtrl');