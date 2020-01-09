

$(function () {
    $(".bg_text input").blur(function () {
        var login=$(this).val();
        login=$.trim(login);
        var inputName=$(this).attr("name");
        if(login==null || login === ""){
            if(inputName === "username"){
                $("#errorName").html("用户名不能为空");
            }
            if(inputName === "password"){
                $("#errorName").html("密码不能为空");
            }
            if(inputName === "captcha"){
                $("#errorName").html("验证码不能为空");
            }

            $("#errorName").show(200);
        }else{
            $("#errorName").hide(200);
        }

    });

     var tip= $("#tip").val();
     if(tip==="captcha_error"){
         $("#errorName").html("验证码错误");
         $("#errorName").show(200);
     }
     else if(tip==="user_error"){
         $("#errorName").html("用户名或密码错误");
         $("#errorName").show(200);
     }


});












function getCaptcha() {

    var captcha_path = path +"/user/getImage.do?date="+new Date().getTime();
    $("#capachaImg").attr("src",captcha_path);



}