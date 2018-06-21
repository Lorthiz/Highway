var register = {
    templateUrl: 'views/registerForm.html',
    restrict: 'E',
    controller: 'RegisterController as $ctrl'
};

angular
    .module('register')
    .component('register', register)
    .config(function ($stateProvider) {
        $stateProvider
            .state('register', {
                    url: '/register',
                    component: 'register'
                }
            )
    });