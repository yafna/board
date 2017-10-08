'use strict';
angular.module('myApp.viewSrv', [])
    //service of factory question may be confusing question
    //read the difference: https://groups.google.com/forum/#!msg/angular/56sdORWEoqg/HuZsOsMvKv4J
    .service('viewHttpFactory', function ($http) {
         // http communication for the page
        return({
            loadTable: loadTable,
            dostatus: dostatus
        });

        function loadTable() {
            return $http.get("/calendar/all");
        }

        function dostatus(userid, dayId, imgid) {
            return $http.get("/calendar/register/" + userid + "/" + dayId + "/" + imgid);
        }

    });