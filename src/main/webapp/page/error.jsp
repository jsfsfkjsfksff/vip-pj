<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>错误</title>
            <!-- 引入 Bulma -->
            <link rel="stylesheet" href="/assets/bulma/css/bulma.min.css">
            <link rel="stylesheet" href="/assets/css/admin.css">
            <style>
                .error-container {
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    height: 100vh;
                }

                .error-box {
                    max-width: 500px;
                    width: 100%;
                    text-align: center;
                    border: 1px solid var(--primary-color);
                    background-color: var(--bg-color);
                    padding: 2rem;
                }

                .error-title {
                    color: var(--primary-color);
                    font-size: 1.5rem;
                    margin-bottom: 1rem;
                }
            </style>
        </head>

        <body>
            <div class="error-container">
                <div class="error-box">
                    <figure class="image is-64x64 is-inline-block mb-4">
                        <img src="<c:url value='/assets/images/red.png'/>" alt="Error Icon">
                    </figure>
                    <h1 class="error-title">OMG! 出错啦...</h1>
                    <p class="mb-5">${error}</p>
                    <button class="button is-primary is-outlined" onclick="history.back()">返回上一页</button>
                </div>
            </div>
        </body>

        </html>