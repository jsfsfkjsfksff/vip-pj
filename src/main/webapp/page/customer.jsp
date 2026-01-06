<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>客户列表</title>
    <!-- 引入 Bootstrap -->
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/admin.css">
</head>
<body>
<div class="page">
    <!-- 路径导航 -->
    <ol class="breadcrumb">
        <li>首页</li>
        <li class="active">客户列表</li>
    </ol>
    <div class="container-fluid">
        <!-- 添加按钮 -->
        <div class="save-btn">
            <a class="btn btn-primary" href="<c:url value="/page/customer_add.jsp"/>">添加客户</a>
        </div>
        <!-- 表格 -->
        <table class="table table-bordered table-striped table-hover">
            <tr>
                <th>ID</th>
                <th>身份证</th>
                <th>姓名</th>
                <th>性别</th>
                <th>电话</th>
                <th>创建时间</th>
                <th>更新时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${list}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.identity}</td>
                <td>${customer.customerName}</td>
                <td>${customer.gender}</td>
                <td>${customer.phoneNumber}</td>
                <td>${customer.createTime}</td>
                <td>${customer.updateTime}</td>
                <td>
                    <a href="<c:url value="/getCustomer?id=${customer.id}"/>" class="btn btn-link btn-xs">编辑</a>
                    <a href="<c:url value="/deleteCustomer?id=${customer.id}"/>" class="btn btn-link btn-xs" onclick="return confirm('确定要删除吗?')">删除</a>
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
