var app = angular.module("MyApp", [ 'ui.router' ]);

app.config(function($stateProvider, $urlRouterProvider) {
	$stateProvider.state('home', {
		url : '/home',
		templateUrl : 'view/home.html',
		controller : 'HomeController'
	});
	$stateProvider.state('chercherProduit', {
		url : '/chercherProduit',
		templateUrl : 'view/chercherProduit.html',
		controller : 'ChercherProduitController'
	});
	$stateProvider.state('ajouterProduit', {
		url : '/ajouterProduit',
		templateUrl : 'view/ajouterProduit.html',
		controller : 'AjouterProduitController'
	});
	
});

app.controller("AjouterProduitController", function($scope, $http) {

});

app.controller("HomeController", function($scope, $http) {

});

app.controller("ChercherProduitController", function($scope, $http) {
	// décalaration des variable
	$scope.pageProduit = null;
	$scope.motCle = "";
	$scope.pageCurrent = 0;
	$scope.size = 3;
	$scope.pages = [];
	// déclaration des fonctions
	$scope.chercherProduit = function() {
		if ($scope.motCle == "*") {
			$scope.motCle = "";
		}
		$http.get(
				"http://localhost:8080/chercherProduit?mc=" + $scope.motCle
						+ "&page=" + $scope.pageCurrent + "&size="
						+ $scope.size).then(function(data) {
			$scope.pageProduit = data.data;
			$scope.pages = new Array(data.data.totalPages)
		}, function(data) {
			console.log(data);
		});
	}
	$scope.getProduits = function() {
		$scope.pageCurrent = 0;
		$scope.chercherProduit();
	}

	$scope.gotoPage = function(p) {
		$scope.pageCurrent = p;
		$scope.chercherProduit();
	}

});
app.directive('ngEnter', function() {
	return function(scope, element, attrs) {
		element.bind("keydown keypress", function(event) {
			if (event.which === 13) {
				scope.$apply(function() {
					scope.$eval(attrs.ngEnter, {
						'event' : event
					});
				});

				event.preventDefault();
			}
		});
	};
});