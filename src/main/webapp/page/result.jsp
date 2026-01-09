<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%-- Created by IntelliJ IDEA. User: X Date: 2026/1/7 Time: 21:19 To change this template use File | Settings | File
        Templates. --%>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
            <html>

            <head>
                <title>结算界面</title>
                <!-- 引入 Bulma -->
                <link rel="stylesheet" href="/assets/bulma/css/bulma.min.css">
                <link rel="stylesheet" href="/assets/css/admin.css">
            </head>

            <body>
                <div class="page-container">
                    <div class="container" style="max-width: 600px; margin-top: 50px;">
                        <div class="box has-text-centered">
                            <h1 class="title is-3">结算确认</h1>

                            <div class="content is-medium">
                                <p><strong>客户等级：</strong> ${level}</p>
                                <p><strong>租用时长：</strong> ${type}</p>
                                <p class="mt-4" style="font-size: 1.5rem;">
                                    最终应付价格：
                                    <span style="color: var(--primary-color); font-weight: bold;">${finalPrice} 元</span>
                                </p>
                            </div>

                            <form action="<c:url value='/addRent'/>" method="post" class="mt-5">
                                <input type="hidden" name="rentPrice" value="${finalPrice}">
                                <input type="hidden" name="rentSn" value="${rentSn}">
                                <input type="hidden" name="carId" value="${carId}">
                                <input type="hidden" name="carNumber" value="${carNumber}">
                                <input type="hidden" name="customerId" value="${customerId}">

                                <div class="buttons is-centered">
                                    <button type="submit" class="button is-primary is-medium">确认办理</button>
                                    <button type="button" class="button is-light is-medium"
                                        onclick="history.back()">返回修改</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </body>

            </html>