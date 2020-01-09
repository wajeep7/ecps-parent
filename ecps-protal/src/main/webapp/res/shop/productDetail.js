$(function () {
    $("#loginAlertIs").click(function () {
        tipShow('#loginAlert');
    });

    $("#promptAlertIs").click(function () {
        tipShow('#promptAlert');
    });

    $("#transitAlertIs").click(function () {
        tipShow('#transitAlert');
    });

    var $smallList = $(".smallList"),
        $smallL = $(".smallL"),
        $smallR = $(".smallR"),
        smallLen = $(".smallList a").length,
        smallNum = 0;
    $smallList.css("width", (smallLen * 60));
    $smallL.live("click", function () {
        if (smallNum > 0) {
            $smallList.stop(true, true).animate({
                "left": "+=" + 60
            }, 400);
            smallNum--;
        }
    });
    $smallR.live("click", function () {
        if (smallNum <= (smallLen - 5)) {
            $smallList.stop(true, true).animate({
                "left": "-=" + 60
            }, 400);
            smallNum++;
        }
    });

    $('#ecpsShareIcon a').click(function () {

        var type = $(this).attr('class');

        var title = document.title;
        var url = window.location.href;
        var imgUrl = '';
        var href = '';

        var share = [
            {
                id: '0',
                type: 'sinawb',
                name: '分享到新浪微博',
                href: ['http://v.t.sina.com.cn/share/share.php?url=', encodeURIComponent(url), '&title=', encodeURIComponent(title)].join(''),
                bp: '0px 0px'
            },
            {
                id: '1',
                type: 'qqwb',
                name: '分享到腾讯微博',
                href: ['http://v.t.qq.com/share/share.php?url=', encodeURIComponent(url), '&title=', encodeURIComponent(title)].join(''),
                bp: '0px -16px'
            },
            {
                id: '2',
                type: 'renren',
                name: '分享到人人网',
                href: ['http://www.connect.renren.com/share/sharer?url=', encodeURIComponent(url), '&title=', encodeURIComponent(title)].join(''),
                bp: '0px -32px'
            },
            {
                id: '3',
                type: 'qqzone',
                name: '分享到QQ空间',
                href: ['http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=', encodeURIComponent(url), '&title=', encodeURIComponent(title)].join(''),
                bp: '0px -48px'
            },
            {
                id: '4',
                type: 'sohuwb',
                name: '分享到搜狐微博',
                href: ['http://t.sohu.com/third/post.jsp?content=utf-8&url=', encodeURIComponent(url), '&title=', encodeURIComponent(title)].join(''),
                bp: '0px -64px'
            },
            {
                id: '5',
                type: '',
                name: '分享到开心网',
                href: ['http://www.kaixin001.com/repaste/bshare.php?rurl=', encodeURIComponent(url), '&rtitle=', encodeURIComponent(title)].join(''),
                bp: '0px -80px'
            },
            {
                id: '6',
                type: '',
                name: '分享到51社区',
                href: ['http://share.51.com/share/outSiteShare.php?uri=', encodeURIComponent(url), '&title=', encodeURIComponent(title)].join(''),
                bp: '0px -96px'
            }
        ];

        for (var i = 0; i < share.length; i++) {
            if (type == share[i].type) {
                href = share[i].href;
            }
            ;
        }

        if (type == 'copy') {

            var copyText = url.replace(/[.]{1}\d[.]{1}/gi, ".");
            copyText = copyText.replace(/\.+u+\d+\.+html/, ".html");
            copyText = title + "\r\n" + copyText + "\r\n";
            if (window.clipboardData) {
                window.clipboardData.setData("Text", copyText);
                alert('复制成功！');
            }
        } else {
            $(this).attr('href', href);
        }

    });

    $('.sub').mousedown(function () {
        var num = $('.num').val();
        --num;
        if (num == 0) {
            $('#sub_add_msg').html('您填写的数字超过购买下限，单次购买下限为<var>1</var>件。');
            $('#sub_add_msg').show();
            return;
        } else {
            $('#sub_add_msg').hide();
        }
        $('.num').val(num);

    });

    $('.add').mousedown(function () {
        var num = $('.num').val();
        ++num;
        if (num == 6) {
            $('#sub_add_msg').html('您填写的数字超过购买上限，单次购买上限为<var>5</var>件。');
            $('#sub_add_msg').show();
            return;
        } else {
            $('#sub_add_msg').hide();
        }
        $('.num').val(num);
    });


    /*价格切换 查库存*/

    $(".spec a").click(function () {
        var skuId = $(this).attr("skuId");
        alert(skuId);
        $(".spec a").each(function () {
            $(this).removeClass();
        });
        $(this).attr("class","here");
        $.ajax({
            url:path+"/item/selectSkuBySkuId.do",
            type:"post",
            dataType:"text",
            data:{skuId:skuId},
            success:function (responseText) {
                var jsonObj=$.parseJSON(responseText);
/*
                alert(jsonObj.sku.skuPrice);
*/
                $("#skuPrice").html(jsonObj.sku.skuPrice);
                $("#marketPrice").html(jsonObj.sku.marketPrice);
                var stockInventory=jsonObj.sku.stockInventory;
/*
                alert("库存"+stockInventory);
*/
                if(stockInventory>0){
                    $("#stockInventory").html("有货")

                    $("#meBuy").show();
                    $("#meCart").show();

                }else{
                    $("#stockInventory").html("无货")
                    $("#meBuy").hide();
                    $("#meCart").hide();
                }
            },
            error:function () {
                alert("系统错误");
            }
        });
    });
    $(".spec a").eq(0).trigger("click");

});

function buy() {
    window.location.href = "./shop/confirmProductCase.jsp";
}

function addCart() {
    var skuId="";
    var quantity=$("#quantity").val();
    quantity=parseInt(quantity);
    $(".spec a").each(function () {
        if($(this).attr("class")==="here"){
            skuId=$(this).attr("skuId");
        }
    });

    if(validStork(skuId,quantity)){
        window.location.href = path+"/cart/addCart.do?skuId="+skuId+"&quantity="+quantity;
/*
        alert("库存充足")
*/
    }else{
        alert("库存不足");
    }


}


function validStork(skuId,quantity) {
    var flag=true;
    $.ajax({
        url:path+"/item/selectSkuBySkuId.do",
        dataType:"text",
        type:"post",
        data:{skuId:skuId},
        async:false,
        success:function (responseText) {
          var JsonObj=$.parseJSON(responseText);
          var sku=JsonObj.sku;
          flag = sku.stockInventory >= quantity;

        },
        error:function () {
            alert("库存ajax 异常")
        }
    });
    return flag;

}

















