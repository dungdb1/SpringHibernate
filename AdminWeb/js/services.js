var raServices=angular.module('raServices',['ngResource']);

raServices.factory('StudentsService', ['$resource',

    function($resource){

        return $resource('http://localhost:8080/service/:call', {}, {
            students: {method:'GET',params:{call:'students'},isArray:true},
            student:{method:'GET',params:{call:'student'},isArray:false},
            students_in_class:{method:'GET',params:{call:'students_in_class'},isArray:true},
            all_students:{method:'GET',params:{call:'all_students'},isArray:true}

        });

    }]);
