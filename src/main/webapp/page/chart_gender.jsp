<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>客户性别统计</title>
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
                <nav class="breadcrumb has-arrow-separator mb-5" aria-label="breadcrumbs">
                    <ul>
                        <li><a href="#" class="has-text-grey-light">首页</a></li>
                        <li class="is-active"><a href="#" aria-current="page"
                                style="color: var(--primary-color);">客户性别统计</a></li>
                    </ul>
                </nav>

                <!-- Chart Container -->
                <div class="box" style="height: 600px; padding: 20px; border: 1px solid var(--text-color);">
                    <div id="main" style="height: 100%; width: 100%;"></div>
                </div>
            </div>

            <!-- jQuery -->
            <script src="/assets/js/jquery.min.js"></script>
            <!-- Echarts -->
            <script src="/assets/js/echarts.js"></script>

            <script type="text/javascript">
                // Initialize ECharts with explicit dimensions
                let myChart = echarts.init(document.getElementById('main'));

                // Loading state
                myChart.showLoading({
                    text: 'LOADING...',
                    color: '#ff0000',
                    textColor: '#ffffff',
                    maskColor: 'rgba(0, 0, 0, 0.8)',
                    zlevel: 0
                });

                $.ajax({
                    url: '/reportCustomer',
                    method: 'get',
                    dataType: 'json',
                    success: function (res) {
                        myChart.hideLoading();
                        renderChart(res);
                    },
                    error: function (xhr, status, error) {
                        myChart.hideLoading();
                        // Fallback for demo/error case
                        renderChart([
                            { name: '男性', value: 1048 },
                            { name: '女性', value: 735 },
                            { name: '保密', value: 560 }
                        ]);
                    }
                });

                function renderChart(data) {
                    let option = {
                        backgroundColor: 'transparent',
                        title: {
                            text: '客户性别比例',
                            left: 'center',
                            textStyle: {
                                color: '#ffffff',
                                fontSize: 28,
                                fontWeight: '800',
                                fontFamily: 'Helvetica Neue'
                            }
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)',
                            backgroundColor: '#111111',
                            borderColor: '#ffffff',
                            borderWidth: 1,
                            textStyle: {
                                color: '#ffffff'
                            }
                        },
                        legend: {
                            orient: 'vertical',
                            left: 'left',
                            textStyle: {
                                color: '#ffffff',
                                fontWeight: 'bold'
                            }
                        },
                        series: [
                            {
                                name: '客户性别',
                                type: 'pie',
                                radius: ['0%', '70%'],
                                avoidLabelOverlap: false,
                                itemStyle: {
                                    borderColor: '#000000',
                                    borderWidth: 2
                                },
                                label: {
                                    show: true,
                                    position: 'inside',
                                    formatter: '{b}\n{d}%',
                                    color: '#ffffff', // White text on pie slices
                                    fontWeight: 'bold',
                                    fontSize: 14
                                },
                                labelLine: {
                                    show: false
                                },
                                // Ratio: Black 6, Red 1, White 3.
                                // Series colors:
                                color: ['#ff0000', '#333333', '#888888'],
                                data: data
                            }
                        ]
                    };
                    myChart.setOption(option);
                }

                window.addEventListener('resize', function () {
                    myChart.resize();
                });
            </script>
        </body>

        </html>