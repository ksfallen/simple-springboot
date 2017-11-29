<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    request.setAttribute("menu", "0");
    request.setAttribute("menuTitle", "应用管理");
    request.setAttribute("menuInfo", "应用列表");
%>
<!DOCTYPE html>
<html>
<head>
    <title>列表</title>
    <%@ include file="../include/meta.jsp" %>
</head>
<body>
<jsp:include page="../include/header.jsp"></jsp:include>

<div class="wrap">
    <div class="leftShadow"></div>
    <jsp:include page="../include/aside.jsp"/>

    <div class="mainRight">
        <jsp:include page="../include/navi.jsp"/>
        <div class="mainCont">
            <div id="protocalExSearch">
                <div class="layui-form-item">
                    <form method="post" action="showAppInfo.do" id="fm" name="fm">
                        <div class="layui-inline">
                            <label class="layui-form-label">应用名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="appName" value="${appName}" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <input class="layui-btn" type="submit" value="查询"/>
                        <input class="layui-btn" type="button" onClick="addUser()" value="添加"/>
                    </form>
                </div>

                <table class="layui-table" lay-even="" lay-skin="row">
                    <thead>
                    <tr>
                        <th>应用名称</th>
                        <th>应用简介</th>
                        <th>最后修改时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${resultList == null || resultList.size() == 0 }">
                            <tr>
                                <td colspan="11">无数据</td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${resultList}" var="item" varStatus="st">
                                <tr>
                                    <td>${item.appName}</td>
                                    <td>${item.appName}</td>
                                    <td><fmt:formatDate value="${item.stampDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                    <td>
                                        <a href="<%=path%>/appInfo/editAppInfoPage.do?appInfoId=${item.appInfoId}">
                                            <button class="layui-btn layui-btn-mini layui-btn-normal">编辑</button>
                                        </a>
                                        <a href="<%=path%>/appInfo/editAppConfigInfoPage.do?appInfoId=${item.appInfoId}&appName=${item.appName}">
                                            <button class="layui-btn layui-btn-mini layui-btn-normal">配置</button>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script>
    function addUser() {
        window.location.href = "editAppInfoPage.do";
    }

    function refreshApp() {
        $.ajax({
            type: 'post',
            url: 'refreshApps.do',
            data: {},
            dataType: "json",
            success: function (msg) {
                console.log(msg);
                if (msg.errorNo == "0") {
                    alert("成功同步" + msg.count + "条数据");
                    window.location.reload();
                }
                else {
                    alert(msg.errorInfo);
                }
            }
        })
    }

    function clickPage(pageNum) {
        $("#pageNum").val(pageNum);
        document.fm.submit();
    }

    function deleteInfo(param) {
        $.ajax({
            type: 'post',
            data: {userId: param},
            url: '/deletePage.do',
            dataType: "json",
            success: function (msg) {
                console.log(msg);
                if (msg.errorNo == "0") {
                    window.location.href = "/user.do";
                }
                else {
                    alert(msg.errorInfo);
                }
            }
        })
    }
</script>
</body>
</html>
