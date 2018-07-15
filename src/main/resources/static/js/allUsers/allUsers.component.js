var register = {
    templateUrl: 'views/allUsersForm.html',
    restrict: 'E',
    controller: 'AllUsersController as $ctrl'
};

angular
    .module('allUsers')
    .component('allUsers', register)
    .config(function ($stateProvider) {
        $stateProvider
            .state('allUsers', {
                    url: '/allUsers',
                    component: 'allUsers'
                }
            )
    });