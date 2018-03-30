

	var app = angular.module("homeApp", ['ngSanitize']);
	app.controller("homeCtrl", function($scope, $http, $sce) {

        welcomeMsg = "Welcome to conversational AI, How can I help You"; 
        $scope.botmsg = welcomeMsg;
        responsiveVoice.speak(welcomeMsg);
        updateLiveScore();
        updateNews();
        updateWeather();

        // submit query
        document.onkeypress = function (e) {
            if(e.keyCode==13){
                // loading icon
                $scope.botmsg = '<center><img src="/user/loading.gif" width="150px"/></center>';
                if(commandManager($scope.inputQuery)){
                    responsiveVoice.speak("please have a look on new tab");
                    $scope.botmsg = $scope.inputQuery;
                }else
                    httpResponse($scope.inputQuery);
            }
        };

 		// loadResponse
         function httpResponse (q) {
		    $http.get("http://localhost:8181/botApi/?q="+q)
		    .then(function(response) {
                if(response.data.response){
                    dataval = response.data.response
                    words = dataval.split("&&");
                    if(words[1]=="youtube"){
                        $scope.youtubeBox = GetYoutubeCode(words[0]);
                        showYoutubox ();
                    }
                    else{
                        $scope.youtubeBox = "";
                        $scope.botmsg = dataval.replace("#", "<br/>");
                        responsiveVoice.speak(dataval.replace("#", " "));
                        showTextbox ();
                    }
                }
            });		
        }

        //=================================== animation ============================================
        function showTextbox () {
            $("#youtubebox").slideUp();
            $("#textbox").slideDown("slow");
        }
        function showYoutubox () {
            $("#textbox").slideUp();
            $("#youtubebox").slideDown("slow");
        }
        
        //=================================== generate message =====================================
        function GetYoutubeCode(str)
        {
            url = $sce.trustAsResourceUrl("https://www.youtube.com/embed/"+str+"?autoplay=1&rel=0");
            return $sce.trustAsHtml('<iframe src="'+url+'" frameborder="0" allowfullscreen></iframe>');
        }
        
        // ================================== other data =========================================
        function updateWeather(){
            $http.get("http://localhost:8181/botApi/weather?q=kolkata")
            .then(function(response) {
                console.log(response.data);
                $scope.weather = '<div class="display-1">'+
                                response.data['temp']+'°C </div>'+
                                response.data['description']+' | Humidity : '+response.data['humidity']+'%';
            });            
        }

        function updateLiveScore(){
            $http({
                method : "GET",
                url : "http://localhost:8181/botApi/score",
                responseType : 'text',
                headers: { 'Accept': 'application/text' },
            }).then(function mySuccess(response) {
                $scope.liveScore = response.data;
            });            
        }

        function updateNews(){
            $http.get("http://localhost:8181/botApi/news")
            .then(function(response) {
                $scope.news = '<h1 class="lead news">'+response.data[0]+'</h1>'+
                '<div class="news2">'+response.data[1]+'</div>'+
                '<div class="news2">'+response.data[2]+'</div>'+
                '<div class="news2">'+response.data[3]+'</div>'+
                '<div class="news2">'+response.data[4]+'</div>'+
                '<br/>';
            });            
        }

        $scope.youtubeLive = function(str){
            if(str=="Aaj Tak"){$scope.youtubeBox = GetYoutubeCode('X7Ktabhd8a4');}
            if(str=="DD News"){$scope.youtubeBox = GetYoutubeCode('WNna4W4jLek');}
            if(str=="NASA"){$scope.youtubeBox = GetYoutubeCode('P11y8N22Rq0');}
            if(str=="Bloomberg Global"){$scope.youtubeBox = GetYoutubeCode('Ga3maNZ0x0w');}
            if(str=="India Today"){$scope.youtubeBox = GetYoutubeCode('62rmi9KMvVE');}
            if(str=="Sky News"){$scope.youtubeBox = GetYoutubeCode('XOacA3RYrXk');}
            if(str=="CNN-News"){$scope.youtubeBox = GetYoutubeCode('i2TICRR7PMo');}
            if(str=="IndiaTV"){$scope.youtubeBox = GetYoutubeCode('an1_CXsBkKk');}
            showYoutubox ();
        }
	});