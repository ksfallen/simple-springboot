<#assign basePath = request.contextPath>
<#include "../include/mate.ftl" />
<#import '../include/aside.ftl' as aside>

<@head/>

<#macro headtopertop>
<div class="headertop">
    <div style="font-size: 20px;color: #fff;float: left;padding-top: 20px;padding-left:20px;">管理平台</div>
    <div style="float: right;padding:15px 10px; color: #fff">
    <#--<c:if test="${userSession != null}">-->
    <#--${userSession.userName} / ${userSession.userId}-->
    <#--</c:if>-->
        <a id="inOut" href="${basePath}/logout.do">
            <button class="layui-btn layui-btn-primary">退出</button>
        </a>
    </div>
</div>
</#macro>

<#macro navi menuTitle menuInfo menuInfoBtn>
    <#setting classic_compatible=true>
    <div style="height: 70px;"></div>
    <div class="layui-breadcrumb" style="padding: 10px 0 10px 40px;border:1px solid #f5f5f5;">
        <a href="#">${menuTitle}</a>
        <a href="#"><cite>${menuInfo}</cite></a>
        <#if (menuInfoBtn?length > 0 )>
            <a><cite>${menuInfoBtn}</cite></a>
        </#if>
    </div>
</#macro>
