var app = angular.module("MyApp", [ 'ui.router' ]);

app.config(function($stateProvider, $urlRouterProvider) {

	//recherche d'un déplacement
	$stateProvider.state('chercherDeplacement', {
		url : '/chercherDeplacement',
		templateUrl : 'view/chercherDeplacement.html',
		controller : 'chercherDeplacementController'
	});
	//ajout d'un déplacement
	$stateProvider.state('ajouterDeplacement', {
		url : '/ajouterDeplacement',
		templateUrl : 'view/ajouterDeplacement.html',
		controller : 'AjouterDeplacementController'
	});
	//Mise à jour d'un déplacement
	$stateProvider.state('majDeplacement', {
		url : '/majDeplacement',
		params: { 
			'deplacement' : null,
	      },
		templateUrl : 'view/majDeplacement.html',
		controller : 'MajDeplacementController'
	});

});

app.controller("AjouterDeplacementController", function($scope, $http) {
	$scope.deplacement = {};
	$scope.mode=0;
	$scope.saveDeplacement = function() {
		$http.post("http://localhost:8080/ajouterDeplacement",
				$scope.deplacement).then(function(data) {
					$scope.deplacement = data.data;
					$scope.mode=1;
				}, function(data) {
					console.log(data);
				});
	}
});

app.controller("MajDeplacementController", function($scope, $http, $stateParams) {
	
	$scope.deplacement = $stateParams.deplacement;
	console.log("test sha " + $stateParams.deplacement);
	console.log("test sha " + $stateParams.deplacement.id);
	console.log("test sha " + $stateParams.deplacement.client);
	console.log("test sha " + $stateParams.deplacement.dateDeplacement);

});
/*
app.controller("MajDeplacementController", function($scope, $http, $stateParams) {
	
	sessionStorage.setItem("deplacement", JSON.stringify($stateParams.deplacement));
	$scope.deplacement = sessionStorage.getItem('deplacement');
	console.log("test sha " + $scope.deplacement);
	console.log("test sha " + $scope.deplacement.id);
	console.log("test sha " + $scope.deplacement.client);
	console.log("test sha " + $scope.deplacement.dateDeplacement);

});
*/
app.controller("chercherDeplacementController", function($scope, $http) {
	// décalaration des variable
	$scope.pageDeplacement = null;
	$scope.motCle = "";
	$scope.pageCurrent = 0;
	$scope.size = 3;
	$scope.pages = [];
	// chercher un deplacement
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
	
	$scope.deleteDeplacement = function(d) {
		$http.delete("http://localhost:8080/supprimerDeplacement/"+d.id);
		$scope.getDeplacements();
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
