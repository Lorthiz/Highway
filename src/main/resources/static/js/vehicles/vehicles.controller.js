function VehicleController(VehiclesService) {
    var ctrl = this;
    ctrl.vehiclesList = [];

    function getVehicles() {
        VehiclesService.retrieve().then(
            function (response) {
                ctrl.vehiclesList = response;
            }
        )
    }

    ctrl.addVehicle = function () {
        var vehicle = {
            registrationNumber: ctrl.registrationNumber,
            model: ctrl.model,
            productionDate: ctrl.productionDate,
            status:true
        };
        VehiclesService.create(vehicle).then(function (response) {
                getVehicles();
            }
        )
    };


    ctrl.changeStatus = function (index) {
        VehiclesService.changeStatus(ctrl.vehiclesList[index]).then(function (response) {
            ctrl.vehiclesList[index].status = !ctrl.vehiclesList[index].status;
        })
    };

    getVehicles()
}

angular
    .module('vehicles')
    .controller('VehicleController', VehicleController);