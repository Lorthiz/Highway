var home = {
    templateUrl: 'views/home.html'
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