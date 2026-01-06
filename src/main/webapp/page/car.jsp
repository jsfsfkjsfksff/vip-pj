<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>业务列表</title>
    <!-- 引入 Bootstrap -->
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/admin.css">
</head>
<body>
<div class="page">
    <!-- 路径导航 -->
    <ol class="breadcrumb">
        <li>首页</li>
        <li class="active">业务列表</li>
    </ol>
    <div class="container-fluid">
        <!-- 添加按钮 -->
        <div class="save-btn">
            <a class="btn btn-primary" href="<c:url value="/page/car_add.jsp"/>">添加业务</a>
        </div>
        <!-- 表格 -->
        <table class="table table-bordered table-striped table-hover">
            <tr>
                <th>图片</th>
                <th>客户姓名</th>
                <th>品牌</th>
                <th>类型</th>
<%--                <th>颜色</th>--%>
                <th>业务价格</th>
<%--                <th>定金</th>--%>
                <th>业务状态</th>
                <th>创建时间</th>
                <th>更新时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${list}" var="car">
            <tr>
                <td><img src="http://car-rent-pj.obs.cn-east-5.myhuaweicloud.com/${car.picture}"></td>
                <td>${car.carNumber}</td>
                <td>${car.brand}</td>
                <td>${car.type}</td>
<%--                <td>${car.color}</td>--%>
                <td>${car.rentPrice}</td>
<%--                <td>${car.deposit}</td>--%>
                <td>${car.status}</td>
                <td>${car.createTime}</td>
                <td>${car.updateTime}</td>
                <td>
                    <a href="<c:url value="/getCar?id=${car.id}"/>" class="btn btn-link btn-xs">编辑</a>
                    <a href="<c:url value="/deleteCar?id=${car.id}"/>" class="btn btn-link btn-xs" onclick="return confirm('确定要删除吗?')">删除</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <!-- 分页 -->
    <div class="container-fluid">
        <nav class="page-nav">
            <ul class="pagination">
                <li><a href="#"><span>上一页</span></a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#"><span>下一页</span></a></li>
            </ul>
        </nav>
    </div>
</div>
<!-- jQuery 和 Bootstrap JS -->
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
