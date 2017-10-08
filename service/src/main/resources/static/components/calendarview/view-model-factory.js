'use strict';
angular.module('myApp.viewTableFactory', [])
    .factory('viewModelFactory', function (viewHttpFactory, $modal) {
        var page = {};

        page.loadUsers = function () {
            return viewHttpFactory.loadUsers();
        };

        page.loadImgs = function () {
            return viewHttpFactory.loadImgs();
        };
        return page;
    });