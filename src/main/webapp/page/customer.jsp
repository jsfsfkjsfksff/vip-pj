<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>客户列表</title>
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
                        <li class="is-active"><a href="#" aria-current="page">客户列表</a></li>
                    </ul>
                </nav>

                <!-- 添加按钮 -->
                <div class="buttons">
                    <a class="button is-primary" href="<c:url value='/page/customer_add.jsp'/>">
                        <strong>添加客户</strong>
                    </a>
                </div>

                <!-- 表格 -->
                <div class="table-container">
                    <table class="table is-bordered is-striped is-hoverable is-fullwidth">
                        <thead>
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
                        </thead>
                        <tbody>
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
                                        <a href="<c:url value='/getCustomer?id=${customer.id}'/>"
                                            class="button is-small is-text">编辑</a>
                                        <a href="<c:url value='/deleteCustomer?id=${customer.id}'/>"
                                            class="button is-small is-text" onclick="return confirm('确定要删除吗?')">删除</a>
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
                        <li><span class="pagination-ellipsis">&hellip;</span></li>
                        <li><a class="pagination-link" aria-label="Goto page 5">5</a></li>
                    </ul>
                </nav>
            </div>
            <!-- jQuery Optional (not needed for Bulma usually unless for legacy scripts) -->
            <script src="/assets/js/jquery.min.js"></script>
        </body>

        </html>