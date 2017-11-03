var app = angular.module("MyApp", [ 'ui.router' ]);

app.config(function($stateProvider, $urlRouterProvider) {
	$stateProvider.state('home', {
		url : '/',
		templateUrl : 'view/chercherDeplacement.html',
		controller : 'chercherDeplacementController'
	});
	$stateProvider.state('chercherDeplacement', {
		url : '/chercherDeplacement',
		templateUrl : 'view/chercherDeplacement.html',
		controller : 'chercherDeplacementController'
	});
	$stateProvider.state('ajouterDeplacement', {
		url : '/ajouterDeplacement',
		templateUrl : 'view/ajouterDeplacement.html',
		controller : 'AjouterDeplacementController'
	});
	
});

app.controller("AjouterDeplacementController", function($scope, $http) {

});

app.controller("HomeController", function($scope, $http) {

});

app.controller("chercherDeplacementController", function($scope, $http) {
	// décalaration des variable
	$scope.pageDeplacement = null;
	$scope.motCle = "";
	$scope.pageCurrent = 0;
	$scope.size = 3;
	$scope.pages = [];
	// déclaration des fonctions
	$scope.chercherDeplacement = function() {
		if ($scope.motCle == "*") {
			$scope.motCle = "";
		}
		$http.get(
				"http://localhost:8080/chercherDeplacement?mc=" + $scope.motCle
						+ "&page=" + $scope.pageCurrent + "&size="
						+ $scope.size).then(function(data) {
			$scope.pageDeplacement = data.data;
			$scope.pages = new Array(data.data.totalPages)
		}, function(data) {
			console.log(data);
		});
	}
	$scope.getDeplacements = function() {
		$scope.pageCurrent = 0;
		$scope.chercherDeplacement();
	}

	$scope.gotoPage = function(p) {
		$scope.pageCurrent = p;
		$scope.chercherDeplacement();
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