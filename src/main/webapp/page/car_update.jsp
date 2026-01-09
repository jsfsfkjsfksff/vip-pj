<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html;charset=utf-8" language="java" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>修改业务</title>
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
                        <li class="is-active"><a href="#" aria-current="page">修改业务</a></li>
                    </ul>
                </nav>

                <!-- 修改表单 -->
                <div class="form-box">
                    <h1 class="title has-text-centered">修改业务信息</h1>
                    <form action="<c:url value='/updateCar'/>" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${car.id}">

                        <div class="field">
                            <label class="label">客户姓名</label>
                            <div class="control">
                                <input class="input" type="text" name="carNumber" value="${car.carNumber}">
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">品牌</label>
                            <div class="control">
                                <input class="input" type="text" name="brand" value="${car.brand}">
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">类型</label>
                            <div class="control">
                                <div class="select is-fullwidth">
                                    <select name="class">
                                        <option value="" <c:if test="${car.carCustomer.planType==''}">selected</c:if>>
                                        </option>
                                        <option value="p1" <c:if test="${car.carCustomer.planType=='p1'}">selected
                                            </c:if>>普通用户</option>
                                        <option value="p2" <c:if test="${car.carCustomer.planType=='p2'}">selected
                                            </c:if>>VIP用户</option>
                                        <option value="p3" <c:if test="${car.carCustomer.planType=='p3'}">selected
                                            </c:if>>SVIP用户</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">出租价格</label>
                            <div class="control">
                                <div class="select is-fullwidth">
                                    <select name="type">
                                        <option value="" <c:if test="${car.carCustomer.planLength==''}">selected</c:if>>
                                        </option>
                                        <option value="overMonth" <c:if
                                            test="${car.carCustomer.planLength=='overMonth'}">selected</c:if>>包月
                                        </option>
                                        <option value="overQuarter" <c:if
                                            test="${car.carCustomer.planLength=='overQuarter'}">selected</c:if>>包季
                                        </option>
                                        <option value="overYear" <c:if test="${car.carCustomer.planLength=='overYear'}">
                                            selected</c:if>>包年</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">业务状态</label>
                            <div class="control">
                                <div class="select is-fullwidth">
                                    <select name="status">
                                        <option value="未禁用" <c:if test="${car.status=='未禁止'}">selected</c:if>>未禁止
                                        </option>
                                        <option value="已禁用" <c:if test="${car.status=='已禁止'}">selected</c:if>>已禁止
                                        </option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">描述</label>
                            <div class="control">
                                <textarea class="textarea" name="description">${car.description}</textarea>
                            </div>
                        </div>

                        <div class="field">
                            <label class="label">当前图片</label>
                            <figure class="image is-128x128 mb-3">
                                <img src="<c:url value='https://car-rent-pj-5580.obs.cn-east-5.myhuaweicloud.com/${car.picture}'/>"
                                    alt="Car Image" style="object-fit: cover;">
                            </figure>
                        </div>

                        <div class="field">
                            <label class="label">上传新图片</label>
                            <div class="control">
                                <input class="input" type="file" name="pictureUrl">
                                <input type="hidden" name="oldPicture" value="${car.picture}">
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