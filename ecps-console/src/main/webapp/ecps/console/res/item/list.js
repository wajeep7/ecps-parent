$(function() {


	var showStatus = parseInt($("#showStatus").val());

	if(showStatus == 0) {
		$("#label5").attr("class", "here");
	}
	else if(showStatus == 1) {
		$("#label4").attr("class", "here");
	}
	else {
		$("#label6").attr("class", "here");
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
		$("#showForm").submit();
	});

	



});


function isShow(itemId, showStatus) {
	tipShow("#addItemNote");
	$("#itemId").val(itemId);
	$("#showStatus1").val(showStatus);
	$("#itemNote").val("");
}


function isFaBu(itemId) {
	//遮罩defalut
	tipShow("#staticLoadDiv");
	$.ajax({
		url:path+"/item/publishWebService.do",
		type:"post",
		data:{itemId:itemId},
		dataType:"text",
		success:function (responseText) {
			alert(responseText);
			if(responseText=="success"){
				alert("成功")
			}else{
				alert("失败")
			}
			tipHide("#staticLoadDiv");
		},
		error:function () {
			alert("系统错误");
		}
	});
}
