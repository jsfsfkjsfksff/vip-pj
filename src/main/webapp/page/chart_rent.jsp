<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>总业务量统计</title>
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
                    <li class="is-active"><a href="#" aria-current="page">总业务量统计</a></li>
                </ul>
            </nav>

            <div class="box" style="margin-bottom: 1rem;">
                <div class="field has-addons">
                    <div class="control">
                        <a class="button is-static">年份</a>
                    </div>
                    <div class="control is-expanded">
                        <input class="input" type="text" id="year" placeholder="请输入年份，例如 2025">
                    </div>
                    <div class="control">
                        <button type="button" class="button is-primary" onclick="getRentCount()">查询</button>
                    </div>
                </div>
            </div>

            <div class="box" style="background-color: var(--bg-color); border: 1px solid var(--border-color);">
                <div id="main" style="height: 500px"></div>
            </div>
        </div>
        <!-- jQuery -->
        <script src="/assets/js/jquery.min.js"></script>
        <!-- Echarts -->
        <script src="/assets/js/echarts.js"></script>
        <script type="text/javascript">
            function getRentCount() {
                let year = document.getElementById('year').value;
                // 基于准备好的dom，初始化echarts实例
                let mainEl = document.getElementById('main');
                // Dispose existing instance if any to avoid conflicts or memory leaks if called multiple times (though init usually handles it, good practice)
                let myChart = echarts.getInstanceByDom(mainEl);
                if (!myChart) {
                    myChart = echarts.init(mainEl);
                }

                $.ajax({
                    url: '/reportRent',
                    method: 'get',
                    data: {
                        year: year
                    },
                    success: function (res) {
                        let names = res.map(item => item.name);
                        let values = res.map(item => item.value);
                        // 指定图表的配置项和数据
                        let option = {
                            backgroundColor: 'transparent',
                            textStyle: {
                                color: '#ffffff'
                            },
                            title: {
                                text: '业务单量统计',
                                left: 'center',
                                textStyle: {
                                    color: '#ffffff',
                                    fontSize: 20
                                }
                            },
                            tooltip: {
                                trigger: 'axis'
                            },
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
                                    name: '业务单量',
                                    type: 'line',
                                    data: values,
                                    itemStyle: {
                                        color: '#ff0000'
                                    },
                                    lineStyle: {
                                        color: '#ff0000',
                                        width: 3
                                    },
                                    symbol: 'circle',
                                    symbolSize: 8
                                }
                            ]
                        };

                        // 使用刚指定的配置项和数据显示图表。
                        myChart.setOption(option);
                    }
                })
            }

            // Init with current year potentially, or wait for user input.
            // Let's default init empty or something nicely.
            // Or just let user click. User logic was click.
        </script>
    </body>

    </html>