function like_func(event, obj){
	
	event.stopPropagation();	// 이벤트 버블링 방지
	
	let controller = $(obj).attr('data-controller'); // 요청할 컨트롤러
	let target = $(obj).find('img'); // 좋아요 이미지
	let target_id = target.attr('data-content'); // 좋아요 대상 컨텐츠
	let status = true;	// 좋아요 여부
	let checked = "../assets/images/" + controller + "_checked.png"; // 좋아요 체크이미지
	let unchecked = "../assets/images/" + controller + ".png";	// 좋아요 체크 해제 이미지
	
	let like = $(obj).find('span'); // 좋아요
	let count = like.text();		// 좋아요 개수
	
	console.log(target_id);
	if(target.attr('src') === checked){ // checked -> unchecked
		count = parseInt(count) - 1;		  // 좋아요 개수 - 1
		like.text(count);					  // 최신화
		target.attr("src", unchecked);  // 이미지 변경
		status = false;						  // 좋아요 여부(DB 전송)
	}else{
		count = parseInt(count) + 1;		  // 좋아요 개수 + 1
		like.text(count);					  // 최신화
		target.attr("src", checked);	  // 이미지 변경
		status = true;						  // 좋아요 여부(DB 전송)
	}
	
	$.ajax({
         type : "GET",
         url : "http://localhost:8090/" + controller,
         contentType: "application/json",
         dataType: "text",
         data:{"target-id":target_id,"status":status},
         success : function (data) {
            console.log(data);
            console.log("success");
         },
         error : function (error) {
			console.log(error);
			console.log("error");
         }
     });		
}

function login_need(event){
	event.stopPropagation();
	alert(" 로그인 후 이용하실 수 있습니다.")
}

function comment_delete(event, obj){
		
	event.stopPropagation();	// 이벤트 버블링 방지

	let content_id = $(obj).attr('data-content');
	let comment_id = $(obj).attr('data-comment-id'); // 댓글 id
	console.log(comment_id);
	console.log(content_id);
	console.log("start");

	$.ajax({
         type : "POST",
         url : "http://localhost:8090/comment/del",
         dataType: "text",
         data:{"content-id":content_id,"comment-id":comment_id},
         success : function (data) {
            console.log(data);
            console.log("success");
         },
         error : function (error) {
			console.log(error);
			console.log("error");
         }
     });	
     
     let del_comment = $(obj).parents("li");
     del_comment.remove();	
}

let temp_btn;
let temp_body;
let comment_id;
let content_id;
function comment_modify(event, obj){
	
	event.stopPropagation();	// 이벤트 버블링 방지
	
	let btn = $(obj).parents("li").find(".btn_wrap");	
	let comment_body = $(obj).parents("li").find(".comment_body");
	
	temp_btn = '<div class="btn_wrap">' + btn.html() + '</div>';
	temp_body = '<div class="comment_body">' + comment_body.html() + '</div>';
	
	comment_id = $(obj).attr('data-comment-id');
	content_id = $(obj).attr('data-content');
	
	let m_form = "";
	m_form += '<div class="comment_body">';
	m_form += '<form method="post" action="/comment/modify" class="modify_form">';
	m_form += '<textarea class="co_modify" name="comment_body" placeholder = \"'+ comment_body.html() +'\"></textarea>';
	m_form += '</form>';
	m_form += '</div>';
	
	let m_btn = "";
	m_btn += '<div class="btn_wrap">';
	m_btn += '<button type="button" onclick="submit_modify(event, this);" class="comment_btn" data-comment-id='+ comment_id +' data-content='+ content_id +'>수정</button>';
	m_btn += '<button type="button" onclick="cancel_modify(event, this);" class="comment_btn" style="margin-left:8px;">취소</button>';
	m_btn += '</div>';
	
	comment_body.replaceWith(m_form);
	btn.replaceWith(m_btn);
	console.log(temp_body);
}

function submit_modify(event, obj){
	
	event.stopPropagation();	// 이벤트 버블링 방지
	
	let btn = $(obj).parents("li").find(".btn_wrap");	
	let comment_body = $(obj).parents("li").find(".comment_body");
	
	console.log(comment_id);
	console.log(content_id);
	let comment = $(obj).parents("li").find(".co_modify");
	let modified_comment = $(comment).val();
    
    if(modified_comment === temp_body
    	|| modified_comment == "undefined" || modified_comment == null || modified_comment == ""){
		cancel_modify(event,obj);
	}else{
	
	    $.ajax({
	         type : "POST",
	         url : "http://localhost:8090/comment/modify",
	         dataType: "text",
	         data:{"content-id":content_id,"comment-id":comment_id,"body":modified_comment},
	         success : function (data) {
	            console.log("success");
	         },
	         error : function (error) {
				console.log(error);
				console.log("error");
	         }
	     });  

	     btn.replaceWith(temp_btn);
	     comment_body.html(temp_body);
	     comment_body.html(modified_comment);
     }
}

function cancel_modify(event, obj){
	event.stopPropagation();	// 이벤트 버블링 방지
	
	let btn = $(obj).parents("li").find(".btn_wrap");	
	let comment_body = $(obj).parents("li").find(".comment_body");
	
	comment_body.replaceWith(temp_body);
	btn.replaceWith(temp_btn);
	
}