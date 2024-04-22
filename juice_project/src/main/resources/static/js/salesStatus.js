$(document).ready(function() {
    var salesChart;
    function initChart(chartData) {
        var ctx = document.getElementById('salesChart').getContext('2d');
        if(salesChart){
            salesChart.destroy();
        }
        salesChart = new Chart(ctx, {
            type: 'bar',
            data: chartData,
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    }
    function selectSalesData(type, month){
        $.ajax({
            url: '/development/selectSalesData',
            type: 'get',
            data: {type: type, month: month},
            success: function(response){
                if(type === 'monthly') {
                    labels = response.map(item => item.month + '월');
                } else if(type === 'product') {
                    labels = response.map(item => item.prodName);
                } else if(type === 'customer') {
                    labels = response.map(item => item.custName);
                }
                var data = response.map(item => item.totalQuantity);
                var chartData = {
                    labels: labels,
                    datasets: [{
                        label: '판매량',
                        data: data,
                        fill: false,
                        backgroundColor: 'rgba(0, 0, 0, 100)'
                    }]
                };
                initChart(chartData);
            },
            error: function(er){
                console.log(er);
            }
        });
    }
    $('#monthlySales').click(function() {
        $('#month').hide();
        selectSalesData('monthly', null);
    });
    $('#salesByProduct').click(function() {
        $('#month').show();
        $('#month').trigger('change', 'product');
    });
    $('#salesByCustomer').click(function() {
        $('#month').show();
        $('#month').trigger('change', 'customer');
    });
    $('#month').on('change', function(event, salesType) {
        var type = salesType || $('#month').data('lastType');
        var month = $(this).val();
        selectSalesData(type, month);
        $('#month').data('lastType', type);
    });
    selectSalesData('monthly', null);
});
