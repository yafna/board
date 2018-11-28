'use strict';
angular.module('myApp.spinner', [])
    .factory('spinnerService', function () {
        var cache = {};
        return {
            _register: function (spinnerScope) {
                if (!spinnerScope.id) {
                    throw new Error("A spinner must have an ID to register with the spinner service.");
                }
                cache[spinnerScope.id] = spinnerScope;
            },
            _unregister: function (spinnerId) {
                delete cache[spinnerId];
            },

            show: function (spinnerId) {
                if (cache.hasOwnProperty(spinnerId)) {
                    var spinnerScope = cache[spinnerId];
                    spinnerScope.showSpinner = true;
                }
            },
            hide: function (spinnerId) {
                if (cache.hasOwnProperty(spinnerId)) {
                    var spinnerScope = cache[spinnerId];
                    spinnerScope.showSpinner = false;
                }
            }
        };
    })

    .directive('spinner', function () {
        return {
            restrict: 'E',
            template: [
                '<span>',
                '  <img ng-show="showSpinner" ng-src="/components/spinner/spinner.gif" style="padding-right: 7px; width: {{ spinnerSize }}; vertical-align: middle" />',
                '</span>'
            ].join(''),
            replace: true,
            scope: {
                id: '@',
                showSpinner: '@?',
                onRegisterComplete: '&?'
            },
            controller: function ($scope, $attrs, spinnerService) {
                spinnerService._register($scope);
                $scope.onRegisterComplete({ $spinnerService: spinnerService });
            },
            link: function (scope, elem, attrs) {
                if (attrs.hasOwnProperty('size')) {
                    attrs.size = attrs.size.toLowerCase();
                }
                switch (attrs.size) {
                    case 'tiny':
                        scope.spinnerSize = '15px';
                        break;
                    case 'small':
                        scope.spinnerSize = '25px';
                        break;
                    case 'medium':
                        scope.spinnerSize = '35px';
                        break;
                    case 'large':
                        scope.spinnerSize = '75px';
                        break;
                    default:
                        scope.spinnerSize = '50px';
                        break;
                }
            }
        };
    });
