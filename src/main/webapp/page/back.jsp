<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>入库单列表</title>
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
                            <li class="is-active"><a href="#" aria-current="page">入库单列表</a></li>
                        </ul>
                    </nav>

                    <!-- 表格 -->
                    <div class="table-container">
                        <table class="table is-bordered is-striped is-hoverable is-fullwidth">
                            <thead>
                                <tr>
                                    <th>入库单号</th>
<%--                                    <th>入库时间</th>--%>
                                    <th>业务单号</th>
                                    <th>存在问题</th>
                                    <th>问题描述</th>
                                    <th>赔付金额</th>
                                    <th>操作人</th>
                                    <th>创建时间</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${list}" var="back">
                                    <tr>
                                        <td>${back.backSn}</td>
<%--                                        <td>--%>
<%--&lt;%&ndash;                                            <fmt:formatDate value="${back.returnDate}" pattern="yyyy-MM-dd" />&ndash;%&gt;--%>
<%--                                        </td>--%>
                                        <td>${back.rentSn}</td>
                                        <td>${back.problem}</td>
                                        <td>${back.description}</td>
                                        <td>${back.payMoney}</td>
                                        <td>${back.operName}</td>
                                        <td>
                                            <fmt:formatDate value="${back.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                                        </td>
                                        <td>
                                            <fmt:formatDate value="${back.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                                        </td>
                                        <td>
                                            <div class="buttons are-small">
                                                <a href="/deleteBack?id=${back.id}&rentId=${back.rentId}"
                                                    class="button is-text" onclick="return confirm('确定要撤销吗?')">撤销</a>
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