//ajak请求传回后台
function submitUpload() {
    var option = {
        url: path + "/upload/uploadFilePath.do",
        dataType: "text",
        success: function (responseText) {
            var jsonObj = $.parseJSON(responseText);
            $("#imgsImgSrc").attr("src", jsonObj.upload_file_path);
            $("#imgs").val(jsonObj.relative_file_path);
            $("#lastFilePath").val(jsonObj.upload_file_path);

        }
    };

    $("#form111").ajaxSubmit(option);
}

$(function () {
    $("#form111").submit(function () {
        var isSubmit = true;
         $(this).find("[reg2]").each(function () {
            // 打印出INPUT 标签 reg2 不能为空
            // alert($(this).get(0));
            // 拿到INPUT标签的 的正则表达式
            var reg2 = $(this).attr("reg2");
            var val = $(this).val();
            val = $.trim(val);
            var reg = new RegExp(reg2); // 构建正则表达式
            var tip = $(this).attr("tip");
            if (!reg.test(val)) {
                // 如果 正则表达式 和 input 取得值不相等
                // 不符合正则表达式的格式
                $(this).next("span").html("<font color='red'>" + tip + "</font>");
                isSubmit = false;
                // 如果这个表单验证出现错误了 下面就终止验证
                // 直接结束验证重新开始
                return false;
            } else {
                // 回调函数 ajax
                var isFlag = validBrandByNameAjax(val);
                // 拿到INPUT 标签的的name 属性
                var inputName = $(this).attr("name");
                if (inputName == "brandName") {
                    if (isFlag == "no") {
                            $(this).next("span").html("<font color='red'>品牌名称重复</font>");
                        isSubmit = false;
                        return false;
                    } else {
                        $(this).next("span").html("");
                    }
                } else {
                    // 不匹配正则表达式 就把他删除掉重来 给他空字符串
                    $(this).next("span").html("");
                }
            }

        });

        // 所有的tip提示都叫一个名字
        $(this).find("[reg1]").each(function () {
            var reg1 = $(this).attr("reg1");
            var val = $(this).val();
            val = $.trim(val);
            var tip = $(this).attr("tip"); // 拿到当前提示的
            // 因为是个表单
            var reg = new RegExp(reg1); // 穿件正则表达式对象
            // 进行判定
            // 空值 可以传输。 传输的值 必须符合HTTP 符合 输入要求的时候采取判断
            if (val != null && val != "" && !reg.test(val)) {
                $(this).next("span").html("<font coler ='red'>" + tip + "</font>");
                isSubmit = false; // 全局变量
                return false;
            } else {

                $(this).next("span").html("");

            }

        });
        //防止重复提交通过JS/com,js 方法 tipShow 操作 DEFAULT 这个标签 并控制他的团
        if (isSubmit) {
            tipShow("refundLoadDiv");
        }
        return isSubmit;

    });

    //老张复制第一部分

    $(this).find("[reg1]").blur(function () {
        var reg1 = $(this).attr("reg1");
        var val = $(this).val();
        val = $.trim(val);
        var tip = $(this).attr("tip"); // 拿到当前提示的
        // 因为是个表单
        var reg = new RegExp(reg1); // 穿件正则表达式对象
        // 进行判定
        // 空值 可以传输。 传输的值 必须符合HTTP 符合 输入要求的时候采取判断
        if (val != null && val != "" && !reg.test(val)) {
            $(this).next("span").html("<font coler ='red'>" + tip + "</font>");

        } else {

            $(this).next("span").html("");

        }

    });

    //老张复制部分
    $(this).find("[reg2]").blur(function () {
        // 打印出INPUT 标签 reg2 不能为空
        // alert($(this).get(0));
        // 拿到INPUT标签的 的正则表达式
        var reg2 = $(this).attr("reg2");
        var val = $(this).val();
        val = $.trim(val);
        var reg = new RegExp(reg2); // 构建正则表达式
        var tip = $(this).attr("tip");
        if (!reg.test(val)) {
            // 如果 正则表达式 和 input 取得值不相等
            // 不符合正则表达式的格式
            $(this).next("span").html("<font color='red'>" + tip + "</font>");
        } else {
            // 回调函数 ajax
            var isFlag = validBrandByNameAjax(val);
            // 拿到INPUT 标签的的name 属性
            var inputName = $(this).attr("name");
            if (inputName == "brandName") {
                if (isFlag == "no") {
                    $(this).next("span").html("<font color='red'>品牌名称重复</font>");
                } else {
                    $(this).next("span").html("");
                }
            } else {
                // 不匹配正则表达式 就把他删除掉重来 给他空字符串
                $(this).next("span").html("");
            }
        }

        //结尾括号
    });

});

function validBrandByNameAjax(brandName) {
    var result = "";
    $.ajax({
        type: "post",
        url: path + "/item/validBrandByNameAjax.do",
        data: {
            "brandName": brandName
        },
        dataType: "text",
        async: false,// 同步操作
        success: function (resultDate) {
            if (resultDate != null) {
                result = resultDate;

            }
        },
        error: function () {
            alert("系统异常");
        }

    });
    return result;
}
