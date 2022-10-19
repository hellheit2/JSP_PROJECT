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
        bg.remove();
        modal.style.display = 'none';
    });

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

function modalClick(elem){
	console.log(elem.getAttribute('id') + '_modal');
	elem.addEventListener('click', function() {
	    // 모달창 띄우기
	    console.log("click");
	    modal(elem.getAttribute('id') + '_modal');
	});
}