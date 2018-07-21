var allUsers = {
    templateUrl: 'views/allUsersForm.html',
    restrict: 'E',
    controller: 'AllUsersController as $ctrl'
};

angular
    .module('allUsers')
    .component('allUsers', allUsers)
    .config(function ($stateProvider) {
        $stateProvider
            .state('allUsers', {
                    url: '/allUsers',
                    component: 'allUsers'
                }
            )
    });