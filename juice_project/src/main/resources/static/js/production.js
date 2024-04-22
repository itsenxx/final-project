$(document).ready(function(){

    var isValidEmpId = false;

    function selectProduction(){
        $.ajax({
            url: '/production/selectProduction',
            type: 'GET',
            contentType : "application/json; charset=utf-8",
            success: function(response){
                var newTableRows = '';
                $.each(response, function(index, production){
                    newTableRows += '<tr>' +
                                        '<td onClick="selectManuMater(' + production.lotNum + ', \'' + production.prodName + '\', ' + production.instAmt + ');">' + production.lotNum + '</td>' +
                                        '<td id="prod_name_'+ production.lotNum +'">' + production.prodName + '</td>' +
                                        '<td id="inst_amt_'+ production.lotNum +'">' + production.instAmt + '</td>' +
                                        '<td>' +
                                            '<input class="inputField" id="prod_amt_' + production.lotNum + '" name="prodAmt" type="number" placeholder="생산수량"/>' +
                                         '</td>' +
                                        '<td id="inst_date_'+ production.lotNum +'">' + production.instDate + '</td>' +
                                        '<td>' +
                                            '<input class="inputField" id="prod_date_'+ production.lotNum + '" name="prodDate" type="date" placeholder="생산일자"/>' +
                                        '</td>' +
                                        '<td>' +
                                            '<input class="inputField" id="emp_id_'+ production.lotNum +'" name="empId" type="text" placeholder="담당자 ID"/>' +
                                        '</td>' +
                                        '<td>' +
                                            '<button class="completeBtn" id="completion_' + production.lotNum + '" data-lot_num="' + production.lotNum + '" disabled>완료</button>' +
                                        '</td>' +
                                    '</tr>';
                });
                $('.table1 .contentM').html(newTableRows);
            },
            error: function(xhr, status, error){
                alert("Error: "+error);
            }
        });
    }
    function enableSubmitIfValid(lotNum){
        if(isValidEmpId){
            $('#completion_' + lotNum).prop('disabled', false);
        } else {
            $('#completion_' + lotNum).prop('disabled', true);
        }
    }
    function checkEmpId(lotNum, empId){
        if(empId){
            $.ajax({
                url: '/production/checkEmpId',
                type: 'GET',
                data: {emp_id: empId},
                success: function(response){
                    isValidEmpId = response.isValid;
                    if(!response.isValid){
                        alert('사원 번호를 확인해 주세요.');
                        $('#emp_id_'+ lotNum).focus();
                    }
                    enableSubmitIfValid(lotNum);
                },
                error: function(xhr, status, error){
                    console.log(error);
                }
            });
        }
    }

    $(document).on('change', '.inputField[type="number"]', function(){
        var $currentRow = $(this).closest('tr');
        var lotNum = $currentRow.find('.completeBtn').data('lot_num');
        var instAmt = parseInt($currentRow.find('#inst_amt_' + lotNum).text(), 10);
        var prodAmt = parseInt($currentRow.find('#prod_amt_' + lotNum).val(), 10);
    });

    $(document).on('change', '.inputField[type="date"]', function(){
        var $currentRow = $(this).closest('tr');
        var lotNum = $currentRow.find('.completeBtn').data('lot_num');
        var instDateStr = $currentRow.find('#inst_date_' + lotNum).text();
        var instDate = new Date(instDateStr);
        var prodDateStr = $currentRow.find('#prod_date_' + lotNum).val();
        var prodDate = new Date(prodDateStr);
    });

    $(document).on('change', '.inputField[type="text"]', function(){
        var $currentRow = $(this).closest('tr');
        var lotNum = $currentRow.find('.completeBtn').data('lot_num');
        var empId = $currentRow.find('#emp_id_' + lotNum).val();
        isValidEmpId = false;
        if(empId == 0 || empId === ''){
            alert('사원 번호를 확인해 주세요.');
            $('#emp_id_' + lotNum).focus();
            enableSubmitIfValid(lotNum);
        } else {
            checkEmpId(lotNum, empId);
        }
    });

    $(document).on('click', '.completeBtn', function(event){
        var $currentRow = $(this).closest('tr');
        var lotNum = $currentRow.find('.completeBtn').data('lot_num');
        var prodName = $currentRow.find('#prod_name_' + lotNum).text();
        var instAmt = parseInt($currentRow.find('#inst_amt_' + lotNum).text(), 10);
        var prodAmt = parseInt($currentRow.find('#prod_amt_' + lotNum).val(), 10);
        var output = parseInt($currentRow.find('#prod_amt_' + lotNum).val(), 10);
        var input = parseInt($currentRow.find('#prod_amt_' + lotNum).val(), 10);
        var prodDate = $currentRow.find('#prod_date_' + lotNum).val();
        var empId = parseInt($currentRow.find('#emp_id_' + lotNum).val(), 10);
        $.ajax({
            url: '/production/updateInstructions',
            type: 'POST',
            data: JSON.stringify({prodAmt: prodAmt, prodDate: prodDate, empId: empId, lotNum: lotNum}),
            contentType: "application/json; charset=utf-8",
            success: function(result, status, xhr){
                console.log("지시사항 업데이트 완료");
                updateProdInventory(input, prodName);
            },
            error: function(xhr, status, error){
                console.log(error);
            }
        });

        function updateProdInventory(input, prodName){
            $.ajax({
                url: '/production/updateProdInventory',
                type: 'POST',
                data: JSON.stringify({input: input, prodName: prodName}),
                contentType: "application/json; charset=utf-8",
                success: function(result, status, xhr){
                    console.log("생산량 재고에 반영");
                    updateMaterInventory();
                },
                error: function(xhr, status, error){
                    console.log(error);
                }
            });
        }

        function updateMaterInventory(){
            $.ajax({
                url: '/production/updateMaterInventory',
                type: 'POST',
                data: JSON.stringify({output: output, prodName: prodName}),
                contentType: "application/json; charset=utf-8",
                success: function(result, status, xhr){
                    console.log("자재량 재고에 반영");
                    deleteProduction();
                }
                ,error: function(xhr, status, error){
                    console.log(error);
                }
            });
        }

        function deleteProduction(){
            $.ajax({
                url: '/production/deleteProduction',
                type: 'POST',
                data: JSON.stringify({lotNum: lotNum}), // 속성 이름을 "lotNum"으로 수정
                contentType: "application/json; charset=utf-8",
                success: function(result, status, xhr){
                    console.log("지시사항 삭제 완료");
                    selectProduction();
                },
                error: function(xhr, status, error){
                    console.log(error);
                }
            });
        }
    });

    selectProduction();
});

function selectManuMater(lotNum, prodName, instAmt) {
    $.ajax({
        url: '/production/selectManuMater?lot_num=' + lotNum,
        type: 'GET',
        success: function(response) {
            var newTableRows = '';
            $.each(response, function(index, manuMater) {
                newTableRows += '<tr>' +
                                    '<td class="t3_1" id="mater_id_'+ manuMater.materId +'">'+ manuMater.materId +'</td>' + //자재번호
                                    '<td class="t3_2" id="mater_name_'+ manuMater.materId +'">' + manuMater.materName + '</td>' + //투입자재
                                    '<td class="t3_3" id="input_qut_'+ manuMater.materId +'">' + manuMater.inputQut + '</td>' + //표준수량
                                    '<td class="t3_4" id="inventory_'+ manuMater.materId +'">' + manuMater.inventory + '</td>' + //자재재고
                                '</tr>';
            });
            $('.table3 .T3_content').html(newTableRows);

                        $('#d1').text(lotNum);
                        $('#d2').text(prodName);
                        $('#d3').text(instAmt);
        },
        error: function(xhr, status, error) {
            console.log(error);
        }
    });
}
