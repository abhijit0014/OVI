

	var app = angular.module("App", []);
	app.controller("Ctrl", function($scope, $http) {
		var QueryEdit_flag, ResponseEdit_flag = false;
        $scope.currentQuery = '';
        $scope.currentQueryId = 0;
		$scope.query = {};
		$scope.response = {};
		$scope.map = {};
		loadQuery();

		//submit query
		$scope.queryFormSubmit = function () {
			doAjaxCall($scope.query,"json","http://localhost:8181/api/query/add");
			QueryEdit_flag = false;	
			$scope.onChangeQuery();	
			$scope.query = {};		
		}
		//submit response
		$scope.responseFormSubmit = function () {
			doAjaxCall($scope.response,'json',"http://localhost:8181/api/response/add");	
			ResponseEdit_flag = false;		
			$scope.onChangeResponse () ;
			$scope.response = {};			
		}		
		
		// ============================= load data ===========================================
		//load query 
		function loadQuery () {
		    $http.get("http://localhost:8181/api/query/loadQuery?limit=10")
		    .then(function(response) {
		    	$scope.querylist = response.data;
		    });			
		}

		//load query 
		function loadResponse () {
		    $http.get("http://localhost:8181/admin/loadResponse")
		    .then(function(response) {
		    	$scope.responselist = response.data;
		    });			
        }
        // load map
        function loadMap(){
		    $http.get("http://localhost:8181/api/QueryResponseMap/getByQueryid?id="+$scope.currentQueryId)
		    .then(function(response) {
		    	$scope.mapResponselist = response.data;
		    });	            
        }		

		// =============================== onclick ======================================
		$scope.onClickQueryEdit = function($id,$query){
			QueryEdit_flag = true;
			$scope.query.queryid = $id;
			actionStr=$scope.query.query;	
			$scope.query.query = $query;
        }
		$scope.onClickResponseEdit = function($id,$response){
			ResponseEdit_flag = true;
			$scope.response.responseid = $id;
			actionStr=$scope.response.response;			
			$scope.response.response = $response;
        }
		$scope.onClickMapQuery = function($id,$query){
            $scope.currentQueryId = $id;
			$scope.currentQuery = $query;
			$scope.responselist = {};
            loadMap();
        }
        $scope.onClickMapResponseRemove = function($id){
			$http({
				method : "GET",
				url : "http://localhost:8181/api/QueryResponseMap/removeResponse?qid="+$scope.currentQueryId+"&rid="+$id,
			}).then(function mySuccess(response) {
				loadMap();	
			});	
        }              
        $scope.onClickMapResponse = function(id){
			$scope.map.responseid = id;
			$scope.map.queryid = $scope.currentQueryId;
			doAjaxCall($scope.map,'json',"http://localhost:8181/api/QueryResponseMap/add");	
			loadMap();	
        }                
		$scope.onClickQueryDelete = function($id){
			$http({
				method : "GET",
				url : "http://localhost:8181/api/query/delete?id="+$id,
			}).then(function mySuccess(response) {
				$scope.onChangeQuery();	
			});			
		}		
		$scope.onClickResponseDelete = function($id){
			$http({
				method : "GET",
				url : "http://localhost:8181/api/response/delete?id="+$id,
			}).then(function mySuccess(response) {
				$scope.onChangeResponse () ;
			});			
        }				
		//================================ on change ====================================
		
		$scope.onChangeQuery = function(){
			if(!QueryEdit_flag){
				$http.get("http://localhost:8181/api/query/getByQuery?q="+$scope.query.query)
				.then(function(response) {
					$scope.querylist = response.data;
				});	
			}			
		}
		
		$scope.onChangeResponse = function(){
			if(!ResponseEdit_flag){
				$http.get("http://localhost:8181/api/response/getByResponse?q="+$scope.response.response)
				.then(function(response) {
					$scope.responselist = response.data;
					loadMap();
				});	
			}
		}

		//================================= http function ===================================
		function httpPost(data,url){
			$http({
				method : "POST",
				url : url,
				data: data,
			}).then(function mySuccess(response) {
				console.log(response.data);
				return true;
			}, function myError(response) {
				console.log(response.statusText);
				return false;
			});
		}	

	});