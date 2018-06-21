function UserService($http) {

    var API = '/users';

    function create(todo) {
        return $http.post(API, todo).then(function (response) {
                return response.data;
            }
        );
    }

    function retrieve() {
        return $http.get(API).then(function (response) {
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
    .service('UserService', UserService);