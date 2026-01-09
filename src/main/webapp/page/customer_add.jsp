<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>添加客户</title>
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
                        <li class="is-active"><a href="#" aria-current="page">添加客户</a></li>
                    </ul>
                </nav>

                <!-- 新增表单 -->
                <div class="form-box">
                    <h1 class="title has-text-centered">添加新客户</h1>
                    <form action="<c:url value='/addCustomer'/>" method="post">

                        <div class="field">
                            <label class="label">身份证</label>
                            <div class="control">
                                <input class="input" type="text" name="identity" placeholder="请输入身份证号">
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">姓名</label>
                            <div class="control">
                                <input class="input" type="text" name="customerName" placeholder="请输入姓名">
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">性别</label>
                            <div class="control">
                                <div class="select is-fullwidth">
                                    <select name="gender">
                                        <option value="" disabled selected>请选择性别</option>
                                        <option value="男性">男性</option>
                                        <option value="女性">女性</option>
                                        <option value="保密">保密</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">电话</label>
                            <div class="control">
                                <input class="input" type="text" name="phoneNumber" placeholder="请输入联系电话">
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">地址</label>
                            <div class="control">
                                <input class="input" type="text" name="address" placeholder="请输入联系地址">
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
            <!-- jQuery Optional -->
            <script src="/assets/js/jquery.min.js"></script>
        </body>

        </html>