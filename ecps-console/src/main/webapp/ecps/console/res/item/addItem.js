$(document).ready(function(){
		//页面加载是就产生的函数
		// 拿到图片标签创建对象 在前台创建页面属性
		var fck = new FCKeditor("itemDesc");
		fck.BasePath = path+"/ecps/console/res/plugins/fckeditor/";
		fck.Config["ImageUploadURL"] =path+ "/upload/uploadForFck.do?typeStr=Image";
		fck.Height = 400;
		fck.ToolbarSet = "Default";
		fck.ReplaceTextarea();
      

        function valid(){
    	   if(!skuSepValueValid()){
       		$("#button1").removeAttr("disabled");
	       		return false;
	       	}
	       	if(!preData()){
	       		$("#button1").removeAttr("disabled");
	       		return false;
	       	}
	       	return true;
       }
     $("#button1").click(function(){
    	$("#myForm").ajaxSubmit({
 		 	 beforeSubmit:valid,
 		 	contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			 type:'post',
            dataType: "text",
			 success:function(responseText){
				 alert("success");
			 }
 	 	});
    	return false;
    });
       
    function skuSepValueValid(){
    	var list = new Array();
    	var result=true;
    	$(".sp_0").each(function(){
    		var buffer="";
    		var checkedNum = 0;
    		$(this).find(".specValue4").each(function(){
                var obj=$(this).next();
                if(obj.attr("type")=="radio"){
                	var tempBuffer = $(this).nextAll("input:checked").val();
                	if($.trim(tempBuffer) != "" && tempBuffer != null){
                		checkedNum++; 
                	}
                   buffer+= tempBuffer;
                }
    		});
    		
    		
    		if(result){
    			list.push(buffer);
    		}else{
    			return false;
    		}
    	});
    	return result;
    }
   
	function showResponse(responseText, statusText){ 
		$("#button1").removeAttr("disabled");
		var obj=eval("("+responseText+")");
		alert(obj.message);
		if(obj.result=="success"){
			document.location.href="<c:url value='/${system }/item/listEntity.do'/>";	
		}
		
	}
    
});
//==================================================================================================================
$(function(){
	var divNum=1;
	var tObj;
	$("#tabs a").each(function(){
		if($(this).attr("class").indexOf("here") == 0){tObj = $(this)}
		$(this).click(function(){
			var c = $(this).attr("class");
			if(c.indexOf("here") == 0){return;}
			var ref = $(this).attr("ref");
			var ref_t = tObj.attr("ref");
			tObj.attr("class","nor");
			$(this).attr("class","here");
			$(ref_t).hide();
			$(ref).show();
			tObj = $(this);
			if(ref == '#tab_2'){
				FCKeditorAPI.GetInstance('itemDesc').Focus();
				//FCKeditorAPI.GetInstance('itemDesc').EditorDocument.body.innerHTML = '12123123';
			}
		});
	});
	$("input[reg1]").blur(function(){
		var a=$(this);
		var reg = new RegExp(a.attr("reg1"));
		var objValue = a.val();
		if(!reg.test(objValue)){
			if(a.next("span").length ==0){
			a.after("<span>"+a.attr("desc")+"</span>");
			}
		}else{
			a.next("span").remove();
			}
		});
	//实现页面规格的自动增加和删除
	$("#button2").click(function(){
		//js 当前页面 全局属性
		divNum++;
		//sp_0=tab 4 的 div id 拿到這個div所有的html 元素  拿到table
		var divHtml=$("#sp_0").html();
		//重新给div sp0 这对标签一个个是
		divHtml = "<div id='sp_"+divNum+"'>"+divHtml+"</div>";
		//替换掉满足这个标签的元素
		divHtml = divHtml.replace(/radipspec1/g,"radipspec"+divNum);
		//sort1  skuPrice1 marketPrice1   stockInventory1   skuUpperLimit1   sku1  location1 showStatus1 skuType1
		//定位到html div 属性后 一次给表内元素 ++赋值操作 正则表达式替换
		divHtml=divHtml.replace(/sort1/g,"sort"+divNum);//前面是要搜索的值 后面是替换的值
		divHtml=divHtml.replace(/skuPrice1/g,"skuPrice"+divNum);//前面是要搜索的值 后面是替换的值
		divHtml=divHtml.replace(/marketPrice1/g,"marketPrice"+divNum);//前面是要搜索的值 后面是替换的值
		divHtml=divHtml.replace(/stockInventory1/g,"stockInventory"+divNum);//前面是要搜索的值 后面是替换的值
		divHtml=divHtml.replace(/skuUpperLimit1/g,"skuUpperLimit"+divNum);//前面是要搜索的值 后面是替换的值
		divHtml=divHtml.replace(/sku1/g,"sku"+divNum);//前面是要搜索的值 后面是替换的值
		divHtml=divHtml.replace(/location1/g,"location"+divNum);//前面是要搜索的值 后面是替换的值
		divHtml=divHtml.replace(/showStatus1/g,"showStatus"+divNum);//前面是要搜索的值 后面是替换的值
		divHtml=divHtml.replace(/skuType1/g,"skuType"+divNum);//前面是要搜索的值 后面是替换的值
		divHtml=divHtml.replace(/sp_0/g,"sp_"+divNum);
		//增加先执行 替换目标如果是 sp_0 他永远页找不到 只能和第一个相等 sp_01 sp_02

		//给标签div num 赋值
		$("#divNum").val(divNum);

		$(".page_c").before(divHtml);


		});

	$("#showStatus3").click(function(){
			var a=$("#auditStatus1").attr("checked");
			if("checked" != a){
				alert("必须得审核通过后，才能上架");
				$("#showStatus4").attr("checked",true);
			}
		});
    $("#auditStatus0").click(function(){
    	$("#showStatus4").attr("checked",true);
    	$("#showStatus1").attr("value","1");
        });
    $("#auditStatus2").click(function(){
    	$("#showStatus4").attr("checked",true);
    	$("#showStatus1").attr("value","1");
    });
    $("#showStatus4").click(function(){
    	 $("#showStatus1").attr("value","1");
        });
});

//商品规格的redio选中与取消
$(".sp_0").find("input[type=radio]").live("dblclick",function(){
	if($(this).attr('checked') == 'checked'){
		$(this).removeAttr('checked');
	}else{
		$(this).attr('checked','checked');
	}
});

function changePri(obj){
	var reg0=/^[0-9]{1,7}\.{0,1}[0-9]*$/;
	var test=obj.value;
	if(!reg0.test(test)){
		return;
	}
	var test1=test.indexOf(".");
	var firstSub=test.substring(0,test1);
	var lastSub=test.substring(test1+1,test.length);
	if(lastSub.length >= 3) {
		lastSub=lastSub.substring(0, 2); 
	}
	if(lastSub.length==1){
		lastSub=lastSub+'0';
	}
	if(lastSub.length==0){
		lastSub='00';
		}
	if(test1==-1){
		obj.value=test+".00";
	}
	else{
		obj.value=firstSub+'.'+lastSub;
	}
}
function clickRemove(id){
	 if(id =="#sp_0"){
        alert("默认格式不可删除");
         return false;

     }else {
	    if(confirm("确认删除吗？"))

	     $(id).remove();
     }
}




function submitImgSize1Upload() {
	var options = {
			url : path + "/upload/uploadFilePath.do",
			dataType : "text",
			success : function(responseText) {
				var jsonObj = $.parseJSON(responseText);
				$("#imgsImgSrc").attr("src", jsonObj.upload_file_path);
				$("#imgs").val(jsonObj.relative_file_path);
				$("#lastFilePath").val(jsonObj.upload_file_path);

			}
		};

		$("#myForm").ajaxSubmit(options);
}