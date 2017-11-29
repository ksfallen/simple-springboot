<#-- @ftlvariable name="menuTitle" type="java.lang.String" -->
<#-- @ftlvariable name="menuInfo" type="java.lang.String" -->
<#-- @ftlvariable name="menuInfoBtn" type="java.lang.String" -->

<#assign basePath = Request.request.contextPath>

<#macro head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<link rel="stylesheet" href="${basePath}/static/css/global.css?v=2"/>
<link rel="stylesheet" href="${basePath}/static/layui/css/layui.css" media="all">
<script type="text/javascript" src="${basePath}/static/js/libs/jquery.js"></script>
<script type="text/javascript" src="${basePath}/static/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${basePath}/static/js/plugins.js"></script>
<script type="text/javascript" src="${basePath}/static/js/naviBar.js"></script>
<script type="text/javascript" src="${basePath}/static/layui/layui.js" charset="utf-8"></script>
</#macro>
