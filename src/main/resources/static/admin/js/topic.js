

	var app = angular.module("App", []);
	app.controller("Ctrl", function($scope, $http) {
        $scope.currentQuery = '';
        $scope.currentQueryId = 0;
        $scope.topic = {};
        loadTopic();

		//submit response
		$scope.topicFormSubmit = function () {
            doAjaxCall($scope.topic,'json',"http://localhost:8181/api/topic/add");
            $scope.topic = {};
            loadTopic () ;					
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

		$scope.onClickEditTopic = function($id,$topic,$description){
            $scope.topic = {};
            $scope.topic.topicid = $id;
            $scope.topic.topic = $topic;
            $scope.topic.description = $description;
        }	
		$scope.onClickDeleteTopic = function($id){
			$http({
				method : "GET",
				url : "http://localhost:8181/api/topic/delete?id="+$id,
			}).then(function mySuccess(response) {
                if($scope.search){
                    $scope.onChangeTopicSearch () ;
                }else loadTopic();
			});			
        }				
		//================================ on change ====================================
		
		$scope.onChangeTopicSearch = function(){
			$http.get("http://localhost:8181/api/topic/getByTopic?topic="+$scope.search)
			.then(function(response) {
				$scope.topiclist = response.data;
			});			
		}	

	});