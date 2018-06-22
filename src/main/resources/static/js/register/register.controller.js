function RegisterController(UserService) {
    var ctrl = this;
    ctrl.userList = [];
    ctrl.name = "123";
    ctrl.username = "123";
    ctrl.email = "123@wp.pl";
    ctrl.password = "123";

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