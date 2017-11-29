<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    request.setAttribute("menu", "1");
    request.setAttribute("menuTitle", "应用管理");
    request.setAttribute("menuInfo", "应用配置列表");
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
                    应用配置列表
                </div>
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
