<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>登录 - VIP后台管理系统</title>
            <!-- 引入 Bulma -->
            <link rel="stylesheet" href="/assets/bulma/css/bulma.min.css">
            <!-- 引入 Custom Admin Theme -->
            <link rel="stylesheet" href="/assets/css/admin.css">
            <!-- Font Awesome for icons -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
            <style>
                .login-container {
                    min-height: 100vh;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    flex-direction: column;
                    background-color: var(--bg-color);
                }

                .login-box {
                    width: 100%;
                    max-width: 400px;
                }
            </style>
        </head>

        <body>
            <div class="login-container">
                <div class="box login-box">
                    <h1 class="title has-text-centered mb-6">VIP后台管理系统</h1>

                    <form action="<c:url value='/login'/>" method="post">
                        <div class="field">
                            <label class="label">用户名</label>
                            <div class="control has-icons-left">
                                <input class="input is-medium" type="text" name="username" placeholder="请输入用户名">
                                <span class="icon is-small is-left">
                                    <i class="fas fa-user"></i>
                                </span>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">密码</label>
                            <div class="control has-icons-left">
                                <input class="input is-medium" type="password" name="password" placeholder="请输入密码">
                                <span class="icon is-small is-left">
                                    <i class="fas fa-lock"></i>
                                </span>
                            </div>
                        </div>

                        <div class="field mt-5">
                            <button type="submit" class="button is-primary is-fullwidth is-medium">
                                <span>登 录</span>
                                <span class="icon is-small">
                                    <i class="fas fa-arrow-right"></i>
                                </span>
                            </button>
                        </div>
                    </form>
                </div>

                <footer class="footer" style="background: transparent; padding: 2rem 1.5rem;">
                    <div class="content has-text-centered has-text-grey">
                        <p>
                            Copyright © SciAwe 2020-2025<br>
                            All Rights Reserved! 豫ICP备 63912345号
                        </p>
                    </div>
                </footer>
            </div>
        </body>

        </html>