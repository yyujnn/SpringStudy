$(function () {

  console.log('파이차트 들어오니?',program_nm);
  
  $.ajax({
    url: 'getAgeData',
    dataType: 'json',
    data: {name : program_nm},
    success: function (res) {
      console.log(res);

      var data = [res.n10s_rt, res.n20s_rt, res.n30s_rt, res.n40s_rt, res.n50s_rt, res.n60s_above_rt];
   
      makeChart(data);
      // var로 선언한 함수 -> 호이스팅 (위에서 사용 가능)

    },
    error: function () {
      console.log("에러!");
    }

  })

})


var makeChart = function (data) {

  // 차트 만들기
  // Set new default font family and font color to mimic Bootstrap's default styling
  Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
  Chart.defaults.global.defaultFontColor = '#858796';

  // Pie Chart Example
  var ctx = document.getElementById("myPieChart");
  var myPieChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
      labels: ["10대", "20대", "30대", "40대", "50대", "60대 이상"],
      datasets: [{
        //data에 DB에서 조회한 값 가져오기
        data: data,
        backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc', '#4e73df', '#1cc88a', '#36b9cc'],
        hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf', '#2e59d9', '#17a673', '#2c9faf'],
        hoverBorderColor: "rgba(234, 236, 244, 1)",
      }],
    },
    options: {
      maintainAspectRatio: false,
      tooltips: {
        backgroundColor: "rgb(255,255,255)",
        bodyFontColor: "#858796",
        borderColor: '#dddfeb',
        borderWidth: 1,
        xPadding: 15,
        yPadding: 15,
        displayColors: false,
        caretPadding: 10,
      },
      legend: {
        display: false
      },
      cutoutPercentage: 80,
    },
  });
}
