var raControllers = angular.module('raControllers', []);

raControllers.controller('StudentsListController', ['$scope','StudentsService',function($scope,StudentsService)
{
    $scope.students=StudentsService.students();
}]);

raControllers.controller('StudentDetailsController', ['$scope', '$routeParams','StudentsService',
    function($scope, $routeParams,StudentsService) {
        $scope.student = StudentsService.student({id: $routeParams.studentid});
    }]);

raControllers.controller('StudentInClassController', ['$scope', '$routeParams','StudentsService',
    function($scope, $routeParams,StudentsService) {
        $scope.students_in_class = StudentsService.students_in_class({ClassId: 1});
    }]);

raControllers.controller('ClassController', ['$scope', '$routeParams','StudentsService',
    function($scope, $routeParams,StudentsService) {
        $scope.all_students = StudentsService.all_students();
    }]);

raControllers.controller('AngularWayChangeDataCtrl', AngularWayChangeDataCtrl);

function AngularWayChangeDataCtrl($resource, DTOptionsBuilder, DTColumnDefBuilder) {
    var vm = this;
    vm.persons = $resource('data1.json').query();
    vm.dtOptions = DTOptionsBuilder.newOptions().withPaginationType('full_numbers');
    vm.dtColumnDefs = [
        DTColumnDefBuilder.newColumnDef(0),
        DTColumnDefBuilder.newColumnDef(1),
        DTColumnDefBuilder.newColumnDef(2),
        DTColumnDefBuilder.newColumnDef(3).notSortable()
    ];
    vm.person2Add = _buildPerson2Add(1);
    vm.addPerson = addPerson;
    vm.modifyPerson = modifyPerson;
    vm.removePerson = removePerson;

    function _buildPerson2Add(id) {
        return {
            id: id,
            firstName: 'Foo' + id,
            lastName: 'Bar' + id
        };
    }
    function addPerson() {
        vm.persons.push(angular.copy(vm.person2Add));
        vm.person2Add = _buildPerson2Add(vm.person2Add.id + 1);
    }
    function modifyPerson(index) {
        vm.persons.splice(index, 1, angular.copy(vm.person2Add));
        vm.person2Add = _buildPerson2Add(vm.person2Add.id + 1);
    }
    function removePerson(index) {
        vm.persons.splice(index, 1);
    }
}