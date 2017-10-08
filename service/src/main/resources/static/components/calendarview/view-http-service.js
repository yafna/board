'use strict';
angular.module('myApp.viewSrv', [])
    //service of factory question may be confusing question
    //read the difference: https://groups.google.com/forum/#!msg/angular/56sdORWEoqg/HuZsOsMvKv4J
    .service('viewHttpFactory', function ($http) {
         // http communication for the page
        return({
            loadUsers: loadUsers,
            loadImgs: loadImgs
        });

        function loadUsers() {
            return $http.get("/users/list");
        }

        function modify () {
            return $http.get("/test/available/vendors");
        }

        function getProducts() {
            return $http.get("/test/available/products");
        }
        function getRecipe(type) {
            return $http.get("/test/available/get/recipe/" + type);
        }
    });