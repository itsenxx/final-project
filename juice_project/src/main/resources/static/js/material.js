$(document).ready(function() {
    function selectMaterial() {
        $.ajax({
            url: '/purchase/selectMaterial',
            type: 'get',
            success: function(response) {
                var newOptions = '';
                $.each(response, function(index, material) {
                    newOptions += '<option value="' + material.materId + '">' + material.materName + '</option>';
                });
                $('#selectMaterial').html(newOptions);
                $('#selectMaterial').change(function() {
                    var selectedMaterialId = $(this).val();
                    selectSuppliers(selectedMaterialId);
                })
                $('#selectMaterial').trigger('change');
            },
            error: function(xhr, status, er) {
                console.log(er);
            }
        });
    }
    function selectSuppliers(materId) {
        $.ajax({
            url: '/purchase/selectSuppliers',
            type: 'get',
            data: {materId: materId},
            success: function(response) {
                var newOptions = '';
                $.each(response, function(index, suppliers) {
                    newOptions += '<option value="' + suppliers.suppId + '">' + suppliers.suppName + '</option>';
                });
                $('#selectSuppliers').html(newOptions);
            },
            error: function(xhr, status, er) {
                console.log(er);
            }
        });
    }
    $('#insertMaterName, #insertUnit').on('input', function() {
        var materName = $('#insertMaterName').val();
        var unit = $('#insertUnit').val();
        if (materName && unit) {
            $('#insertMaterial').prop('disabled', false);
        } else {
            $('#insertMaterial').prop('disabled', true);
        }
    });
    $('#insertMaterName, #insertUnit').on('change', function() {
        var materNameDisabled = $('#insertMaterName').prop('disabled');
        var unitDisabled = $('#insertUnit').prop('disabled');
        if (materNameDisabled || unitDisabled) {
            $('#insertMaterial').prop('disabled', true);
        }
    });
    $('#insertMaterial').click(function() {
        var materName = $('#insertMaterName').val();
        var unit = $('#insertUnit').val();
        $.ajax({
            url: '/purchase/insertMaterial',
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({materName: materName, unit: unit}),
            success: function() {
                alert('자재가 추가되었습니다.');
                insertMaterInventory(materName);
            }, error: function() {
                alert('자재 추가를 실패했습니다.');
            }
        });
    });
    function insertMaterInventory(materName) {
        $.ajax({
            url: '/purchase/insertMaterInventory',
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({materName: materName}),
            success:function() {
                location.reload();
            }, error: function() {
                console.log('er');
            }
        });
    }
    $('#quantity').on('input', function() {
        var quantity = $('#quantity').val();
        if (quantity && quantity % 10 === 0) {
            $('#insertBuy').prop('disabled', false);
        } else {
            $('#insertBuy').prop('disabled', true);
        }
    });
    $('#insertBuy').click(function() {
        var materId = $('#selectMaterial').val();
        var suppId = $('#selectSuppliers').val();
        var quantity = $('#quantity').val();
        $.ajax({
            url: '/purchase/insertBuy',
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({materId: materId, suppId: suppId, quantity: quantity}),
            success: function() {
                alert('주문이 완료되었습니다.');
                updateMaterInventory(materId, quantity);
            }, error: function() {
                alert('주문이 실패했습니다.');
            }
        });
    });
    function updateMaterInventory(materId, inventory) {
        $.ajax({
            url: '/purchase/updateMaterInventory',
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({materId: materId, inventory: inventory}),
            success: function() {
                location.reload();
            },
            error: function() {
                console.log('er');
            }
        });
    }
    function selectAllMaterial(){
        $.ajax({
            url: '/purchase/selectAllMaterial',
            type: 'get',
            success: function(response) {
                var newTableRows = '';
                $.each(response, function(index, allMaterial) {
                    var buttonLabel = allMaterial.condition === 1 ? '중지' : '재개';
                    var buttonClass = allMaterial.condition === 1 ? 'stop' : 'resume';
                    newTableRows += '<tr>' +
                                        '<td class="materId">' + allMaterial.materId + '</td>' +
                                        '<td class="materName">' + allMaterial.materName + '</td>' +
                                        '<td class="inventory">' + allMaterial.inventory + '</td>' +
                                        '<td class="buttonClass"><button class="' + buttonClass + '" data-mater-id="' + allMaterial.materId + '" data-condition="' + allMaterial.condition + '">' + buttonLabel +'</button></td>' +
                                    '</tr>';
                });
                $('#manager_tbody table').html(newTableRows);
            },
            error: function(xhr, status, er) {
                console.log(er);
            }
        });
    }
    $(document).on('click', '.stop, .resume', function() {
        var $button = $(this);
        var materId = $button.data('mater-id');
        var currentCondition = $button.data('condition');
        var newCondition = currentCondition === 1 ? 2 : 1;
        $.ajax({
            url: '/purchase/updateMaterialCondition',
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({materId: materId, condition: newCondition}),
            success: function() {
                alert('상태가 변경되었습니다.');
                selectAllMaterial();
                selectMaterial();
            },
            error: function() {
                console.log('실패했습니다.');
            }
        })
    })
    selectMaterial();
    selectAllMaterial();
});
