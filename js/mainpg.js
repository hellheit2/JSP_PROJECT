$(document).ready(function(){

    //manu_btn
    var show1 = false;
    $(".menu_btn").click(function(){
        show1=!show1 //클릭하는 순간 true
        if(show1==true){
            $("#menu_r").animate({"left":"0"},300);//메뉴 펼치기 menu_r 만 주면 버튼 사라짐
            $(".menu_btn").animate({"left":"200"},300).attr("src","images/menu_close.png"); //버튼도 같이 움직임
          
        }else{
            $("#menu_r").animate({"left":"-200px"},300); //메뉴 접기
            $(".menu_btn").animate({"left":"0"},300).attr("src","images/menu.png");
           
        }
    });

});