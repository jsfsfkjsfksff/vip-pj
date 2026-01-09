<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>用户列表</title>
                <!-- 引入 Bulma -->
                <link rel="stylesheet" href="/assets/bulma/css/bulma.min.css">
                <!-- 引入 Admin Theme -->
                <link rel="stylesheet" href="/assets/css/admin.css">
                <!-- Font Awesome -->
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
            </head>

            <body>
                <div class="page-container">
                    <!-- Breadcrumb -->
                    <nav class="breadcrumb" aria-label="breadcrumbs">
                        <ul>
                            <li><a href="#">首页</a></li>
                            <li class="is-active"><a href="#" aria-current="page">用户列表</a></li>
                        </ul>
                    </nav>

                    <!-- Toolbar -->
                    <div class="buttons">
                        <a class="button is-primary" href="<c:url value='/page/user_add.jsp'/>">
                            <span class="icon is-small">
                                <i class="fas fa-plus"></i>
                            </span>
                            <strong>添加用户</strong>
                        </a>
                    </div>

                    <!-- Table -->
                    <div class="table-container">
                        <table class="table is-bordered is-striped is-hoverable is-fullwidth">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>账号</th>
                                    <th>昵称</th>
                                    <th>邮箱</th>
                                    <th>手机</th>
                                    <th>创建时间</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="user">
                                    <tr>
                                        <td>${user.id}</td>
                                        <td>${user.userName}</td>
                                        <td>${user.nickName}</td>
                                        <td>${user.email}</td>
                                        <td>${user.phoneNumber}</td>
                                        <td>
                                            <fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                                        </td>
                                        <td>
                                            <fmt:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                                        </td>
                                        <td>
                                            <div class="buttons are-small">
                                                <a href="<c:url value='/getUser?id=${user.id}'/>"
                                                    class="button is-text">编辑</a>
                                                <a href="<c:url value='/deleteUser?id=${user.id}'/>"
                                                    class="button is-text" onclick="return confirm('确定要删除吗?')">删除</a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <!-- Pagination -->
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
            </body>

            </html>