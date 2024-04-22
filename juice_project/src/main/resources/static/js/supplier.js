$(document).ready(function() {
    function selectSuppliers() {
        $.ajax({
            url: '/purchase/selectSuppliers2',
            type: 'get',
            success: function(response) {
                var newOptions = '';
                $.each(response, function(index, suppliers) {
                    newOptions += '<option value="' + suppliers.suppId + '">' + suppliers.suppName + '</option>';
                });
                $('#selectSuppliers').html(newOptions);
                $('#selectSuppliers').change(function() {
                    var selectedSuppliersId = $(this).val();
                    selectMaterial(selectedSuppliersId);
                })
                $('#selectSuppliers').trigger('change');
            },
            error: function(xhr, status, er) {
                console.log(er);
            }
        });
    }
    function selectMaterial(suppId) {
        $.ajax({
            url: '/purchase/selectMaterial2',
            type: 'get',
            data: {suppId: suppId},
            success: function(response) {
                var newOptions = '';
                $.each(response, function(index, material) {
                    newOptions += '<option value="' + material.materId + '">' + material.materName + '</option>';
                });
                $('#selectMaterial').html(newOptions);
            },
            error: function(xhr, status, er) {
                console.log(er);
            }
        });
    }
    // 입력 필드 값이 변경될 때마다 확인하여 버튼 상태 변경
    $('#insertSuppName, #insertPhoneNum, #insertAddress, #insertEmail').on('input', function() {
        var suppName = $('#insertSuppName').val();
        var phoneNum = $('#insertPhoneNum').val();
        var address = $('#insertAddress').val();
        var email = $('#insertEmail').val();

        // 입력 필드 중 하나라도 값이 없으면 버튼 비활성화
        if (!suppName || !phoneNum || !address || !email) {
            $('#insertSuppliers').prop('disabled', true); // 비활성화
        } else {
            $('#insertSuppliers').prop('disabled', false); // 활성화
        }
    });

    $('#insertSuppliers').click(function() {
        var suppName = $('#insertSuppName').val();
        var phoneNum = $('#insertPhoneNum').val();
        var address = $('#insertAddress').val();
        var email = $('#insertEmail').val();
        $.ajax({
            url: '/purchase/insertSuppliers',
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({suppName: suppName, phoneNum: phoneNum, address: address, email: email}),
            success: function() {
                alert('업체가 추가되었습니다.');
                location.reload();
            }, error: function() {
                alert('업체 추가를 실패했습니다.');
            }
        });
    });
    $('#insertSuppMater').click(function() {
        var materId = $('#selectMaterial').val();
        var suppId = $('#selectSuppliers').val();
        $.ajax({
            url: '/purchase/insertSuppMater',
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({materId: materId, suppId: suppId}),
            success: function() {
                alert('업체와 자재 연결이 완료되었습니다.');
                location.reload();
            }, error: function() {
                alert('연결이 실패했습니다.');
            }
        });
    });
    function selectAllSuppliers(){
        $.ajax({
            url: '/purchase/selectAllSuppliers',
            type: 'get',
            success: function(response) {
                var newTableRows = '';
                $.each(response, function(index, allSuppliers) {
                    var selectId = 'selectMaterialFor_' + allSuppliers.suppId;
                newTableRows += '<tr>' +
                    '<td class="suppId">' + allSuppliers.suppId + '</td>' +
                    '<td class="suppName">' + allSuppliers.suppName + '</td>' +
                    '<td class="phoneNum">' + allSuppliers.phoneNum + '</td>' +
                    '<td class="address">' + allSuppliers.address + '</td>' +
                    '<td class="email">' + allSuppliers.email + '</td>' +
                    '<td><select id="' + selectId + '" class="selectSupp"></select></td>' +
                    '<td class="createDate">' + allSuppliers.createDate + '</td>' +
                    '<td><button class="deleteSuppMater" data-supp-id="' + allSuppliers.suppId + '" data-select-id="' + selectId + '">연결 취소</button></td>' +
                '</tr>';
                });
                $('#manager_tbody table').html(newTableRows);
                response.forEach(function(supplier) {
                    selectMaterial3(supplier.suppId, 'selectMaterialFor_' + supplier.suppId);
                });
            },
            error: function(xhr, status, er) {
                console.log(er);
            }
        });
    }
    function selectMaterial3(suppId, selectId){
        $.ajax({
            url: '/purchase/selectMaterial3',
            type: 'get',
            data: {suppId: suppId},
            success: function(response) {
                var newOptions = '';
                $.each(response, function(index, mater) {
                    newOptions += '<option value="' + mater.materId + '">' + mater.materName + '</option>';
                });
                $('#' + selectId).html(newOptions);
            },
            error: function(xhr, status, er) {
                console.log(er);
            }
        });
    }
    $('#manager_tbody').on('click', '.deleteSuppMater', function() {
        var suppId = $(this).data('supp-id');
        var selectId = $(this).data('select-id');
        var materId = $('#' + selectId).val();
        $.ajax({
            url: '/purchase/deleteSuppMater',
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({suppId: suppId, materId: materId}),
            success: function() {
                alert('연결이 취소되었습니다.');
                location.reload();
            },
            error: function() {
                console.log('실패했습니다.');
            }
        });
    });
    selectSuppliers();
    selectAllSuppliers();
});
