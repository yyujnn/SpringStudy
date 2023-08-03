// 비동기 통신 방식으로 월별 시청률 평균을 조회
// /getMonthData --> 데이터를 비동기 통신 요청 / 결과값 json data 반환
$(function () { // --> 페이지가 전부 로딩되고 난 다음 함수를 실행!
    console.log('차트 들어오니?',program_nm);
  $.ajax({
    url: 'getMonthData',
    dataType: 'json',
    data: {name : program_nm},
    success: function (res) {
      console.log("결과값 >> ", res);

      // labels : 배열 형태로 brdcst_de 값들을 넣어주기

      // 1) label이라는 배열 형태의 변수를 생성
      // 2) res의 모든 인덱스를 돌면서 (반복) 그 중 속성이 brdcst_de 값들을 꺼내서
      // 3) label 변수에 데이터 추가하기
    
      // data : 배열 형태로 wtchng_rt 값들을 넣어주기

      let label = [];
      let data = [];
      for(let i=0; i<res.length;i++){
        label.push(res[i].brdcst_de);
        data.push(res[i].wtchng_rt);
      }
      console.log(label);
      console.log(data);


      // 차트 만드는 코드
      // Set new default font family and font color to mimic Bootstrap's default styling
      Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
      Chart.defaults.global.defaultFontColor = '#858796';

      // Area Chart Example
      var ctx = document.getElementById("myAreaChart");
      var myLineChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: label,
          datasets: [{
            label: "Earnings",
            lineTension: 0.3,
            backgroundColor: "rgba(78, 115, 223, 0.05)",
            borderColor: "rgba(78, 115, 223, 1)",
            pointRadius: 3,
            pointBackgroundColor: "rgba(78, 115, 223, 1)",
            pointBorderColor: "rgba(78, 115, 223, 1)",
            pointHoverRadius: 3,
            pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
            pointHoverBorderColor: "rgba(78, 115, 223, 1)",
            pointHitRadius: 10,
            pointBorderWidth: 2,
            // data에 DB에서 조회한 값 가져오기
            data: data,
          }],
        },
        options: {
          maintainAspectRatio: false,
          layout: {
            padding: {
              left: 10,
              right: 25,
              top: 25,
              bottom: 0
            }
          },
          scales: {
            xAxes: [{
              time: {
                unit: 'date'
              },
              gridLines: {
                display: false,
                drawBorder: false
              },
              ticks: {
                maxTicksLimit: 7
              }
            }],
            yAxes: [{
              ticks: {
                maxTicksLimit: 5,
                padding: 10,
              },
              gridLines: {
                color: "rgb(234, 236, 244)",
                zeroLineColor: "rgb(234, 236, 244)",
                drawBorder: false,
                borderDash: [2],
                zeroLineBorderDash: [2]
              }
            }],
          },
          legend: {
            display: false
          },
          tooltips: {
            backgroundColor: "rgb(255,255,255)",
            bodyFontColor: "#858796",
            titleMarginBottom: 10,
            titleFontColor: '#6e707e',
            titleFontSize: 14,
            borderColor: '#dddfeb',
            borderWidth: 1,
            xPadding: 15,
            yPadding: 15,
            displayColors: false,
            intersect: false,
            mode: 'index',
            caretPadding: 10,
          }
        }
      });

    },
    error: function () {
      console.log("에러!");
    }
  })
})


