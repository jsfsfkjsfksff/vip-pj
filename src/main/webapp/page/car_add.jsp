<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html;charset=utf-8" language="java" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>添加业务</title>
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
                        <li class="is-active"><a href="#" aria-current="page">添加业务</a></li>
                    </ul>
                </nav>

                <!-- 新增表单 -->
                <div class="form-box">
                    <h1 class="title has-text-centered">添加新业务</h1>
                    <form action="<c:url value='/addCar'/>" method="post" enctype="multipart/form-data">

                        <div class="field">
                            <label class="label">顾客姓名</label>
                            <div class="control">
                                <input class="input" type="text" name="carNumber" placeholder="请输入顾客姓名">
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">品牌</label>
                            <div class="control">
                                <input class="input" type="text" name="brand" placeholder="请输入品牌">
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">类型</label>
                            <div class="control">
                                <div class="select is-fullwidth">
                                    <select name="class">
                                        <option value="" disabled selected>请选择类型</option>
                                        <option value="p1">普通用户</option>
                                        <option value="p2">VIP用户</option>
                                        <option value="p3">SVIP用户</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">业务价格</label>
                            <div class="control">
                                <div class="select is-fullwidth">
                                    <select name="type">
                                        <option value="" disabled selected>请选择业务价格</option>
                                        <option value="overMonth">包月</option>
                                        <option value="overQuarter">包季</option>
                                        <option value="overYear">包年</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">业务状态</label>
                            <div class="control">
                                <div class="select is-fullwidth">
                                    <select name="status">
                                        <option value="未禁用">未禁用</option>
                                        <option value="已禁用">已禁用</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">描述</label>
                            <div class="control">
                                <textarea class="textarea" name="description" placeholder="请输入描述信息"></textarea>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">业务图片</label>
                            <div class="control">
                                <input class="input" type="file" name="picture">
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
            <!-- jQuery -->
            <script src="/assets/js/jquery.min.js"></script>
        </body>

        </html>