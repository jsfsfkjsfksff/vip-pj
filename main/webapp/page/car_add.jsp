<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加业务</title>
    <!-- 引入 Bootstrap -->
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/admin.css">
</head>
<body>
<div class="page">
    <!-- 路径导航 -->
    <ol class="breadcrumb">
        <li>首页</li>
        <li class="active">添加业务</li>
    </ol>
    <!-- 新增表单 -->
    <form class="form-horizontal lg-form" action="<c:url value="/addCar"/>" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label class="control-label col-md-2">顾客姓名</label>
            <div class="col-md-10">
                <input type="text" class="form-control" name="carNumber">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">品牌</label>
            <div class="col-md-10">
                <input type="text" class="form-control" name="brand">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">类型</label>
            <div class="col-md-10">
                <select class="form-control" name="type">
                    <option value=""></option>
                    <option value="普通用户" >普通用户</option>
                    <option value="VIP用户" >VIP用户</option>
                    <option value="SVIP用户" >SVIP用户</option>
                </select>
            </div>
        </div>
<%--        <div class="form-group">--%>
<%--            <label class="control-label col-md-2">颜色</label>--%>
<%--            <div class="col-md-10">--%>
<%--                <input type="text" class="form-control" name="color">--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="form-group">
            <label class="control-label col-md-2">业务价格</label>
            <div class="col-md-10">
<%--                <input type="text" class="form-control" name="rentPrice">--%>
<%--                <div class="col-md-10">--%>

                    <select class="form-control" name="type">
                        <option value=""></option>
                        <option value="包月" >包月</option>
                        <option value="包季" >包季</option>
                        <option value="包年" >包年</option>
                    </select>
<%--                </div>--%>
            </div>
        </div>
<%--        <div class="form-group">--%>
<%--            <label class="control-label col-md-2">出租押金</label>--%>
<%--            <div class="col-md-10">--%>
<%--                <input type="text" class="form-control" name="deposit">--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="form-group">
            <label class="control-label col-md-2">业务状态</label>
            <div class="col-md-10">
                <select class="form-control" name="status">
                    <option value="未禁用">未禁用</option>
                    <option value="已禁用">已禁用</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">描述</label>
            <div class="col-md-10">
                <textarea class="form-control" rows="4" name="description"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">业务图片</label>
            <div class="col-md-10">
                <input type="file" class="form-control" name="picture">
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
