function VehiclesService($http) {

    var API = '/vehicles';

    function create(todo) {
        return $http.post(API, todo).then(function (response) {
                return response.data;
            }
        );
    }

    function retrieve() {
        return $http.get(API, {headers:{'Cache-Control': 'no-cache'}}).then(function (response) {
            console.log(response);
            return response.data;
        });
    }

    function update(todo) {
        return $http.put(API + todo.id).then(function (response) {
            return response.data;
        });
    }

    function changeStatus(todo) {
        return $http.put(API + "/" + todo.id).then(function (response) {
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
        changeStatus: changeStatus,
        update: update,
        remove: remove
    };
}

angular
    .module('highway')
    .service('VehiclesService', VehiclesService);