var rides = {
    templateUrl: 'views/rides.html',
    restrict: 'E',
    controller: 'RidesController as $ctrl'
};

angular
    .module('rides')
    .component('rides', rides)
    .config(function ($stateProvider) {
        $stateProvider
            .state('rides', {
                    url: '/rides',
                    component: 'rides'
                }
            )
    });