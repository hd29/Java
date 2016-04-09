
$(document).ready(function() {
	$("#result").hide();
	$("#pass2").hide();
	$("input").focus(function() {
		$(this).css("border-color","red");
	}).blur(function() {
		$(this).css("border-color","");
	});
	$("#i").blur(function() {
//		var username = document.getElementById("un").value;
//		var username = $("#un").val();
		var id = 0;
		id = $("#i").val();
//		alert(id+username);
		
//		$.get("http://localhost:8383/SSH_MVN/action_query.action?id="
//				+ encodeURI(encodeURI(id)),null,function(response){  
//            $("#result").html(response);  
//        });         
		if(id!=0){
			
			$.ajax({
				cache:true,
				type: "GET",
	            url:"verify_User.action",
	            data: "userid=" + id,
	            async: false,
	            error: function(request) {
	                alert("lianjieshibai！");
	            },
	            success: function(data) {
//	            	$("#result").show();
	            	 $("#result").show().html(data);
	            }
			});
		}else{
			$("#result").show();
			document.getElementById("result").innerHTML = "ID不能为空！";
		}
		
	});
	
	$("#rm").blur(function() {
		var pass1 = document.getElementById("rm").value;
		var pass2 = document.getElementById("ps").value;
		if (pass1!=pass2) {
//			alert("密码不一致！");
			$("#pass2").show();
		}else{
//			document.getElementById("pass").value="sss";
			$("#pass2").hide();
		}
		
	});
});
