/**
 * Created by dungdb1 on 14/12/2015.
 */
var restAngular = angular.module('restAngular',['ngRoute','raControllers','raServices']);

restAngular.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/students', {
                templateUrl: 'template/student-view-list.html',
                controller: 'StudentsListController'
            }).
            when('/student/:studentid', {
                templateUrl: 'template/student-details.html',
                controller: 'StudentDetailsController'
            }).
            when('/chucnangx', {
                templateUrl: 'template/chucnangx.html',
                controller: 'StudentDetailsController'
            }).
            otherwise({
                redirectTo: '/students'
            });

    }]);

