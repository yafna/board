'use strict';
angular.module('myApp.allviewSrv', [])
    //service of factory question may be confusing question
    //read the difference: https://groups.google.com/forum/#!msg/angular/56sdORWEoqg/HuZsOsMvKv4J
    .service('allviewHttpFactory', function ($http) {
         // http communication for the page
        return({
            loadTable: loadTable,
            loadTableForTeam: loadTableForTeam,
            dostatus: dostatus
        });

        function loadTable() {
            return $http.get("/calendar/allByTeams");
        }

        function loadTableForTeam(uuid) {
            return $http.get("/calendar/getByTeam/"+uuid);
        }

        function dostatus(userid, dayId, imgid) {
            return $http.get("/calendar/register/" + userid + "/" + dayId + "/" + imgid);
        }

    });