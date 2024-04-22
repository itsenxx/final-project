$(document).ready(function() {
    fetchProducts();
    $('#bomBtn').click(function() {
        submitBom();
    });
});

function fetchProducts() {
    $.ajax({
        url: '/selectMaterial',
        type: 'POST',
        success: function(data) {
            var bomTable = $('#bom_content table');
            $.each(data, function(index, product) {
                var row = $('<tr></tr>');
                row.append($('<td class="td1"><input style="zoom:1.5;" type="checkbox" name="" value="' + product.prodName + '"></td>'));
                row.append($('<td class="td2">' + (index + 1) + '</td>'));
                row.append($('<td class="td3">' + product.prodName + '</td>'));
                row.append($('<td class="td4"><input id="input_quan" type="number" name="quantity" value="0"></td>'));
                bomTable.append(row);
            });
        },
        error: function() {
            alert('제품 목록을 가져오는 데 실패했습니다.');
        }
    });
}

function submitBom() {
    var bomData = [];
    var isQuantityValid = true;
    $('#bom_content table tr').each(function() {
        var isChecked = $(this).find('input[type="checkbox"]').is(':checked');
        var quantity = parseInt($(this).find('input[name="quantity"]').val(), 10);
        if (isChecked && quantity > 0) {
            var prodName = $(this).find('input[type="checkbox"]').val();
            bomData.push({prodName: prodName, quantity: quantity});
        } else if (isChecked && quantity <= 0) {
            isQuantityValid = false;
        }
    });
    if(!isQuantityValid) {
        alert('선택된 제품의 수량은 0보다 커야 합니다.');
        return;
    }
    if (bomData.length > 0) {
        $.ajax({
            url: '/submitBom',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(bomData),
            success: function() {
                $('#bom_content table tr').each(function() {
                    $(this).find('input[type="checkbox"]').prop('checked', false);
                    $(this).find('input[name="quantity"]').val('0');
                });
                alert('등록을 완료했습니다.');
                location.reload;
            },
            error: function() {
                alert('등록을 처리하는 중 문제가 발생했습니다.');
            }
        });
    } else {
        alert('적어도 하나 이상의 제품을 선택해주세요.');
    }
}
