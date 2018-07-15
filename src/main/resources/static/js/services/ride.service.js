function RideService($http) {

    var API = '/rides';

    function create(todo) {
        return $http.post(API, todo).then(function (response) {
                return response.data;
            }
        );
    }

    function retrieve() {
        return $http.get(API, {headers: {'Cache-Control': 'no-cache'}}).then(function (response) {
            return response.data;
        });
    }

    function update(todo) {
        return $http.put(API + todo.id).then(function (response) {
            return response.data;
        });
    }

    function remove(todo) {
        return $http.delete(API + todo.id).then(function (response) {
            return response.data;
        });
    }

    return {
        create: create,
        retrieve: retrieve,
        update: update,
        remove: remove
    };
}

angular
    .module('highway')
    .service('RideService', RideService);