<%@ page session="false" pageEncoding="UTF-8" %>
<%--<%@ page import="com.tf56.opensso.auth.model.UserSession" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>

<div class="headertop">
    <div style="font-size: 20px;color: #fff;float: left;padding-top: 20px;padding-left:20px;">
        灰度配置平台
    </div>
    <div style="float: right;padding:15px 10px; color: #fff">
        <%--<c:if test="${userSession != null}">--%>
              <%--${userSession.userName} / ${userSession.userId}--%>
        <%--</c:if>--%>
        <a id="inOut" href="<%=path%>/logout.do">
            <button class="layui-btn layui-btn-primary">退出</button>
        </a>
    </div>
</div>
	
