/**
 * Created by dungdb1 on 14/12/2015.
 */
var restAngular = angular.module('restAngular',['ngRoute','raControllers','raServices','datatables']);



restAngular.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/QuanTriHeThong', {
                templateUrl: 'template/student-view-list.html',
                controller: 'StudentsListController'
            }).
            when('/students', {
                templateUrl: 'template/student-view-list.html',
                controller: 'StudentsListController'
            }).
            when('/student/:studentid', {
                templateUrl: 'template/student-details.html',
                controller: 'StudentDetailsController'
            }).
            when('/chucnangx', {
                templateUrl: 'template/datatable.html',
                controller: 'StudentInClassController'
            }).
            when('/chucnangy1', {
                templateUrl: 'template/class.html',
                controller: 'ClassController'
            }).
            otherwise({
                redirectTo: '/students'
            });

    }]);

