<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
    <h4><#if msg??>${msg}</#if></h4>
    <form action="" method="post">
        <p>账号：<input type="text" name="username" value="admin"/></p>
        <p>密码：<input type="text" name="password" value="123456"/></p>
        <p><input type="submit" value="登录"/></p>
    </form>
</body>
</html>
