<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html;charset=utf-8" language="java" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>业务列表</title>
            <!-- 引入 Bulma -->
            <link rel="stylesheet" href="/assets/bulma/css/bulma.min.css">
            <link rel="stylesheet" href="/assets/css/admin.css">
            <style>
                .car-img {
                    max-width: 80px;
                    max-height: 50px;
                    object-fit: cover;
                    border: 1px solid var(--border-color);
                }
            </style>
        </head>

        <body>
            <div class="page-container">
                <!-- 路径导航 -->
                <nav class="breadcrumb" aria-label="breadcrumbs">
                    <ul>
                        <li><a href="#">首页</a></li>
                        <li class="is-active"><a href="#" aria-current="page">业务列表</a></li>
                    </ul>
                </nav>

                <!-- 添加按钮 -->
                <div class="buttons">
                    <a class="button is-primary" href="<c:url value='/page/car_add.jsp'/>">
                        <strong>添加业务</strong>
                    </a>
                </div>

                <!-- 表格 -->
                <div class="table-container">
                    <table class="table is-bordered is-striped is-hoverable is-fullwidth">
                        <thead>
                            <tr>
                                <th>图片</th>
                                <th>客户姓名</th>
                                <th>品牌</th>
                                <th>类型</th>
                                <th>业务价格</th>
                                <th>业务状态</th>
                                <th>开通时间</th>
                                <th>禁止时间</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="vipc">
                                <tr>
                                    <td>
                                        <figure class="image">
                                            <img class="car-img"
                                                src="https://car-rent-pj-5580.obs.cn-east-5.myhuaweicloud.com/${vipc.picture}"
                                                alt="Car">
                                        </figure>
                                    </td>
                                    <td>${vipc.carNumber}</td>
                                    <td>${vipc.brand}</td>
                                    <td>${vipc.type}</td>
                                    <td>${vipc.rentType}</td>
                                    <td>${vipc.status}</td>
                                    <td>${vipc.createTime}</td>
                                    <td>${vipc.deadlineTime}</td>
                                    <td>
                                        <div class="buttons are-small">
                                            <a href="<c:url value='/getCar?id=${vipc.id}'/>"
                                                class="button is-text">编辑</a>
                                            <a href="<c:url value='/deleteCar?id=${vipc.id}'/>" class="button is-text"
                                                onclick="return confirm('确定要删除吗?')">删除</a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <!-- 分页 -->
                <nav class="pagination is-centered" role="navigation" aria-label="pagination">
                    <a class="pagination-previous">上一页</a>
                    <a class="pagination-next">下一页</a>
                    <ul class="pagination-list">
                        <li><a class="pagination-link is-current" aria-label="Page 1">1</a></li>
                        <li><a class="pagination-link" aria-label="Goto page 2">2</a></li>
                        <li><a class="pagination-link" aria-label="Goto page 3">3</a></li>
                    </ul>
                </nav>
            </div>
            <!-- jQuery -->
            <script src="/assets/js/jquery.min.js"></script>
        </body>

        </html>