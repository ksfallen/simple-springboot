<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<link rel="stylesheet" href="<%=path%>/static/css/global.css?v=2"/>
<script type="text/javascript" src="<%=path%>/static/js/libs/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/plugins.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/naviBar.js"></script>
<script type="text/javascript" src="<%=path%>/static/layui/layui.js" charset="utf-8"></script>

<link rel="stylesheet" href="<%=path%>/static/layui/css/layui.css" media="all">
