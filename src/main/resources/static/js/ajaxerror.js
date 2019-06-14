$.ajax({
    	url: "/err/getAjaxerror",
    	type: "POST",
    	async: false,
    	success: function(data) {
    		debugger;//运行时就会自动在页面的此行代码中显示断点
            if(data.status == 200 && data.msg == "OK") {
            	alert("success");
            } else {
            	alert("发生异常：" + data.msg);
            }
    	},
        error: function (response, ajaxOptions, thrownError) {
        	debugger;
        	alert("error");       
        }
    });