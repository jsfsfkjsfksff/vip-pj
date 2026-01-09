<%-- Created by IntelliJ IDEA. User: X Date: 2025/12/31 Time: 19:55 To change this template use File | Settings | File
    Templates. --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>修改密码</title>
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
                        <li class="is-active"><a href="#" aria-current="page">修改密码</a></li>
                    </ul>
                </nav>

                <div class="container" style="max-width: 500px; margin-top: 50px;">
                    <div class="box form-box">
                        <h2 class="title is-4 has-text-centered mb-5">修改登录密码</h2>

                        <div style="text-align: center; color: var(--primary-color); margin-bottom: 1rem;">
                            ${error}
                        </div>

                        <form action="/changePassword" method="post">
                            <div class="field">
                                <label class="label">账号</label>
                                <div class="control">
                                    <input class="input" type="text" name="username" readonly
                                        value="${sessionScope.user.userName}" disabled>
                                </div>
                            </div>

                            <div class="field">
                                <label class="label">新密码</label>
                                <div class="control">
                                    <input class="input" type="password" name="password" placeholder="请输入新密码">
                                </div>
                            </div>

                            <div class="field mt-5">
                                <div class="control">
                                    <button type="submit" class="button is-primary is-fullwidth">提交修改</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- jQuery -->
            <script src="/assets/js/jquery.min.js"></script>
        </body>

        </html>