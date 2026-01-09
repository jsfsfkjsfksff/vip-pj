<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>出租单列表</title>
                <!-- 引入 Bulma -->
                <link rel="stylesheet" href="/assets/bulma/css/bulma.min.css">
                <link rel="stylesheet" href="/assets/css/admin.css">
            </head>

            <body>
                <div class="page-container">
                    <!-- 路径导航 -->
                    <nav class="breadcrumb" aria-label="breadcrumbs">
                        <ul>
                            <li><a href="#">首页</a></li>
                            <li class="is-active"><a href="#" aria-current="page">出租单列表</a></li>
                        </ul>
                    </nav>

                    <!-- 表格 -->
                    <div class="table-container">
                        <table class="table is-bordered is-striped is-hoverable is-fullwidth">
                            <thead>
                                <tr>
                                    <th>开通单号</th>
                                    <th>品牌</th>
                                    <th>客户姓名</th>
                                    <th>禁用时间</th>
                                    <th>租用价格</th>
                                    <th>操作人</th>
                                    <th>租单状态</th>
                                    <th>创建时间</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="rent">
                                    <tr>
                                        <td>${rent.rentSn}</td>
                                        <td>${rent.brand}</td>
                                        <td>${rent.customerName}</td>
                                        <td>${rent.backDate}</td>
                                        <td>${rent.rentPrice}</td>
                                        <td>${rent.operName}</td>
                                        <td>${rent.status}</td>
                                        <td>
                                            <fmt:formatDate value="${rent.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                                        </td>
                                        <td>
                                            <fmt:formatDate value="${rent.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                                        </td>
                                        <td>
                                            <c:if test="${rent.status != '已入库'}">
                                                <div class="buttons are-small">
                                                    <a href="<c:url value='/deleteRent?id=${rent.id}&carId=${rent.carId}'/>"
                                                        class="button is-text"
                                                        onclick="return confirm('确定要撤销吗?')">撤销</a>
                                                </div>
                                            </c:if>
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