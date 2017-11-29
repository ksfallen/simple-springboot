<!DOCTYPE html>
<html>
<head>
    <title>列表</title>
    <#include "../include/common.ftl" />
    <@mate.head/>
</head>
<body>
<#include "../include/header.ftl" />

<#assign menuTitle = "策略管理" in mate>
<#assign menuInfo = "白名单" in mate>

<div class="wrap">
    <div class="leftShadow"></div>
    <@aside.menu menu=4 />
    <div class="mainRight">
        <@mate.navi/>
        <div class="mainCont">
            showPolicy
        </div>
    </div>
    <#--<div class="mainRight">-->
        <#--<jsp:include page="../include/navi.jsp"></jsp:include>-->
        <#--<div class="mainCont">-->
            <#--<div id="protocalExSearch">-->
                <#--<div class="layui-form-item">-->
                    <#--<form method="post" action="showAppInfo.do" id="fm" name="fm">-->
                        <#--<%--<input type="hidden" id="pageNum" name="pageNum" value="${paginator.pageNum}">--%>-->
                        <#--<%--<input type="hidden" id="pageSize" name="pageSize" value="${paginator.pageSize}">--%>-->
                        <#--<div class="layui-inline">-->
                            <#--<label class="layui-form-label">应用名称</label>-->
                            <#--<div class="layui-input-inline">-->
                                <#--<input type="txt" name="appName" value="${appName}" autocomplete="off" class="layui-input">-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<input class="layui-btn" type="submit" value="查询"/>-->
                        <#--<input class="layui-btn" type="button" onClick="addUser()" value="添加"/>-->
                        <#--<%--<input class="layui-btn" type="button" onClick="refreshApp()" value="同步应用"/>--%>-->
                    <#--</form>-->
                <#--</div>-->
                <#--<table class="layui-table" lay-even="" lay-skin="row">-->
                    <#--<%--<colgroup>--%>-->
                    <#--<%--<col width="120">--%>-->
                    <#--<%--<col width="120">--%>-->
                    <#--<%--<col width="120">--%>-->
                    <#--<%--<col width="150">--%>-->
                    <#--<%--</colgroup>--%>-->
                    <#--<thead>-->
                    <#--<tr>-->
                        <#--<th>应用名称</th>-->
                        <#--<th>应用简介</th>-->
                        <#--<%--<th>Tone中的应用Id</th>--%>-->
                        <#--<th>最后修改时间</th>-->
                        <#--<th>操作</th>-->
                    <#--</tr>-->
                    <#--</thead>-->
                    <#--<tbody>-->
                    <#--<c:choose>-->
                        <#--<c:when test="${resultList != null && resultList.size() > 0}">-->
                            <#--<c:forEach items="${resultList}" var="item" varStatus="st">-->
                                <#--<tr>-->
                                    <#--<td class="NAMECont">${item.appName}</td>-->
                                    <#--<td class="NAMECont">${item.appDesc}</td>-->
                                    <#--<%--<td class="NAMECont">${item.toneAppId}</td>--%>-->
                                    <#--<td><fmt:formatDate value="${item.stampDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>-->
                                    <#--<td class="IDCont">-->
                                        <#--<a href="<%=path%>/appInfo/editAppInfoPage.do?appInfoId=${item.appInfoId}">-->
                                            <#--<button class="layui-btn layui-btn-mini layui-btn-normal">编辑</button>-->
                                        <#--</a>-->
                                        <#--<a href="<%=path%>/appInfo/editAppConfigInfoPage.do?appInfoId=${item.appInfoId}&appName=${item.appName}">-->
                                            <#--<button class="layui-btn layui-btn-mini layui-btn-normal">灰度配置</button>-->
                                        <#--</a>-->
                                            <#--<%--<a href="<%=path%>/appInfo/editAppConfigInfoPage.do?appInfoId=${item.appInfoId}"><button class="layui-btn layui-btn-mini layui-btn-normal">删除</button></a>--%>-->
                                <#--</tr>-->
                            <#--</c:forEach>-->
                        <#--</c:when>-->
                        <#--<c:otherwise>-->
                            <#--<tr>-->
                                <#--<td colspan="11">无数据</td>-->
                            <#--</tr>-->
                        <#--</c:otherwise>-->

                    <#--</c:choose>-->
                    <#--</tbody>-->
                <#--</table>-->
                <#--<%@ include file="../include/pagenav.jsp" %>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
<#--</div>-->

<#--<%--<script type="text/javascript" src="/js/naviBar.js"></script>--%>-->
<#--<script>-->
    <#--function addUser() {-->
        <#--window.location.href = "editAppInfoPage.do";-->
    <#--}-->

    <#--function refreshApp() {-->
        <#--console.log("ddd")-->
        <#--$.ajax({-->
            <#--type: 'post',-->
            <#--url: 'refreshApps.do',-->
            <#--data: {},-->
            <#--dataType: "json",-->
            <#--success: function (msg) {-->
                <#--console.log(msg);-->
                <#--if (msg.errorNo == "0") {-->
                    <#--alert("成功同步" + msg.count + "条数据");-->
                    <#--window.location.reload();-->
                <#--}-->
                <#--else {-->
                    <#--alert(msg.errorInfo);-->
                <#--}-->
            <#--}-->
        <#--})-->
    <#--}-->

    <#--function clickPage(pageNum) {-->
        <#--$("#pageNum").val(pageNum);-->
        <#--document.fm.submit();-->
    <#--}-->

    <#--function deleteInfo(param) {-->
        <#--$.ajax({-->
            <#--type: 'post',-->
            <#--data: {userId: param},-->
            <#--url: '/deletePage.do',-->
            <#--dataType: "json",-->
            <#--success: function (msg) {-->
                <#--console.log(msg);-->
                <#--if (msg.errorNo == "0") {-->
                    <#--window.location.href = "/user.do";-->
                <#--}-->
                <#--else {-->
                    <#--alert(msg.errorInfo);-->
                <#--}-->
            <#--}-->
        <#--})-->
    <#--}-->
<#--</script>-->
</body>
</html>
