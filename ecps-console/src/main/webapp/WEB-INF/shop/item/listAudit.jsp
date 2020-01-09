<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/ecps/console/common/taglibs.jsp"%>
<head>
    <title>实体商品管理_商品审核</title>
    <meta name="heading" content="商品审核"/>
    <meta name="menu" content="ItemMgmtMenu"/>
    <script type="text/javascript" src="<c:url value='/${system}/res/js/jquery.form.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/${system}/res/js/jquery.tablesorter.js'/>"></script>
    <script type="text/javascript">var path="${path}";</script>
    <script type="text/javascript" src="${path}/ecps/console/res/item/listAudit.js"></script>
</head>
<body id="main">

<div class="frameL"><div class="menu icon">
    <jsp:include page="/${system}/common/itemmenu.jsp"/>
</div></div>

<form id="auditStatusForm" action="${path}/item/listAutidMoidfy.do" method="get">
    <input type="hidden" name="itemId" id="itemId" value="" />
    <input type="hidden" name="auditStatus" id="auditStatus1" value="" />
    <input type="hidden" name="itemNotes" id="itemNotes" value="">
</form>


<div class="frameR"><div class="content">

    <div class="loc icon"><samp class="t12"><</samp>当前位置：商品管理&nbsp;&raquo;&nbsp;<span class="gray" title="商品审核">商品审核</span></div>

    <h2 class="h2_ch"><span id="tabs" class="l">
        <a id="label4" href="${path}/item/toListAudit.do"   title="全部实体商品" class="nor">全部</a>
        <a id="label1" href="${path}/item/toListAudit.do?auditStatus=0&showStatus=1" title="待审核实体商品" class="nor">待审核</a>
        <a id="label2" href="${path}/item/toListAudit.do?auditStatus=2&showStatus=1"  title="审核不通过实体商品" class="nor">审核不通过</a>
        <a id="label3" href="${path}/item/toListAudit.do?auditStatus=1&showStatus=1"   title="已审核实体商品" class="nor">已审核</a>
    </span></h2>

    <form id="form1" name="form1" action="${path}/item/toListAudit.do" method="post">
        <input type="hidden" id="showStatus" name="showStatus" value="${qc.showStatus}" />
        <input type="hidden" id="auditStatus" name="auditStatus" value="${qc.auditStatus}" />
        <div class="sch">
            <input type="hidden" id="userSearch" name="userSearch" />
            <p>查询：
                <select id="brandId" name="brandId" value="">
                    <option value="">全部品牌</option>
                    <c:forEach items="${bList }" var="brand">
                        <option value="${brand.brandId }" <c:if test="${qc.brandId == brand.brandId}">selected</c:if>>${brand.brandName }</option>
                    </c:forEach>
                </select>
            </p></div>

        <table cellspacing="0" summary="" class="tab" id="myTable">
            <thead>
            <tr>
                <th>商品编号</th>
                <th class="wp">商品名称</th>
                <th>图片</th>
                <th>新品</th>
                <th>推荐</th>
                <th>特价</th>
                <th>上下架</th>
                <th>审核状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${page.list}">
                <tr>
                    <td>${item.itemNo}</td>
                    <td >${item.itemName }</td>
                    <td>
                        <img alt="" src="${upload_file_path}${item.imgs}" width="50" height="50">
                    </td>
                    <td>
                        <span class="is" <c:if test="${item.isNew == 1}"></c:if> ></span>
                    </td>
                    <td>
                        <span class="not" <c:if test="${item.isGood == 0}"></c:if> ></span>
                    </td>
                    <td>
                        <span class="not" <c:if test="${item.isHot == 0}"></c:if> ></span>
                    </td>
                    <td>
                        <span <c:if test="${item.showStatus == 1}">class='not'</c:if>></span>
                        <span <c:if test="${item.showStatus == 0}">class='is'</c:if>></span>
                    </td>
                    <td>
                        <c:if test="${item.auditStatus == 0}"><span>待审核</span></c:if>
                        <c:if test="${item.auditStatus == 1}"><span>通过</span></c:if>
                        <c:if test="${item.auditStatus == 2}"><span>未通过</span></c:if>

                    </td>
                    <td>
                        <a href="/ecps-console/shop/item/viewItem.jsp" title="查看">查看</a>
                        <c:if test="${item.auditStatus == 0 }">
                            <a href="javascript:void(0);" onclick="isPass(${item.itemId}, 1)">通过</a>
                            <a href="javascript:void(0);" onclick="isPass(${item.itemId}, 2)">未通过</a>
                        </c:if>
                        <c:if test="${item.auditStatus == 1 }">
                            <a href="javascript:void(0);">修改</a>
                            <a href="javascript:void(0);">删除</a>
                        </c:if>
                        <c:if test="${item.auditStatus == 2 }">
                            <a href="javascript:void(0);">修改</a>
                            <a href="javascript:void(0);">删除</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
            <tr>
                <td colspan="13" align="right">
                    选择：<a href="javascript:void(0);" title="全选" onclick="checkAllIds();">全选</a>
                    <samp>-</samp> <a href="javascript:void(0);" title="取消" onclick="uncheckAllIds();">取消</a>
                </td>
            </tr>
        </table>

        <div class="page_c">
        <span class="l inb_a">
            <input type="hidden" name="pageNo" id="pageNo"  value="1"/>
        </span>
            <span class="r page">
            <input type="hidden" value="${page.pageNo}" id="currentPageNo" name="currentPageNo" />
            <input type="hidden" value="${page.totalPage}" id="totalPage" name="totalPage" />
                               共<var id="pagePiece" class="orange">${page.totalPage}</var>条<var id="pageTotal">${page.pageNo}/${page.totalPage}</var>
            <a href="javascript:void(0);" id="first" class="hidden">首页</a>
            <a href="javascript:void(0);" id="prev" class="hidden">上一页</a>
            <a href="javascript:void(0);" id="next" class="hidden">下一页</a>
            <a href="javascript:void(0);" id="last" class="hidden">尾页</a>
        </span>
        </div>
    </form>
</div></div>
</body>