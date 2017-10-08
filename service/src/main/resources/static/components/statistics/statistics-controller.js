'use strict';

angular.module('myApp.statisticsview', ['ngRoute', 'ui.bootstrap', 'ui.bootstrap.tpls', 'myApp.spinner'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/statisticsview', {
            templateUrl: 'components/statistics/statistics-view.html',
            controller: 'StatisticsViewCtrl'
        });
    }])
    .controller('StatisticsViewCtrl');