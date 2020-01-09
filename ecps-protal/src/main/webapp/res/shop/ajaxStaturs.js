$(function () {
   $.ajax({
       url:path+"/user/ajaxCom.do",
       type:"post",
       dataType:"text",
       success:function (responseText) {
            var JSONobj = $.parseJSON(responseText);
            var user=JSONobj.user;
           $("#loginAlertIs").html("欢迎你：" + user.username);
            },
        error:function () {
            alert("系统错误");
        }
   });
});

