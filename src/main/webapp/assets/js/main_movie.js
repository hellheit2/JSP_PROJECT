

function banner1(){
$(".movie_wrap").animate({
    marginLeft:parseInt($(".movie_wrap").css("margin-left"))-300+"px"},"slow",function(){
        $(".movie_wrap li:first").appendTo(".movie_wrap");
        $(".movie_wrap").css("margin-left","-300px");
    });
}

$(document).ready(function(){
	var width1 = 300 * $(".movie_wrap li").size()+"px";
	$(".movie_wrap").css("width",width1); //240x16 =3840px
	$(".movie_wrap li:last").prependTo(".movie_wrap");
	$(".movie_wrap").css("margin-left","-300px");
	
	var banner = setInterval("banner1()",2000);
	
	$(".movie_wrap li").mouseover(function(){
	    clearInterval(banner); //clearInterval :대기시간마다 함수 반복실행 없앰
	    $(this).find("img").css("opacity","0.5")
	}).mouseout(function(){
	    banner=setInterval("banner1()",2000); //setInterval :대기시간마다 함수 반복실행
	    $(this).find("img").css("opacity","1.0");
	})


});