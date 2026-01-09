<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>修改用户</title>
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
                        <li class="is-active"><a href="#" aria-current="page">修改用户</a></li>
                    </ul>
                </nav>

                <!-- 修改表单 -->
                <div class="form-box">
                    <h1 class="title has-text-centered">修改用户信息</h1>
                    <form action="<c:url value='/updateUser'/>" method="post">
                        <input type="hidden" name="id" value="${user.id}">

                        <div class="field">
                            <label class="label">账号</label>
                            <div class="control">
                                <input class="input" type="text" name="userName" readonly value="${user.userName}"
                                    disabled>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">昵称</label>
                            <div class="control">
                                <input class="input" type="text" name="nickName" value="${user.nickName}">
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">邮箱</label>
                            <div class="control">
                                <input class="input" type="text" name="email" value="${user.email}">
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">手机</label>
                            <div class="control">
                                <input class="input" type="text" name="phoneNumber" value="${user.phoneNumber}">
                            </div>
                        </div>

                        <div class="field is-grouped is-grouped-centered" style="margin-top: 2rem;">
                            <div class="control">
                                <button type="submit" class="button is-primary">确定</button>
                            </div>
                            <div class="control">
                                <button type="reset" class="button is-light">取消</button>
                            </div>
                            <div class="control">
                                <button type="button" class="button is-text" onclick="history.back();">返回</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- jQuery -->
            <script src="/assets/js/jquery.min.js"></script>
        </body>

        </html>