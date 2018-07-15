function RidesController(RideService) {
    var ctrl = this;
    ctrl.ridesList = [];

    function getRides() {
        RideService.retrieve().then(
            function (response) {
                ctrl.ridesList = response;
            }
        )
    }

    getRides();
}

angular
    .module('rides')
    .controller('RidesController', RidesController);