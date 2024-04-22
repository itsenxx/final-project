$(document).ready(function() {
    $('#insertProduct').click(function() {
        var prodName = $('#insertProdName').val();
        var lotSize = $('#insertLotSize').val();
        var unit = $('#insertUnit').val();
        $.ajax({
            url: '/development/insertProduct',
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({prodName: prodName, lotSize: lotSize, unit: unit}),
            success: function() {
                alert('상품이 추가되었습니다.');
                insertProdInventory(prodName);
            }, error: function() {
                alert('상품 추가를 실패했습니다.');
            }
        });
    });
    function insertProdInventory(prodName) {
        $.ajax({
            url: '/development/insertProdInventory',
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({prodName: prodName}),
            success: function() {
                location.reload();
            }, error: function() {
                console.log('er');
            }
        });
    }
    function selectAllProduct() {
        $.ajax({
            url: '/development/selectAllProduct',
            type: 'get',
            success: function(response) {
                var newTableRows = '';
                $.each(response, function(index, allProduct) {
                    var buttonLabel = allProduct.condition === 1 ? '중지' : '재개';
                    var buttonClass = allProduct.condition === 1 ? 'stop' : 'resume';
                    newTableRows += '<tr>' +
                                        '<td>' + allProduct.prodId + '</td>' +
                                        '<td>' + allProduct.prodName + '</td>' +
                                        '<td>' + allProduct.inventory + '</td>' +
                                        '<td>' + allProduct.lotSize + '</td>' +
                                        '<td><button class="' + buttonClass + '" data-prod-id="' + allProduct.prodId + '" data-condition="' + allProduct.condition + '">' + buttonLabel + '</button></td>' +
                                    '</tr>';
                });
                $('#selectProduct_tbody table').html(newTableRows);
            },
            error: function(xhr, status, er){
                console.log(er);
            }
        });
    }
    $(document).on('click', '.stop, .resume', function() {
        var $button = $(this);
        var prodId = $button.data('prod-id');
        var currentCondition = $button.data('condition');
        var newCondition = currentCondition === 1 ? 2 : 1;
        $.ajax({
            url: '/development/updateProductCondition',
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({prodId: prodId, condition: newCondition}),
            success: function() {
                alert('상태가 변경되었습니다.');
                selectAllProduct();
            },
            error: function() {
                console.log('실패했습니다.');
            }
        });
    });
    selectAllProduct();
});
