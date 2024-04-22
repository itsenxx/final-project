$(document).ready(function() {
    function selectProduct() {
        $.ajax({
            url: '/development/selectAllProduct',
            type: 'get',
            success: function(response) {
                var newOptions = '';
                $.each(response, function(index, product) {
                    newOptions += '<option value="' + product.prodId + '">' + product.prodName + '</option>';
                });
                $('#selectProduct').html(newOptions);
                $('#selectProduct').change(function() {
                    var selectedProductId = $(this).val();
                    selectMaterial(selectedProductId);
                });
                $('#selectProduct').trigger('change');
            },
            error: function(xhr, status, er) {
                console.log(er);
            }
        });
    }
    function selectMaterial(prodId) {
        $.ajax({
            url: '/development/selectMaterial',
            type: 'get',
            data: {prodId: prodId},
            dataType: 'json',
            success: function(response) {
                var newTableRows = '';
                $.each(response, function(index, bom) {
                    var checked = bom.content > 0 ? 'checked' : '';
                    newTableRows += '<tr>' +
                                        '<td><input type="checkbox" name="checkMaterial" value="' + bom.materId + '" ' + checked + '></td>' +
                                        '<td>' + (index + 1) + '</td>' +
                                        '<td>' + bom.materName + '</td>' +
                                        '<td><input id="updateBomContent" type="number" name="updateBomContent" value="' + bom.content + '"></td>' +
                                    '</tr>';
                });
                $('#selectMaterial_tbody table').html(newTableRows);
                selectAllBom();
            },
            error: function(xhr, status, er) {
                console.log(er);
            }
        });
    }
    $('#updateBomBtn').click(function() {
        var updateData = [];
        var prodId = $('#selectProduct').val();
        var isQuantityValid = true;
        $('#selectMaterial_tbody table tr').each(function() {
            var isChecked = $(this).find('input[type="checkbox"]').is(':checked');
            var content = parseInt($(this).find('input[name="updateBomContent"]').val(), 10);
            if (isChecked && content > 0) {
                var materId = $(this).find('input[type="checkbox"]').val();
                updateData.push({materId: materId, content: content});
            } else if (isChecked && content <= 0) {
                isQuantityValid = false;
            }
        });
        if(!isQuantityValid) {
            alert('선택된 자재의 수량은 0보다 커야 합니다.');
            return;
        }
        if (updateData.length > 0) {
            $.ajax({
                url: '/development/deleteBom',
                type: 'post',
                contentType: 'application/json',
                data: JSON.stringify({prodId: prodId}),
                success: function() {
                    insertBom(prodId, updateData);
                },
                error: function() {
                    alert('변경에 실패했습니다.');
                }
            });
        } else {
            alert('적어도 하나 이상의 제품을 선택해주세요.');
        }
    });
    function insertBom(prodId, updateData) {
        $.ajax({
            url: '/development/insertBom',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify({prodId: prodId, materials: updateData}),
            success: function() {
                alert('변경했습니다.');
                location.reload();
            },
            error: function() {
                alert('변경에 실패했습니다.');
            }
        });
    }
    function selectAllBom() {
        $.ajax({
            url: '/development/selectAllBom',
            type: 'get',
            success: function(response){
                var newTableRows = '';
                $.each(response, function(index, bom) {
                    newTableRows += '<tr>' +
                                        '<td>' + bom.prodName + '</td>' +
                                        '<td>' + bom.turn + '</td>' +
                                        '<td>' + bom.materName + '</td>' +
                                        '<td>' + bom.content + '</td>' +
                                    '</tr>';
                });
                $('#selectBom_tbody table').html(newTableRows);
            },
            error: function(xhr, status, er) {
                console.log(er);
            }
        });
    }
    selectProduct();
    selectAllBom();
});
