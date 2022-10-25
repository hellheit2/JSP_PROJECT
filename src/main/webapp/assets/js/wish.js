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


function modal(id) {
    var zIndex = 9999;
    var modal = document.getElementById(id);

    // 모달 div 뒤에 불투명 배경
    var bg = document.createElement('div');
    bg.setStyle({
        position: 'fixed',
        zIndex: zIndex,
        left: '0px',
        top: '0px',
        width: '100%',
        height: '100%',
        overflow: 'auto',
        backgroundColor: 'rgba(0,0,0,0.4)'
    });
    document.body.append(bg);

    // 닫기 버튼 처리, 불투명 배경 및 모달 div 지우기
    modal.querySelector('.modal_close_btn').addEventListener('click', function() {
		console.log("close");
        bg.remove();
        modal.style.display = 'none';
    },{ once : true });

    modal.setStyle({
        position: 'fixed',
        display: 'block',
        boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',

        // 시꺼먼 레이어 보다 한칸 위에 보이기
        zIndex: zIndex + 1,

        // div center 정렬
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        msTransform: 'translate(-50%, -50%)',
        webkitTransform: 'translate(-50%, -50%)'
    });
}

Element.prototype.setStyle = function(styles) {
    for (var k in styles) this.style[k] = styles[k];
    return this;
};

function get_content(target, id){
	console.log(id);
	
	console.log(target);
	document.getElementById('my_modal').childNodes[1].setAttribute("src","/content?id="+id);
	
	modal('my_modal');
	
	
}
