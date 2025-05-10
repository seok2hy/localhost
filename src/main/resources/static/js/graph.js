var context = document
    .getElementById('myChart')
    .getContext('2d');

var context2 = document
    .getElementById('myChart2')
    .getContext('2d');

var context3 = document
    .getElementById('myChart3')
    .getContext('2d');

var context4 = document
    .getElementById('myChart4')
    .getContext('2d');

function getGraphData(year, typeIdx) {
    let resultData;
    $.ajax({url: "http://localhost/apis/count/year_and_type_accident.do?year=" + year + "&type=" + typeIdx,
        type: "GET",
        async: false,
        origin: "http://127.0.0.1:3000",
        success: function(result) {
            resultData = result;
            console.log(result);
        },
        error: function(e) {
            console.log(e);
        }
    });
    return resultData;
}
let data2012_1 = getGraphData(2012, 1);
let data2013_1 = getGraphData(2013, 1);
let data2014_1 = getGraphData(2014, 1);
let data2015_1 = getGraphData(2015, 1);
let data2016_1 = getGraphData(2016, 1);
let data2017_1 = getGraphData(2017, 1);
let data2018_1 = getGraphData(2018, 1);
let data2019_1 = getGraphData(2019, 1);
let data2020_1 = getGraphData(2020, 1);

var myChart = new Chart(context, {
    type: 'line',
    data: {
        labels: ['2012', '2013', '2014', '2015', '2016', '2017','2018','2019','2020'],
        datasets: [
            {
                label: '무단횡단',
                fill: false, // 선 그래프 아래 영역이 색으로 채워지는거
                data: [
                    data2012_1.accidentOccurCnt,
                    data2013_1.accidentOccurCnt,
                    data2014_1.accidentOccurCnt,
                    data2015_1.accidentOccurCnt,
                    data2016_1.accidentOccurCnt,
                    data2017_1.accidentOccurCnt,
                    data2018_1.accidentOccurCnt,
                    data2019_1.accidentOccurCnt,
                    data2020_1.accidentOccurCnt],
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1 // px
            }
        ]
    },
    options: {
        scales: {
            yAxes: [
                {
                    scaleLabel: {
                        display: true,
                        labelString: '발생 수', // y축 설명
                        fontSize: 15
                    },
                    ticks: {
                        beginAtZero: true
                    }
                }
            ],
            xAxes: [
                {
                    scaleLabel: {
                        display: true,
                        labelString: '년도', // x축 설명
                        fontSize: 15
                    }
                }
            ]
        }
    }
});

var myChart2 = new Chart(context2, {
    type: 'pie',
    data: {
        labels: ['2012', '2013', '2014', '2015', '2016', '2017','2018','2019','2020'],
        datasets: [
            {
                label: '무단횡단',
                fill: false, // 선 그래프 아래 영역이 색으로 채워지는거
                data: [
                    data2012_1.accidentOccurCnt,
                    data2013_1.accidentOccurCnt,
                    data2014_1.accidentOccurCnt,
                    data2015_1.accidentOccurCnt,
                    data2016_1.accidentOccurCnt,
                    data2017_1.accidentOccurCnt,
                    data2018_1.accidentOccurCnt,
                    data2019_1.accidentOccurCnt,
                    data2020_1.accidentOccurCnt],
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1 // px
            }
        ]
    },
    options: {
        scales: {
            yAxes: [
                {
                    scaleLabel: {
                        display: true,
                        labelString: '발생 수', // y축 설명
                        fontSize: 15
                    },
                    ticks: {
                        beginAtZero: true
                    }
                }
            ],
            xAxes: [
                {
                    scaleLabel: {
                        display: true,
                        labelString: '년도', // x축 설명
                        fontSize: 15
                    }
                }
            ]
        }
    }
});

var myChart3 = new Chart(context3, {
    type: 'bar',
    data: {
        labels: ['2012', '2013', '2014', '2015', '2016', '2017','2018','2019','2020'],
        datasets: [
            {
                label: '무단횡단',
                fill: false, // 선 그래프 아래 영역이 색으로 채워지는거
                data: [
                    data2012_1.accidentOccurCnt,
                    data2013_1.accidentOccurCnt,
                    data2014_1.accidentOccurCnt,
                    data2015_1.accidentOccurCnt,
                    data2016_1.accidentOccurCnt,
                    data2017_1.accidentOccurCnt,
                    data2018_1.accidentOccurCnt,
                    data2019_1.accidentOccurCnt,
                    data2020_1.accidentOccurCnt],
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1 // px
            }
        ]
    },
    options: {
        scales: {
            yAxes: [
                {
                    scaleLabel: {
                        display: true,
                        labelString: '발생 수', // y축 설명
                        fontSize: 15
                    },
                    ticks: {
                        beginAtZero: true
                    }
                }
            ],
            xAxes: [
                {
                    scaleLabel: {
                        display: true,
                        labelString: '년도', // x축 설명
                        fontSize: 15
                    }
                }
            ]
        }
    }
});

var myChart4 = new Chart(context4, {
    type: 'scatter',
    data: {
        labels: ['2012', '2013', '2014', '2015', '2016', '2017','2018','2019','2020'],
        datasets: [
            {
                label: '무단횡단',
                fill: false, // 선 그래프 아래 영역이 색으로 채워지는거
                data: [
                    data2012_1.accidentOccurCnt,
                    data2013_1.accidentOccurCnt,
                    data2014_1.accidentOccurCnt,
                    data2015_1.accidentOccurCnt,
                    data2016_1.accidentOccurCnt,
                    data2017_1.accidentOccurCnt,
                    data2018_1.accidentOccurCnt,
                    data2019_1.accidentOccurCnt,
                    data2020_1.accidentOccurCnt],
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1 // px
            }
        ]
    },
    options: {
        scales: {
            yAxes: [
                {
                    scaleLabel: {
                        display: true,
                        labelString: '발생 수', // y축 설명
                        fontSize: 15
                    },
                    ticks: {
                        beginAtZero: true
                    }
                }
            ],
            xAxes: [
                {
                    scaleLabel: {
                        display: true,
                        labelString: '년도', // x축 설명
                        fontSize: 15
                    }
                }
            ]
        }
    }
});


$(document).ready(function() {
    // 모든 그래프를 숨김
    var datasets = myChart.config.data.datasets;
    var datasets2 = myChart2.config.data.datasets;
    for (var i = 0; i < datasets.length; i++) {
        datasets[i].hidden = true;

    }
    myChart.update();

    $("a[data-filter='*']").click(function(e) {
        e.preventDefault();
        // 모든 그래프를 표시
        for (var i = 0; i < datasets.length; i++) {
            datasets[i].hidden = !datasets[i].hidden;
        }
        myChart.update();
    });
    
    $("a[data-filter='.web']").click(function(e) {
        e.preventDefault();
        datasets[0].hidden = !datasets[0].hidden;
        myChart.update();
    });

    $("a[data-filter='.photography']").click(function(e) {
        e.preventDefault();
        datasets[1].hidden = !datasets[1].hidden;
        myChart.update();
    });


    $("a[data-filter='.photography1']").click(function(e) {
        e.preventDefault();
        datasets[2].hidden = !datasets[2].hidden;
        myChart.update();
    });


    $("a[data-filter='.product']").click(function(e) {
        e.preventDefault();
        datasets[3].hidden = !datasets[3].hidden;
        myChart.update();
    });


    $("a[data-filter='.product1']").click(function(e) {
        e.preventDefault();
        datasets[4].hidden = !datasets[4].hidden;
        myChart.update();
    });
});
