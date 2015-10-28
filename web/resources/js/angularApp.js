var app = angular.module('computerApp', []);
var urlPath = "http://localhost:8080/ManageComputer/api";

app.controller('computerController', function ($scope, $http) {
    $scope.usersSupport = [];
    $http.get(urlPath + '/user-support', {cache: false})
        .success(function (response) {
            $scope.usersSupport = response;
        });
        
    $scope.finalizar = function(userSupport) {
        userSupport.insertedAt = new Date();
        userSupport.status = 2;
        
        $http({
            url: urlPath + '/user-support/' + userSupport.supportId,             
            method: 'PUT',
            data: JSON.stringify(userSupport),
            headers: {'Content-Type':'application/json; charset=utf-8'}           
        }).success(function(status) {
            alert("Chamado finalizado com sucesso!!");
        }).error(function(status) {
            console.log("Vish, erro: " + status);
        });
    };
});

app.controller('formController', function($scope, $http) {    
    $http.get(urlPath + '/computer', {cache: false})
        .success(function (response) {
            $scope.computers = response;
        });
        
    $http.get(urlPath + '/computer-user', {cache: false})
        .success(function (response) {
            $scope.users = response;
        });
        
    $http.get(urlPath + '/user-support/open', {cache: false})
        .success(function (response) {
            $scope.openSupports = response;
        });
    
    $scope.save = function(userSupport) {
        userSupport.insertedAt = new Date();
        userSupport.status = 1;
        
        $http({            
            url: urlPath + '/user-support',             
            method: 'POST',         
            data: JSON.stringify(userSupport),
            headers: {'Content-Type':'application/json; charset=utf-8'}           
        }).success(function(status) {
            $scope.userSupport.computerId = "";
            $scope.userSupport.userId = "";
            $scope.userSupport.description = "";
            
            $http.get(urlPath + '/user-support/open', {cache: false})
                .success(function (response) {
                    $scope.openSupports = response;
                });
            
            alert("Chamado Aberto!! Logo te atendemos.. :)");
        }).error(function(status) {
            console.log("Vish, erro: " + status);
        });
    };
});
