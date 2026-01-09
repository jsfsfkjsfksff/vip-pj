<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>添加用户</title>
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
                        <li class="is-active"><a href="#" aria-current="page">添加用户</a></li>
                    </ul>
                </nav>

                <!-- Form -->
                <div class="form-box">
                    <h1 class="title has-text-centered">添加新用户</h1>
                    <form action="<c:url value='/addUser'/>" method="post">
                        <div class="field">
                            <label class="label">账号</label>
                            <div class="control has-icons-left">
                                <input class="input" type="text" name="userName" placeholder="登录账号">
                                <span class="icon is-small is-left">
                                    <i class="fas fa-id-badge"></i>
                                </span>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">昵称</label>
                            <div class="control has-icons-left">
                                <input class="input" type="text" name="nickName" placeholder="显示名称">
                                <span class="icon is-small is-left">
                                    <i class="fas fa-user-tag"></i>
                                </span>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">密码</label>
                            <div class="control has-icons-left">
                                <input class="input" type="password" name="password" placeholder="登录密码">
                                <span class="icon is-small is-left">
                                    <i class="fas fa-lock"></i>
                                </span>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">手机</label>
                            <div class="control has-icons-left">
                                <input class="input" type="text" name="phoneNumber" placeholder="联系电话">
                                <span class="icon is-small is-left">
                                    <i class="fas fa-mobile-alt"></i>
                                </span>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">邮箱</label>
                            <div class="control has-icons-left">
                                <input class="input" type="text" name="email" placeholder="example@email.com">
                                <span class="icon is-small is-left">
                                    <i class="fas fa-envelope"></i>
                                </span>
                            </div>
                        </div>

                        <div class="field is-grouped is-grouped-centered" style="margin-top: 2rem;">
                            <div class="control">
                                <button type="submit" class="button is-primary">提交</button>
                            </div>
                            <div class="control">
                                <button type="reset" class="button is-light">重置</button>
                            </div>
                            <div class="control">
                                <button type="button" class="button is-text" onclick="history.back();">返回</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </body>

        </html>