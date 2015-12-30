/**
 * Created by dungdb1 on 14/12/2015.
 */
var restAngular = angular.module('restAngular',['ngRoute','raControllers','raServices']);

restAngular.config(['$routeProvider',

    function($routeProvider) {
        $routeProvider.
            when('/students', {
                templateUrl: 'student-list.html',
                controller: 'StudentsListController'
                //ctrl: 'StudentsListController'
            }).

            when('/student/:studentid', {
                templateUrl: '../student-details.html',
                controller: 'StudentDetailsController'
            }).
            otherwise({
                redirectTo: '/students'
            });

    }]);