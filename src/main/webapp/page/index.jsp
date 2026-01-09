<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>首页 - VIP后台管理系统</title>
            <!-- 引入 Bulma -->
            <link rel="stylesheet" href="/assets/bulma/css/bulma.min.css">
            <!-- 引入 Custom Admin Theme -->
            <link rel="stylesheet" href="/assets/css/admin.css">
            <!-- Font Awesome -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
            <style>
                body,
                html {
                    height: 100%;
                    overflow: hidden;
                }

                .main-layout {
                    display: flex;
                    flex-direction: column;
                    height: 100vh;
                }

                .top-navbar {
                    z-index: 30;
                }

                .workspace {
                    display: flex;
                    flex: 1;
                    overflow: hidden;
                    position: relative;
                }

                .sidebar {
                    width: 260px;
                    background-color: var(--bg-color);
                    border-right: 1px solid var(--border-color);
                    padding: 1.5rem;
                    overflow-y: auto;
                }

                .content-area {
                    flex: 1;
                    background-color: var(--bg-color);
                    position: relative;
                }

                iframe {
                    width: 100%;
                    height: 100%;
                    border: none;
                    background-color: var(--bg-color);
                }

                .user-panel {
                    border-bottom: 1px solid var(--border-color);
                    padding-bottom: 1rem;
                    margin-bottom: 1rem;
                }
            </style>
        </head>

        <body>
            <div class="main-layout">
                <!-- Top Navbar -->
                <nav class="navbar top-navbar" role="navigation" aria-label="main navigation">
                    <div class="navbar-brand">
                        <a class="navbar-item" href="#">
                            <span class="icon is-medium has-text-primary mr-2">
                                <i class="fas fa-crown fa-lg"></i>
                            </span>
                            <span class="title is-4" style="color: var(--text-color); letter-spacing: 1px;">VIP
                                SYSTEM</span>
                        </a>
                    </div>

                    <div class="navbar-menu">
                        <div class="navbar-end">
                            <div class="navbar-item has-dropdown is-hoverable">
                                <a class="navbar-link">
                                    <span class="icon mr-1"><i class="fas fa-cog"></i></span>
                                    系统设置
                                </a>
                                <div class="navbar-dropdown is-right is-boxed">
                                    <a class="navbar-item" href="<c:url value='/page/change_password.jsp'/>"
                                        target="contentFrame">
                                        <span class="icon mr-2"><i class="fas fa-key"></i></span> 修改密码
                                    </a>
                                    <hr class="navbar-divider" style="background-color: var(--border-color);">
                                    <a class="navbar-item has-text-primary" href="<c:url value='/logout'/>">
                                        <span class="icon mr-2"><i class="fas fa-sign-out-alt"></i></span> 安全退出
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>

                <!-- Main Workspace -->
                <div class="workspace">
                    <!-- Sidebar -->
                    <aside class="sidebar menu">
                        <div class="user-panel mb-5 has-text-centered">
                            <figure class="image is-64x64 is-inline-block mb-2">
                                <img class="is-rounded" src="/assets/images/user.png" alt="User"
                                    style="border: 2px solid var(--primary-color);">
                            </figure>
                            <p class="is-size-6" style="color: var(--text-color);">
                                <c:if test="${user != null}">Welcome, <span
                                        class="has-text-primary">${user.nickName}</span></c:if>
                                <c:if test="${user == null}">Hello, Guest</c:if>
                            </p>
                        </div>

                        <p class="menu-label">管理菜单</p>
                        <ul class="menu-list">
                            <li><a href="<c:url value='/findAllUser'/>" target="contentFrame"><i
                                        class="fas fa-users mr-2"></i>用户管理</a></li>
                            <li><a href="<c:url value='/findAllCustomer'/>" target="contentFrame"><i
                                        class="fas fa-address-book mr-2"></i>客户管理</a></li>
                            <li><a href="<c:url value='/findAllCar'/>" target="contentFrame"><i
                                        class="fas fa-car mr-2"></i>业务管理</a></li>
                            <li><a href="<c:url value='/findCarByStatus'/>" target="contentFrame"><i
                                        class="fas fa-star mr-2"></i>核心客户</a></li>
                            <li><a href="<c:url value='/findAllRent'/>" target="contentFrame"><i
                                        class="fas fa-file-invoice-dollar mr-2"></i>业务单</a></li>
                            <li><a href="<c:url value='/preAddBack'/>" target="contentFrame"><i
                                        class="fas fa-history mr-2"></i>业务周期</a></li>
                            <li><a href="<c:url value='/findAllBack'/>" target="contentFrame"><i
                                        class="fas fa-warehouse mr-2"></i>入库单</a></li>
                        </ul>

                        <p class="menu-label">数据报表</p>
                        <ul class="menu-list">
                            <li><a href="<c:url value='/page/chart_gender.jsp'/>" target="contentFrame"><i
                                        class="fas fa-venus-mars mr-2"></i>VIP性别统计</a></li>
                            <li><a href="<c:url value='/page/chart_type.jsp'/>" target="contentFrame"><i
                                        class="fas fa-chart-pie mr-2"></i>业务类型统计</a></li>
                            <li><a href="<c:url value='/page/chart_rent.jsp'/>" target="contentFrame"><i
                                        class="fas fa-chart-line mr-2"></i>业务量统计</a></li>
                        </ul>
                    </aside>

                    <!-- Content Area -->
                    <div class="content-area">
                        <!-- Direct welcome page or instruction if src is empty initially -->
                        <iframe name="contentFrame" src="<c:url value='/page/customer.jsp'/>"
                            allowtransparency="true"></iframe>
                    </div>
                </div>
            </div>
        </body>

        </html>