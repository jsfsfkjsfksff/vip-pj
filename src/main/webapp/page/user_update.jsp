<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改用户</title>
    <!-- 引入 Bootstrap -->
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/admin.css">
</head>
<body>
<div class="page">
    <!-- 路径导航 -->
    <ol class="breadcrumb">
        <li>首页</li>
        <li class="active">修改用户</li>
    </ol>
    <!-- 修改表单 -->
    <form class="form-horizontal sm-form" action="<c:url value="/updateUser"/>" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label class="control-label col-md-2">账号</label>
            <div class="col-md-9">
                <input type="text" class="form-control" name="userName" readonly value="${user.userName}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">昵称</label>
            <div class="col-md-9">
                <input type="text" class="form-control" name="nickName" value="${user.nickName}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">邮箱</label>
            <div class="col-md-9">
                <input type="text" class="form-control" name="email" value="${user.email}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">手机</label>
            <div class="col-md-9">
                <input type="text" class="form-control" name="phoneNumber" value="${user.phoneNumber}">
            </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">确定</button>
            <button type="reset" class="btn btn-default">取消</button>
            <button type="button" class="btn btn-default" onclick="history.back();">返回</button>
        </div>
    </form>
</div>
<!-- jQuery 和 Bootstrap JS -->
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
