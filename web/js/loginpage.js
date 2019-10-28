//登录
$.loginSubmit=function(){
    $.ajax({url:"/servlet/LoginServlet",type:"post",data:{"account":$(".username").val(),"secret":$(".password").val()},
        success:function (data) {
            if(data == "error"){
                alert("登录失败");
            }
            else{
                alert("登录成功"+data);
            }
        }
    });
}