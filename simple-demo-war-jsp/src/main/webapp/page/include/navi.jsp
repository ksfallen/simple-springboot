<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="height: 70px;"></div>
<div class="layui-breadcrumb" style="padding: 10px 0 10px 40px;border:1px solid #f5f5f5;">
    <a href="/">${menuTitle}</a>
    <a href="#"><cite>${menuInfo}</cite></a>

    <c:if test="${menuInfoBtn != null}">
        <a><cite>${menuInfoBtn}</cite></a>
    </c:if>
</div>
