

	var app = angular.module("App", []);
	app.controller("Ctrl", function($scope, $http) {
        $scope.action = {};
        loadAction();

		//submit response
		$scope.actionFormSubmit = function () {
            doAjaxCall($scope.action,'json',"http://localhost:8181/api/action/add");
            $scope.action = {};
            loadAction () ;					
		}		
		
		// ============================= load data ===========================================
		//load action 
		function loadAction () {
		    $http.get("http://localhost:8181/api/action/loadAction?limit=10")
		    .then(function(response) {
		    	$scope.actionlist = response.data;
		    });			
		}	

		// =============================== onclick ======================================

		$scope.onClickEditAction = function($id,$action,$intent){
            $scope.action = {};
            $scope.action.actionid = $id;
            $scope.action.action = $action;
            $scope.action.intent = $intent;
        }	
		$scope.onClickDeleteAction = function($id){
			$http({
				method : "GET",
				url : "http://localhost:8181/api/action/delete?id="+$id,
			}).then(function mySuccess(response) {
                if($scope.search){
                    $scope.onChangeactionSearch () ;
                }else loadAction();
			});			
        }				
		//================================ on change ====================================
		
		$scope.onChangeActionSearch = function(){
			$http.get("http://localhost:8181/api/action/getByAction?action="+$scope.search)
			.then(function(response) {
				$scope.actionlist = response.data;
			});			
		}	

	});