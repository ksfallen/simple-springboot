<#assign basePath = Request.request.contextPath>

<#macro menu menu>
<aside class="LeftAside">
    <div style="height: 70px;">  </div>
    <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
        <li class="layui-nav-item <#if menu < 4>layui-nav-itemed</#if> ">
            <a href="javascript:">应用管理</a>
        <dl class="layui-nav-child">
        <dd <#if menu == 0>class="layui-this" </#if>><a href="${basePath}/app/show">应用</a></dd>
        <dd <#if menu == 1>class="layui-this" </#if>><a href="${basePath}/app/config">应用配置</a></dd>
        </dl>
        </li>

        <li class="layui-nav-item <#if (menu > 3 && menu < 6)> layui-nav-itemed </#if> ">
            <a href="javascript:">策略管理</a>
            <dl class="layui-nav-child">
                <dd <#if menu == 1>class="layui-this" </#if>><a href="${basePath}/app/policy">白名单</a></dd>
            </dl>
        </li>
    </ul>
</aside>
<script>
    layui.use('element', function(){
        var element = layui.element(); //导航的hover效果、二级菜单等功能，需要依赖element模块
        //监听导航点击
        element.on('nav(demo)', function(elem){
            console.log(elem);
            layer.msg(elem.text());
        });
    });
</script>
</#macro>
