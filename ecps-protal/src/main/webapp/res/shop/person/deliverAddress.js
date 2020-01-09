$(function () {
    $("#province").change(function () {
        var parentId = $(this).val();
        changeLoad(parentId, "myCity");

    });

    $("#myCity").change(function () {
        var parentId = $(this).val();
        changeLoad(parentId, "district");

    });

    $("#jvForm").submit(function () {
        var flag = true;

        var length=("#addShipAddrRm").val();
        length=parseInt(length);
        if(length>=5){
            alert("地址不能保存超过5个");
            flag=false;
        }else{
            return flag
        }

    });


});

/*selectId 是标签 name ID*/
function changeLoad(parentId, selectId) {
    $.ajax({
        url: path + "/user/selectAjaxAddress.do",
        type: "post",
        data: {
            "parentId": parentId
        },
        dataType: "text",
        async:false,
        success: function (responseText) {
            var JSONobj = $.parseJSON(responseText);
            var areaList = JSONobj.areaList;
            /*empty 移出*/
            if (selectId === "myCity") {
                $("#" + selectId).empty();
                $("#district").empty();
                $("#" + selectId).append("<option value='-1'>城市</option>")
                $("#district").append("<option value='-1'>县/区</option>>")

            } else {
                $("#district").empty();
                $("#district").append("<option value='-1'>县/区</option>>")
            }


            var option = "";
            for (var i = 0; i < areaList.length; i++) {
                option = option + "<option value='" + areaList[i].ereaId + "'>" + areaList[i].ereaName + "</option>"

            }
            $("#" + selectId).append(option);

        },
        error: function () {
            alert("系统错误")
        }
    });
}

/**
 * 佛祖保佑
 * 代码无BUG
 * @author pg777
 */
function modifyAddr(shipAddrId) {

    $.ajax({
        url: path + "/user/selectAjaxAddrByAddrId.do",
        type: "post",
        data: {"shipAddrId": shipAddrId},
        dateType: "text",
        success: function (responseText) {
            var jsonObj = $.parseJSON(responseText);
            var addr = jsonObj.addr;
            $("#shipAddrId").val(addr.shipAddrId);
            $("#shipName").val(addr.shipName);
            $("#province").val(addr.province);
            changeLoad(addr.province,"myCity");
            $("#myCity").val(addr.city);
            changeLoad(addr.city,"district");
            $("#district").val(addr.district);
            $("#addr").val(addr.addr);
            $("#zipCode").val(addr.zipCode);
            $("#phone").val(addr.phone);
            if(addr.defaultAddr == 1){
                $("#defaultAddr").attr("checked",true);
            }else{
                $("#defaultAddr").removeAttr("checked");
            }
        },
        error: function () {
            alert("系统错误");
        }



    });

}