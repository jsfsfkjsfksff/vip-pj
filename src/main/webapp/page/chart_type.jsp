<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>业务类型统计</title>
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
                    <li class="is-active"><a href="#" aria-current="page">业务类型统计</a></li>
                </ul>
            </nav>

            <div class="box" style="background-color: var(--bg-color); border: 1px solid var(--border-color);">
                <div id="main" style="height: 550px"></div>
            </div>
        </div>
        <!-- jQuery -->
        <script src="/assets/js/jquery.min.js"></script>
        <!-- Echarts -->
        <script src="/assets/js/echarts.js"></script>
        <script type="text/javascript">
            // 基于准备好的dom，初始化echarts实例
            let myChart = echarts.init(document.getElementById('main'));

            $.ajax({
                url: '/reportCar',
                method: 'get',
                success: function (res) {
                    let names = res.map(item => item.name);
                    let values = res.map(item => item.value);
                    // 指定图表的配置项和数据
                    let option = {
                        backgroundColor: 'transparent',
                        textStyle: {
                            color: '#ffffff'
                        },
                        //标题
                        title: {
                            text: 'VIP类型统计',
                            left: 'center',
                            textStyle: {
                                color: '#ffffff',
                                fontSize: 20
                            }
                        },
                        //提示框
                        tooltip: {
                            axisPointer: {
                                type: 'shadow'
                            }
                        },
                        //x轴,水平轴,类目轴
                        xAxis: {
                            type: 'category',
                            data: names,
                            axisLine: {
                                lineStyle: {
                                    color: '#ffffff'
                                }
                            },
                            axisLabel: {
                                color: '#ffffff'
                            }
                        },
                        //y轴,垂直轴,数据轴
                        yAxis: {
                            name: '数量',
                            type: 'value',
                            minInterval: 1,
                            splitLine: {
                                lineStyle: {
                                    color: 'rgba(255, 255, 255, 0.1)'
                                }
                            },
                            axisLine: {
                                lineStyle: {
                                    color: '#ffffff'
                                }
                            },
                            axisLabel: {
                                color: '#ffffff'
                            }
                        },
                        series: [
                            {
                                name: 'VIP类型',
                                type: 'bar',
                                data: values,
                                itemStyle: {
                                    color: '#ff0000'
                                }
                            }
                        ]
                    };

                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                }
            });

            window.addEventListener('resize', function () {
                myChart.resize();
            });
        </script>
    </body>

    </html>