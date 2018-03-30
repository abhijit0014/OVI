

	var app = angular.module("App", []);
	app.controller("Ctrl", function($scope, $http) {
        $scope.template = {};
        loadTemplate();

		//submit response
		$scope.templateFormSubmit = function () {
            doAjaxCall($scope.template,'json',"http://localhost:8181/api/template/add");
            $scope.template = {};
            loadTemplate () ;					
		}		
		
		// ============================= load data ===========================================
		//load template 
		function loadTemplate () {
		    $http.get("http://localhost:8181/api/template/loadTemplate?limit=10")
		    .then(function(response) {
		    	$scope.templatelist = response.data;
		    });			
		}	

		// =============================== onclick ======================================

		$scope.onClickEditTemplate = function($id,$template,$intent){
            $scope.template = {};
            $scope.template.templateid = $id;
            $scope.template.template = $template;
            $scope.template.intent = $intent;
        }	
		$scope.onClickDeleteTemplate = function($id){
			$http({
				method : "GET",
				url : "http://localhost:8181/api/template/delete?id="+$id,
			}).then(function mySuccess(response) {
                if($scope.search){
                    $scope.onChangeTemplateSearch () ;
                }else loadTemplate();
			});			
        }				
		//================================ on change ====================================
		
		$scope.onChangeTemplateSearch = function(){
			$http.get("http://localhost:8181/api/template/getBytemplate?template="+$scope.search)
			.then(function(response) {
				$scope.templatelist = response.data;
			});			
		}	

	});