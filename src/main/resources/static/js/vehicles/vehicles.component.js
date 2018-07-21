var vehicles = {
    templateUrl: 'views/vehicles.html',
    restrict: 'E',
    controller: 'VehicleController as $ctrl'
};

angular
    .module('vehicles')
    .component('vehicles', vehicles)
    .config(function ($stateProvider) {
        $stateProvider
            .state('vehicles', {
                    url: '/vehicles',
                    component: 'vehicles'
                }
            )
    });