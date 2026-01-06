<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改车辆</title>
    <!-- 引入 Bootstrap -->
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/admin.css">
</head>
<body>
<div class="page">
    <!-- 路径导航 -->
    <ol class="breadcrumb">
        <li>首页</li>
        <li class="active">修改车辆</li>
    </ol>
    <!-- 新增表单 -->
    <form class="form-horizontal lg-form" action="<c:url value="/updateCar"/>" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${car.id}">
        <div class="form-group">
            <label class="control-label col-md-2">车牌号</label>
            <div class="col-md-10">
                <input type="text" class="form-control" name="carNumber" value="${car.carNumber}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">品牌</label>
            <div class="col-md-10">
                <input type="text" class="form-control" name="brand" value="${car.brand}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">类型</label>
            <div class="col-md-10">
                <select class="form-control" name="type">
                    <option value="" <c:if test="${car.type==''}">selected</c:if>></option>
                    <option value="轿车" <c:if test="${car.type=='轿车'}">selected</c:if>>轿车</option>
                    <option value="越野车" <c:if test="${car.type=='越野车'}">selected</c:if>>越野车</option>
                    <option value="商务车" <c:if test="${car.type=='商务车'}">selected</c:if>>商务车</option>
                    <option value="跑车" <c:if test="${car.type=='跑车'}">selected</c:if>>跑车</option>
                    <option value="面包车" <c:if test="${car.type=='面包车'}">selected</c:if>>面包车</option>
                </select>
            </div>
        </div>
<%--        <div class="form-group">--%>
<%--            <label class="control-label col-md-2">颜色</label>--%>
<%--            <div class="col-md-10">--%>
<%--                <input type="text" class="form-control" name="color" value="${car.color}">--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="form-group">
            <label class="control-label col-md-2">出租价格</label>
            <div class="col-md-10">
<%--                <input type="text" class="form-control" name="rentPrice" value="${car.rentPrice}">--%>
    <select class="form-control" name="type">
        <option value=""></option>
        <option value="包月" >包月</option>
        <option value="包季" >包季</option>
        <option value="包年" >包年</option>
    </select>
            </div>
        </div>
<%--        <div class="form-group">--%>
<%--            <label class="control-label col-md-2">出租押金</label>--%>
<%--            <div class="col-md-10">--%>
<%--                <input type="text" class="form-control" name="deposit" value="${car.deposit}">--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="form-group">
            <label class="control-label col-md-2">业务状态</label>
            <div class="col-md-10">
                <select class="form-control" name="status">
                    <option value="未禁止" <c:if test="car.status=='未禁止'">selected</c:if>>未禁止</option>
                    <option value="已禁止" <c:if test="car.status=='已禁止'">selected</c:if>>已禁止</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">描述</label>
            <div class="col-md-10">
                <textarea class="form-control" rows="4" name="description">${car.description}</textarea>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">业务图片</label>
            <div class="col-md-10">
                <img src="<c:url value="http://car-rent-pj.obs.cn-east-5.myhuaweicloud.com/${car.picture}"/>">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2">上传图片</label>
            <div class="col-md-10">
                <input type="file" class="form-control" name="pictureUrl">
                <input type="hidden" name="oldPicture" value="${car.picture}">
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
