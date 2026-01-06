<%--
  Created by IntelliJ IDEA.
  User: X
  Date: 2025/12/31
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改密码</title>
    <!-- 引入 Bootstrap -->
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/admin.css">
</head>
<body>
<div class="page">
    <!-- 路径导航 -->
    <ol class="breadcrumb">
        <li>首页</li>
        <li class="active">修改密码</li>
    </ol>
    <!-- 新增表单 -->
    <form class="form-horizontal sm-form" action="/changePassword" method="post">
        <div class="form-group" style="text-align: center; color: red;">
            ${error}
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">账号</label>
            <div class="col-md-9">
                <input type="text" class="form-control" name="username" readonly value="${sessionScope.user.userName}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">新密码</label>
            <div class="col-md-9">
                <input type="password" class="form-control" name="password">
            </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">提交</button>
        </div>
    </form>
</div>
<!-- jQuery 和 Bootstrap JS -->
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
