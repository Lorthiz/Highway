var home = {
    template: "<p>THIS IS HOME</p>"
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