$(function() {

    var auditStatus = parseInt($("#auditStatus").val());
    if(auditStatus == 0) {
        $("#label1").attr("class", "here");
    }
    else if(auditStatus == 1) {
        $("#label3").attr("class", "here");
    }
    else if(auditStatus == 2) {
        $("#label2").attr("class", "here");
    }
    else {
        $("#label4").attr("class", "here");
    }

    var pageNo = $("#currentPageNo").val();
    var totalPage = $("#totalPage").val();
    pageNo = parseInt(pageNo);
    totalPage = parseInt(totalPage);
    if(pageNo == 1 && pageNo == totalPage) {   //全部隐藏
        $("#first").hide();
        $("#prev").hide();
        $("#next").hide();
        $("#last").hide();
    }
    else if(pageNo == 1 && totalPage > pageNo) {    //下一页和尾页显示
        $("#first").hide();
        $("#prev").hide();
        $("#next").show();
        $("#last").show();
    }
    else if(pageNo > 1 && totalPage > pageNo) {     //全部显示
        $("#first").show();
        $("#prev").show();
        $("#next").show();
        $("#last").show();
    }
    else if(pageNo == totalPage && totalPage > 1) {   //首页和上一页显示
        $("#first").show();
        $("#prev").show();
        $("#next").hide();
        $("#last").hide();
    }

    $("#first").click(function() {
        pageNo = 1;
        $("#pageNo").val(pageNo);
        $("#form1").submit();

    });
    $("#prev").click(function() {
        pageNo = pageNo - 1;
        $("#pageNo").val(pageNo);
        $("#form1").submit();

    });
    $("#next").click(function() {
        pageNo = pageNo + 1;
        $("#pageNo").val(pageNo);
        $("#form1").submit();

    });
    $("#last").click(function() {
        pageNo = totalPage;
        $("#pageNo").val(pageNo);
        $("#form1").submit();
    });

    $("#addItemNoteConfirm").click(function() {
        var a = $("#itemNote").val();
        $("#itemNotes").val(a);
        $("#auditStatusForm").submit();
    });

});


function isPass(itemId, auditStatus) {
    tipShow("#addItemNote");
    $("#addItemNoteH2").html("审核状态")
    $("#itemId").val(itemId);
    $("#auditStatus1").val(auditStatus);
    $("#itemNote").val("");


}










