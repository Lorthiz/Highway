var account = {
    templateUrl: 'views/account.html',
    restrict: 'E',
    controller: 'AccountController as $ctrl'
};

angular
    .module('account')
    .component('account', account)
    .config(function ($stateProvider) {
        $stateProvider
            .state('account', {
                    url: '/account',
                    component: 'account'
                }
            )
    });