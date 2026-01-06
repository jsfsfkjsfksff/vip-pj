<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>首页</title>
    <!-- 引入 Bootstrap -->
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/admin.css">
</head>
<body>
<div class="index">
    <div class="header">
        <div class="logo">
            vip后台管理系统
        </div>
        <div class="dropdown settings">
            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
                系统设置 <span class="caret"></span>
            </button>
            <ul class="dropdown-menu dropdown-menu-right">
                <li><a href="<c:url value="/findChangePassword"/>" target="contentFrame">修改密码</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="<c:url value="/logout"/>">安全退出</a></li>
            </ul>
        </div>
    </div>
    <div class="main">
        <div class="nav">
            <div class="userinfo">当前用户：<span><c:if test ="${user != null}">welcome ${user.nickName}</c:if></span></div>
            <div class="nav-item"><a href="<c:url value="/findAllUser"/>" target="contentFrame"></span> 用户管理</a></div>
            <div class="nav-item"><a href="<c:url value="/findAllCustomer"/>" target="contentFrame"></span> 客户管理</a></div>
            <div class="nav-item"><a href="<c:url value="/findAllCar"/>" target="contentFrame"></span> 业务管理</a></div>
            <div class="nav-item"><a href="rent_car.html" target="contentFrame"></span> 核心客户</a></div>
            <div class="nav-item"><a href="rent.html" target="contentFrame"></span> 业务单</a></div>
            <div class="nav-item"><a href="back_add.html" target="contentFrame"></span> 业务周期</a></div>
            <div class="nav-item"><a href="back.html" target="contentFrame"></span> 入库单</a></div>
            <div class="nav-item"><a href="chart_gender.html" target="contentFrame"></span> vip性别统计</a></div>
            <div class="nav-item"><a href="chart_type.html" target="contentFrame"></span> 业务类型统计</a></div>
            <div class="nav-item"><a href="chart_rent.html" target="contentFrame"></span> 业务量统计</a></div>
        </div>
        <div class="content">
            <iframe name="contentFrame" frameborder="0"></iframe>
        </div>
    </div>
</div>
<!-- jQuery 和 Bootstrap JS -->
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>