function RegisterController(UserService) {
    var ctrl = this;
    ctrl.userList = [];

    function getUsers() {
        UserService.retrieve().then(
            function (response) {
                ctrl.userList = response;
            }
        )
    }

    function clearForm(){
        ctrl.name = "";
        ctrl.username = "";
        ctrl.email = "";
        ctrl.password = "";
    }

    ctrl.save = function () {
        UserService.create({
            name: ctrl.name,
            username: ctrl.username,
            email: ctrl.email,
            password: ctrl.password
        }).then(function (response) {
                getUsers();
                clearForm();
            }
        );
    };

    getUsers();
}

angular
    .module('highway')
    .controller('RegisterController', RegisterController);