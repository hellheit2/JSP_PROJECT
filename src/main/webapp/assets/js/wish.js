function like_func(obj){
	console.log($(obj).find('img').attr('src'));
	console.log($(obj).find('img').attr('data-content'));
	let wish = $(obj).find('img');
	let content = $(obj).find('img').attr('data-content');
	let wish_status = true;
	
	let checked = "../assets/images/wish_checked.png";
	let unchecked = "../assets/images/wish.png";
	
	if(wish.attr('src') === checked){
		wish.attr("src", unchecked);
		wish_status = false;
		console.log("checked");
	}else{
		wish.attr("src", checked);
		wish_status = true;
		console.log("unchecked");
	}
	
	$.ajax({
         type : "GET",
         url : "http://localhost:8090/wish",
         contentType: "application/json",
         dataType: "json",
         data:{"content-id":content,"status":wish_status},
         success : function (data) {
            console.log(data);
            console.log("success");
         },
         error : function (data) {
			console.log(data);
			console.log("error");
         }
     });		
}

function login_need(){
	alert(" 로그인 후 이용하실 수 있습니다.")
}