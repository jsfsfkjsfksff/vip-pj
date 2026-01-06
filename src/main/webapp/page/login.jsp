<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <!-- 引入 Bootstrap -->
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/admin.css">
</head>
<body>
<div class="login">
    <form class="login-form" action="<c:url value="/login"/>" method="post">
        <div class="form-group login-header">
            <div>汽车租赁系统</div>
        </div>
        <div class="form-group input-group">
            <span class="input-group-addon"><img src="/assets/images/user.png"></span>
            <input type="text" name="username" class="form-control" placeholder="用户名">
        </div>
        <div class="form-group input-group">
            <span class="input-group-addon"><img src="/assets/images/lock.png"></span>
            <input type="password" name="password" class="form-control" placeholder="密码">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">登 录</button>
        </div>
    </form>
    <div class="footer">
        Copyright © 电子商务科技有限公司 2020-2025, All Rights Reserved! 豫ICP备 63912345号
    </div>
</div>
<!-- jQuery 和 Bootstrap JS -->
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
