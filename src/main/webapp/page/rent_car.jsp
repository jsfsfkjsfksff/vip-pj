<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>出租汽车列表</title>
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
                        <li class="is-active"><a href="#" aria-current="page">核心业务</a></li>
                    </ul>
                </nav>

                <!-- 表格 -->
                <div class="table-container">
                    <table class="table is-bordered is-striped is-hoverable is-fullwidth">
                        <thead>
                            <tr>
                                <th>图片</th>
                                <th>客户姓名</th>
                                <th>品牌</th>
                                <th>类型</th>
                                <th>出租价格</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="car">
                                <tr>
                                    <td>
                                        <figure class="image">
                                            <img class="car-img"
                                                src="https://car-rent-pj-5580.obs.cn-east-5.myhuaweicloud.com/${car.picture}"
                                                alt="Car">
                                        </figure>
                                    </td>
                                    <td>${car.carNumber}</td>
                                    <td>${car.brand}</td>
                                    <td>${car.type}</td>
                                    <td>${car.rentPrice}</td>
                                    <td>
                                        <a href="<c:url value='/preAddRent?carId=${car.id}'/>"
                                            class="button is-primary is-small is-outlined">开通</a>
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