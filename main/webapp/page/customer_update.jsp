<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改客户</title>
    <!-- 引入 Bootstrap -->
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/admin.css">
</head>
<body>
<div class="page">
    <!-- 路径导航 -->
    <ol class="breadcrumb">
        <li>首页</li>
        <li class="active">修改客户</li>
    </ol>
    <!-- 修改表单 -->
    <form class="form-horizontal sm-form" action="<c:url value="/updateCustomer"/>" method="post">
        <input type="hidden" name="id" value="${customer.id}">
        <div class="form-group">
            <label class="control-label col-md-2">身份证</label>
            <div class="col-md-9">
                <input type="text" class="form-control" name="identity" value="${customer.identity}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">姓名</label>
            <div class="col-md-9">
                <input type="text" class="form-control" name="customerName" value="${customer.customerName}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">性别</label>
            <div class="col-md-9">
                    <select class="form-control" name="gender">
                        <option value=""></option>
                        <option value="男性" <c:if test="${customer.gender == '男性'}">selected</c:if>>男性</option>
                        <option value="女性" <c:if test="${customer.gender == '女性'}">selected</c:if>>女性</option>
                        <option value="保密" <c:if test="${customer.gender == '保密'}">selected</c:if>>保密</option>
                    </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">电话</label>
            <div class="col-md-9">
                    <input type="text" class="form-control" name="phone" value="${customer.phoneNumber}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">地址</label>
            <div class="col-md-9">
                    <input type="text" class="form-control" name="address" value="${customer.address}">
            </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">提交</button>
            <button type="reset" class="btn btn-default">重置</button>
            <button type="button" class="btn btn-default" onclick="history.back();">返回</button>
        </div>
    </form>
</div>
<!-- jQuery 和 Bootstrap JS -->
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
