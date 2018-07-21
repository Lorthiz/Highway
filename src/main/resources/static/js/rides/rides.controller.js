function RidesController(RideService) {
    var ctrl = this;
    ctrl.ridesList = [];
    ctrl.conf = {
        instructors: [],
        vehicles: []
    };
    ctrl.ride = {
        instructor: null,
        vehicle: null,
        startTime: fetchDate(),
        length: 60
    };

    function getRides() {
        RideService.retrieve().then(
            function (response) {
                ctrl.ridesList = response;
            }
        )
    }

    function getConf() {
        RideService.retrieveConf().then(
            function (response) {
                ctrl.conf = response;
            }
        )
    }

    ctrl.submit = function () {
        RideService.create(ctrl.ride).then(function (response) {
            ctrl.ride = {
                instructor: null,
                vehicle: null,
                startTime: fetchDate(),
                length: 60
            };
            getRides();
        })
    };

    ctrl.cancel = function (index) {
        RideService.remove(ctrl.ridesList[index]).then(function (response) {
            getRides();
        })
    };


    function fetchDate() {
        var date = new Date();
        date.setMilliseconds(0);
        date.setSeconds(0);
        return date;
    }

    getConf();
    getRides();
}

angular
    .module('rides')
    .controller('RidesController', RidesController);