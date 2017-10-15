'use strict';

angular.module('myApp.dummyviewview', ['ngRoute', 'ui.bootstrap', 'ui.bootstrap.tpls', 'myApp.spinner'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/dummypage', {
            templateUrl: 'components/dummypage/dummy-view.html',
            controller: 'DummyViewCtrl'
        });
    }])
    .controller('DummyViewCtrl', function (userModifyFactory) {
            var self = this;
            self.preLoad = function(){
             userModifyFactory.preloadData().then(
                 function (resp) {
                    }
                );
            }
    });