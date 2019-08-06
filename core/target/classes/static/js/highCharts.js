function showPie(data) {
    var chart = {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false
    };
    var title = {
        text: data.question
    };
    var tooltip = {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    };
    var plotOptions = {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}%</b>: {point.percentage:.1f} %',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            }
        }
    };
    var series= [{
        type: 'pie',
        name: 'Browser share',
        data: data.data
    }];
    var json = {};
    json.chart = chart;
    json.title = title;
    json.tooltip = tooltip;
    json.series = series;
    json.plotOptions = plotOptions;
    $('#view').highcharts(json);
}

function showBar(data) {
    var chart = {
        type: 'bar'
    };
    var title = {
        text: data.question
    };
    let content = '参加总人数: ' + data['totle']
    var subtitle = {
        text: data['question_type'] === '多选题' ? content : content + ', 平均分：' + data['avgGrade']
    };
    var xAxis = {
        categories: data.categories,
        title: {
            text: null
        }
    };
    var yAxis = {
        min: 0,
        title: {
            text: 'Source: 北京林业大学研究生院',
            align: 'high'
        },
        labels: {
            overflow: 'justify'
        }
    };
    var tooltip = {
        valueSuffix: ' 人'
    };
    var plotOptions = {
        bar: {
            dataLabels: {
                enabled: true
            }
        }
    };
    var legend = {
        layout: 'vertical',
        align: 'right',
        verticalAlign: 'top',
        x: -40,
        y: 100,
        floating: true,
        borderWidth: 1,
        backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
        shadow: true
    };
    var credits = {
        enabled: false
    };

    var series= [{
        data: data.data
    }
    ];

    var json = {};
    json.chart = chart;
    json.title = title;
    json.subtitle = subtitle;
    json.tooltip = tooltip;
    json.xAxis = xAxis;
    json.yAxis = yAxis;
    json.series = series;
    json.plotOptions = plotOptions;
    json.legend = legend;
    json.credits = credits;
    $('#view').highcharts(json);
}

function showAnswerList() {
    $('#view').html("暂无该题型统计");
}