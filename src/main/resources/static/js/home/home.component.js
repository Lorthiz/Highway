var home = {
    template: "Start:<input type=\"datetime-local\"/>"
};

angular
    .module('home')
    .component('home', home)
    .config(function ($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('home', {
                url: '/',
                component: 'home'
            });
        $urlRouterProvider.otherwise('/');
    });