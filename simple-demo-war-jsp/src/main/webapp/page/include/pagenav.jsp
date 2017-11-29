<%@ page session="false" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${pager!=null && (pager.count/pager.pageSize>0)}">
    <div style="margin-top: 20px;">
        <div id="pageDiv"></div>
    </div>
    <script>
        var page = Math.ceil('${pager.count/pager.pageSize}' * 1);
        var pageNum = '${pager.pageNum}';
        console.log(page);

        layui.use(['laypage', 'layer'], function () {
            var laypage = layui.laypage
                , layer = layui.layer;

            laypage({
                cont: 'pageDiv'
                , pages: page * 1
                , skip: true
                , curr: pageNum * 1
                , jump: function (obj, first) {
                    if (!first) {
                        $("#pageNum").val(obj.curr);
                        $("#fm").submit();
                    }
                }
            });
        });
    </script>
</c:if>
