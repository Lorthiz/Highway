function AccountController(UserService) {
    var ctrl = this;
    ctrl.currentUser = null;
    ctrl.newPassword = null;

    function getUser() {
        UserService.retrieveCurrentUser().then(
            function (response) {
                ctrl.currentUser = response;
            }
        )
    }

    ctrl.save = function () {
        ctrl.currentUser.password = ctrl.newPassword;
        ctrl.newPassword = null;
        UserService.update(ctrl.currentUser).then(function () {

        })
    };

    getUser();
}

angular
    .module('account')
    .controller('AccountController', AccountController);