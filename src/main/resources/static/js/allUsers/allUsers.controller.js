function AllUsersController(UserService, $http) {
    var ctrl = this;
    ctrl.userList = [];

    function getUsers() {
        UserService.retrieve().then(
            function (response) {
                ctrl.userList = response;
            }
        )
    }

    ctrl.promote = function (id, role) {
        $http.put("/setPermissionsFor" + "/" + id + "/" + role).then(function () {
            getUsers();
        })
    };

    getUsers();
}

angular
    .module('allUsers')
    .controller('AllUsersController', AllUsersController);