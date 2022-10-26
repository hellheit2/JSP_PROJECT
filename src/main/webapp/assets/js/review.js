$(document).ready(function(){
    let data_cno = $("#reviewList").attr("data-cno");
    let data_id = $("#reviewList").attr("data-id");
    //u d
    // 시작하면서 해당 cno의 모든 리뷰 리스트를 가져옴
    let reviewPage = getReviewList(data_cno);

	
	
  
}); //document.ready
function getReviewList(contentId){
	let reviewList;
	
	 $.ajax({
        url: '/review?content='+ contentId,
        type: 'GET',
        headers: {"content-type":"application/json"},
        success : function(result){
            reviewList = result.rivewPageList;

        },
        error: function() {
            alert("error");
        }
    });

	return reviewList;
	
}