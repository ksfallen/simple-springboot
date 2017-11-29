<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>


<aside class="LeftAside">
    <div style="height: 70px;"></div>
    <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
        <li class="layui-nav-item <c:if test="${menu < 4}">layui-nav-itemed </c:if>">
            <a href="javascript:;">应用管理</a>
            <dl class="layui-nav-child">
                <dd <c:if test="${menu == 0}">class="layui-this" </c:if>><a href="<%=path%>/app/show">应用</a></dd>
                <dd <c:if test="${menu == 1}">class="layui-this" </c:if>><a href="<%=path%>/app/config">应用配置</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item <c:if test="${menu < 6 && menu>3}">layui-nav-itemed </c:if>">
            <a href="javascript:;">策略管理</a>
            <dl class="layui-nav-child">
                <dd <c:if test="${menu == 4}">class="layui-this" </c:if>><a href="<%=path%>/app/policy">白名单</a></dd>
            </dl>
        </li>
    </ul>
</aside>
<script>
    layui.use('element', function () {
        var element = layui.element(); //导航的hover效果、二级菜单等功能，需要依赖element模块
        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>
