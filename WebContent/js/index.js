/**
 * 
 */
$(document).ready(function(){
	$('input[type=text],input[type=password]').val("");
	$('#cancel').bind('click',function(event){
		window.open('about:brank','_self').close();

	});

	$('#login').bind('click',function(event){
		var user=$('#login_form').serialize();
		$.ajax({
			type:"post",
			url :"ToyAuthentication/login",
			data:user,
			success:function(member,textStatus,xhr){

				$('input[type=text],input[type=password]').val("");
				alert('認証成功');

			},
			error :function(XMLHttpRequest,textStatus,errorThrown){

				$('inpu[type=text],input[type=password]').val("");
				alert('認証失敗');

			},
			complete :function(data){

			}


		});
	});
});