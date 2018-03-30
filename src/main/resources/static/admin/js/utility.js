
function doAjaxCall(urlParameter,dataType,api)
{
		var return_first = function () {
			var tmp = null;
			$.ajax({
                'async': false,
				'type': "POST",
				'dataType': "html",
				'url': api,
				'data': urlParameter,
				'success': function (data) {
					tmp = data;
                },
                'error': function(jqXHR, textStatus, errorThrown) {
                    alert('Error: ' + textStatus + ' ' + errorThrown);
                }                
			});
			return tmp;
		}();
		return return_first;
}


function notify(msg,type)
{
    if(type=='success'){ 
        $.notify(msg,{type:"success"});
    }
    if(type=='error'){ 
        $.notify(msg,{type:"danger"});
    }
    if(type=='toast'){ 
        $.notify(msg,{type:"toast"});
    }
}