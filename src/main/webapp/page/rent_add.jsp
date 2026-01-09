<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>汽车出租</title>
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
                        <li class="is-active"><a href="#" aria-current="page">汽车出租</a></li>
                    </ul>
                </nav>

                <!-- 新增表单 -->
                <div class="form-box">
                    <h1 class="title has-text-centered">创建出租单</h1>
                    <form action="<c:url value='/toCalculate'/>" method="post">

                        <div class="field">
                            <label class="label">出租单号</label>
                            <div class="control">
                                <input class="input" type="text" name="rentSn" readonly value="${rentSn}">
                            </div>
                        </div>

                        <input type="hidden" name="carId" value="${car.id}">

                        <div class="field">
                            <label class="label">品牌</label>
                            <div class="control">
                                <input class="input" type="text" name="carNumber" readonly value="${car.brand}">
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">客户</label>
                            <div class="control">
                                <div class="select is-fullwidth">
                                    <select name="customerId">
                                        <option value="" disabled selected>请选择客户</option>
                                        <c:forEach items="${customerList}" var="customer">
                                            <option value="${customer.id}">${customer.customerName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">客户等级</label>
                            <div class="control">
                                <div class="select is-fullwidth">
                                    <select name="clazz">
                                        <option value="" disabled selected>请选择客户等级</option>
                                        <option value="p1">普通用户</option>
                                        <option value="p2">VIP用户</option>
                                        <option value="p3">SVIP用户</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">到期时间</label>
                            <div class="control">
                                <div class="select is-fullwidth">
                                    <select name="type">
                                        <option value="" disabled selected>请选择租期类型</option>
                                        <option value="overMonth">包月</option>
                                        <option value="overQuarter">包季</option>
                                        <option value="overYear">包年</option>
                                    </select>
                                </div>
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