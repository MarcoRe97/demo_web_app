

$(function() {
    $(".login").click(function(){
        //1、主页面变灰，2登录页面显示
        $(".window").show();
        $(".loginbox").show();
    });

    $(".register-btn").click(function(){
        //1、主页面变灰，2登录页面显示
        $(".window").show();
        $(".registerbox").show();
    });
    $("#returnMain").click(function(){
        //1、主页面可见，2、登录页面不可见
        $(".window").hide();
        $(".loginbox").hide();
    });

    $("#returnMain_r").click(function(){
        //1、主页面可见，2、登录页面不可见
        $(".window").hide();
        $(".registerbox").hide();
    });
    $("#person").click(function(){
        window.open("personal.html");
    });
    $("#gotoBookshop").click(function () {
        window.open("bookshop.html");
    })
});

//注册
$.registerSubmit=function () {
    $.ajax({url:"/servlet/RegisterServlet",type:"post",
        data:{"username":$("#r_account").val(),"password":$("#r_secret").val(),"phone":$("#r_phone").val()},
        success:function(data){
            if(data == "error"){
                alert("注册失败");
            }
            else{
                alert("注册成功");
            }
        }
    });
}
$.keeplogin=function(){
    $.ajax({url:"/servlet/KeepLoginServlet",type:"post",data:{"account":$("#account").val(),"secret":$("#secret").val()},
        success:function(data){
            if(data=="error") {

            }
            else {
                var name = document.getElementById("name");
                name.innerHTML="";
                $(".bookshop").show();
                $("#welcome").html("欢迎你"+data);
                $("#account").val("");
                $("#secret").val("");
                $("#info").html("");
                $(".unwelcom").hide();
                $(".loginbox").hide();
                $(".window").hide();
                name.innerHTML=data;
                $(".welcom").show();
                $(".safeback").show();
                $("#person").show();
                $(".reg").hide();
                $(".login_text").hide();

            }},
        error:function() {  $("#info").html("") ; }
    });
}