app = angular.module("admin-app", ["ngRoute"]);


app.config(function ($routeProvider){
    $routeProvider
    .when("/accounts", {
        templateUrl: "/assets/admin/accounts/index.html",
        controller: "accounts-ctrl"
    })

    .when("/authorize", {
        templateUrl: "/assets/admin/authority/index.html",
        controller: "authority-ctrl"
    })
    
    .otherwise({
        templateUrl:"/assets/admin/accounts/index.html",
        controller: "accounts-ctrl"
    });
});