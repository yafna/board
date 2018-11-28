'use strict';
angular.module('myApp.dirTeamCalendar', [])

    .directive('spinner', function () {
        return {
            restrict: 'E',
            templateUrl: 'template.html',
            replace: true,
            scope: {
                id: '@',
                teamUuid: '=teamUuid'
            },
            controller: function ($scope, $attrs, viewModelFactory) {
                viewModelFactory.loadTable();
                $scope.onRegisterComplete({ $spinnerService: spinnerService });
            }
        };
  }