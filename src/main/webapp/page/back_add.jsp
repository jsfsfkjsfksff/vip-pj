<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>业务入库</title>
                <!-- 引入 Bulma -->
                <link rel="stylesheet" href="/assets/bulma/css/bulma.min.css">
                <link rel="stylesheet" href="/assets/css/admin.css">
                <style>
                    .info-panel {
                        background-color: var(--bg-color);
                        border: 1px solid var(--border-color);
                        padding: 1rem;
                        height: 100%;
                    }

                    .info-title {
                        color: var(--primary-color);
                        border-bottom: 2px solid var(--primary-color);
                        padding-bottom: 0.5rem;
                        margin-bottom: 1rem;
                        font-weight: bold;
                        font-size: 1.1rem;
                        text-transform: uppercase;
                    }
                </style>
            </head>

            <body>
                <div class="page-container">
                    <!-- 路径导航 -->
                    <nav class="breadcrumb" aria-label="breadcrumbs">
                        <ul>
                            <li><a href="#">首页</a></li>
                            <li class="is-active"><a href="#" aria-current="page">业务入库</a></li>
                        </ul>
                    </nav>

                    <!-- 查询表单 -->
                    <div class="box" style="margin-bottom: 2rem;">
                        <form action="/preAddBack" method="post">
                            <div class="field has-addons">
                                <div class="control is-expanded">
                                    <div class="select is-fullwidth">
                                        <select name="rentId">
                                            <option value="" disabled selected>请选择出租单...</option>
                                            <c:forEach items="${rentList}" var="r">
                                                <option value="${r.id}" <c:if test="${rent != null && rent.id == r.id}">
                                                    selected</c:if>>
                                                    ${r.rentSn} / ${r.carNumber} / ${r.customerName}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="control">
                                    <button type="submit" class="button is-primary">查询</button>
                                </div>
                            </div>
                        </form>
                    </div>

                    <c:if test="${rent != null && customer != null && car != null && backSn != null}">
                        <!-- 信息展示 Column Layout -->
                        <div class="columns is-multiline mb-6">
                            <div class="column is-4">
                                <div class="info-panel">
                                    <div class="info-title">客户信息</div>
                                    <table class="table is-fullwidth is-narrow" style="background:transparent;">
                                        <tr>
                                            <td><strong>客户姓名：</strong></td>
                                        </tr>
                                        <tr>
                                            <td>${customer.customerName}</td>
                                        </tr>
                                        <tr>
                                            <td><strong>身份证：</strong></td>
                                        </tr>
                                        <tr>
                                            <td>${customer.identity}</td>
                                        </tr>
                                        <tr>
                                            <td><strong>客户电话：</strong></td>
                                        </tr>
                                        <tr>
                                            <td>${customer.phoneNumber}</td>
                                        </tr>
                                        <tr>
                                            <td><strong>客户地址：</strong></td>
                                        </tr>
                                        <tr>
                                            <td>${customer.address}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div class="column is-4">
                                <div class="info-panel">
                                    <div class="info-title">业务信息</div>
                                    <table class="table is-fullwidth is-narrow" style="background:transparent;">
                                        <tr>
                                            <td><strong>业务号：</strong></td>
                                        </tr>
                                        <tr>
                                            <td>${car.carNumber}</td>
                                        </tr>
                                        <tr>
                                            <td><strong>品牌：</strong></td>
                                        </tr>
                                        <tr>
                                            <td>${car.brand}</td>
                                        </tr>
                                        <tr>
                                            <td><strong>业务类型：</strong></td>
                                        </tr>
                                        <tr>
                                            <td>${car.type}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div class="column is-4">
                                <div class="info-panel">
                                    <div class="info-title">出租单信息</div>
                                    <table class="table is-fullwidth is-narrow" style="background:transparent;">
                                        <tr>
                                            <td><strong>出租单号：</strong></td>
                                        </tr>
                                        <tr>
                                            <td>${rent.rentSn}</td>
                                        </tr>
                                        <tr>
                                            <td><strong>起租时间：</strong></td>
                                        </tr>
                                        <tr>
                                            <td>${rent.createTime}</td>
                                        </tr>
                                        <tr>
                                            <td><strong>禁用时间：</strong></td>
                                        </tr>
                                        <tr>
                                            <td>${rent.backDate}</td>
                                        </tr>
                                        <tr>
                                            <td><strong>出租价格：</strong></td>
                                        </tr>
                                        <tr>
                                            <td>${rent.rentPrice}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <!-- 新增表单 -->
                        <div class="form-box">
                            <h2 class="title is-4 has-text-centered mb-5">添加入库单</h2>
                            <form action="/addBack" method="post">
                                <div class="field">
                                    <label class="label">入库单号</label>
                                    <div class="control">
                                        <input class="input" type="text" name="backSn" readonly value="${backSn}">
                                    </div>
                                </div>

                                <div class="field">
                                    <label class="label">入库时间</label>
                                    <div class="control">
                                        <input class="input" type="date" name="returnDate" id="returnDate" readonly>
                                    </div>
                                </div>

                                <div class="field">
                                    <label class="label">出租单号</label>
                                    <div class="control">
                                        <input class="input" type="text" name="rentSn" readonly value="${rent.rentSn}">
                                    </div>
                                </div>

                                <input type="hidden" name="rentId" value="${rent.id}">

                                <div class="field">
                                    <label class="label">存在问题</label>
                                    <div class="control">
                                        <input class="input" type="text" name="problem" placeholder="如有问题请填写">
                                    </div>
                                </div>

                                <div class="field">
                                    <label class="label">赔付金额</label>
                                    <div class="control">
                                        <input class="input" type="text" name="payMoney" placeholder="0">
                                    </div>
                                </div>

                                <div class="field">
                                    <label class="label">问题描述</label>
                                    <div class="control">
                                        <textarea class="textarea" name="description" placeholder="详细描述问题情况"></textarea>
                                    </div>
                                </div>

                                <div class="field is-grouped is-grouped-centered" style="margin-top: 2rem;">
                                    <div class="control">
                                        <button type="submit" class="button is-primary">提交</button>
                                    </div>
                                    <div class="control">
                                        <button type="reset" class="button is-light">重置</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </c:if>
                </div>
                <!-- jQuery -->
                <script src="/assets/js/jquery.min.js"></script>
                <script type="text/javascript">
                    if (document.getElementById("returnDate")) {
                        document.getElementById("returnDate").valueAsDate = new Date();
                    }
                </script>
            </body>

            </html>