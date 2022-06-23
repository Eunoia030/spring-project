// 사이드바
$(document).ready(function(){
    $(".btn_menu_open").click(function(){
        $("#mask").fadeIn(100);
        $(".slide_menu").show().animate({left: "0"});
    });
    $("#mask, .btn_menu_close").click(function(){
        $("#mask").fadeOut(100);
        $(".slide_menu").hide().animate({left: "0"});
    });

    $(".btn_menu_open1").click(function(){
        $("#mask1").fadeIn(100);
        $(".slide_menu1").show().animate({right: "0"});
    });
    $("#mask1, .btn_menu_close1").click(function(){
        $("#mask1").fadeOut(100);
        $(".slide_menu1").hide().animate({right: "0"});
    });
});

$("#btnGoToJoin").click(()=>{
    location.href = '/user/join'
})