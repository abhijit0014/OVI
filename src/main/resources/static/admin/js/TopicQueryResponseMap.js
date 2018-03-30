

	var app = angular.module("App", []);
	app.controller("Ctrl", function($scope, $http) {
		var topicSearch,querySearch,responseSearch,actionSearch=null;
        $scope.map = {};
        loadTopic();

		//submit map
		function submitMap () {
            doAjaxCall($scope.map,'json',"http://localhost:8181/api/topicQueryResponseMap/add");					
		}		

		// ============================= load data ===========================================
		//load topic 
		function loadTopic () {
		    $http.get("http://localhost:8181/api/topic/loadTopic?limit=10")
		    .then(function(response) {
		    	$scope.topiclist = response.data;
		    });			
		}	

		// =============================== onclick ======================================

		$scope.onClickQueryByTopicid = function(topicid,ct){
			$scope.map.topicid = topicid;
			$scope.currentTopic = ct;
			getQuerylistByTopicId($scope.map.topicid);			
		}
		$scope.onClickQueryAdd = function(qid){	
			$scope.map.queryid = qid;
			submitMap();
			getQuerylistByTopicId($scope.map.topicid);					
		}
		$scope.onClickResponseAdd = function(rid){	
			$scope.map.responseid = rid;
			submitMap();
			getResponselistByTopicIdAndQueryId($scope.map.topicid,$scope.map.queryid);				
		}

		//check /////////// remove by query id
		$scope.onClickQueryRemove = function(topicid,qid){	
			$http.get("http://localhost:8181/api/topicQueryResponseMap/removeQuery?tid="+topicid+"&qid="+qid)
			.then(function(response) {});
			getQuerylistByTopicId($scope.map.topicid);
			$scope.responselist	= null;				
		}
		$scope.onClickRemoveResponse = function(mapid){	
			$http.get("http://localhost:8181/api/topicQueryResponseMap/removeById?id="+mapid)
			.then(function(response) {});
			getResponselistByTopicIdAndQueryId($scope.map.topicid,$scope.map.queryid);					
		}
		

		$scope.onClickQueryMap = function(qid,q){	
			$scope.map.queryid = qid;
			$scope.currentQuery = q;
			getResponselistByTopicIdAndQueryId($scope.map.topicid,$scope.map.queryid);					
		}											
		//================================ on change ====================================
		
		$scope.onChangeTopicSearch = function(){
			$http.get("http://localhost:8181/api/topic/getByTopic?topic="+$scope.topicSearch)
			.then(function(response) {
				$scope.topiclist = response.data;
			});			
		}	
		$scope.onChangeQuerySearch = function(){
			if($scope.map.topicid>0)
			$http.get("http://localhost:8181/api/query/getByQuery?q="+$scope.querySearch)
			.then(function(response) {
				$scope.searchQueryList = response.data;
			});			
		}
		$scope.onChangeResponseSearch = function(){
			if($scope.map.topicid>0 && $scope.map.queryid>0)
			$http.get("http://localhost:8181/api/response/getByResponse?q="+$scope.responseSearch)
			.then(function(response) {
				$scope.searchResponseList = response.data;
			});			
		}		
		
		//=====================================================================================
		function getQuerylistByTopicId(topicid){
			$http.get("http://localhost:8181/api/topicQueryResponseMap/getByTopicId?id="+topicid)
			.then(function(response) {
				$scope.querylist = response.data;
			});
		}
		function getResponselistByTopicIdAndQueryId(topicid,queryid){
			$http.get("http://localhost:8181/api/topicQueryResponseMap/getResponselistByTopicIdAndQueryId?topicid="+topicid+"&queryid="+queryid)
			.then(function(response) {
				$scope.responselist = response.data;
			});
		}
	});