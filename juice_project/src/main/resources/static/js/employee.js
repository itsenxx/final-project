$(document).ready(function() {
    // 페이지 로드 시 직원 목록 불러오기
    selectEmployee();

    // 직원 목록 불러오기 함수
    function selectEmployee() {
        $.ajax({
            url: '/personnel/selectEmployee',
            type: 'get',
            success: function(response) {
                var newTableRows = '';
                $.each(response, function(index, employee) {
                    newTableRows += '<tr>' +
                                        '<td class="emp-id">' + employee.empId + '</td>' +
                                        '<td class="emp-name">' + employee.empName + '</td>' +
                                        '<td class="phone">' + employee.phone + '</td>' +
                                        '<td class="address">' + employee.address + '</td>' +
                                        '<td class="email">' + employee.email + '</td>' +
                                        '<td class="dep-id">' + employee.depName + '</td>' +
                                        '<td class="position">' + employee.position + '</td>' +
                                        '<td class="editButton"><button class="btn btn-info editBtn" data-empid="' + employee.empId + '">수정</button></td>' +
                                        '<td class="saveButtonContainer"></td>' +
                                        '<td class="deleteButton"><button class="btn btn-danger deleteButton" data-empid="' + employee.empId + '">삭제</button></td>' +
                                        '<td class="resetPassword"><button class="btn btn-danger resetPassword" data-empid="' + employee.empId + '">초기화</button></td>' +
                                    '</tr>';
                });
                $('#employee_tbody table').html(newTableRows);

            },
            error: function(xhr, status, er){
                console.log(er);
            }
        });
    }

    // 수정 버튼 클릭 시
    $('body').on('click', '.editBtn', function() {
        var $row = $(this).closest('tr'); // 클릭된 수정 버튼이 속한 행을 가져옴
        var empId = $(this).data('empid'); // 직원 ID를 가져옴

        // 기존 데이터를 수정할 수 있는 입력란으로 변경
        var empName = $row.find('.emp-name').text();
        var phone = $row.find('.phone').text();
        var address = $row.find('.address').text();
        var email = $row.find('.email').text();
        var depId = $row.find('.dep-id').text();
        var position = $row.find('.position').text();

        $row.find('.emp-name').html('<input type="text" class="form-control" value="' + empName + '">');
        $row.find('.phone').html('<input type="text" class="form-control" value="' + phone + '">');
        $row.find('.address').html('<input type="text" class="form-control" value="' + address + '">');
        $row.find('.email').html('<input type="text" class="form-control" value="' + email + '">');
        $row.find('.dep-id').html('<input type="text" class="form-control" value="' + depId + '">');
        $row.find('.position').html('<input type="text" class="form-control" value="' + position + '">');

        // 저장 버튼을 추가하여 수정된 데이터를 저장할 수 있도록 함
        var $saveButton = $('<button class="btn btn-success saveButton" data-empid="' + empId + '">저장</button>');
        $row.find('.saveButtonContainer').html($saveButton);

        // 수정 버튼을 비활성화하여 중복 클릭을 방지
        $(this).prop('disabled', true);
    });

    // 저장 버튼 클릭 시
    $('body').on('click', '.saveButton', function() {
        var $row = $(this).closest('tr'); // 클릭된 저장 버튼이 속한 행을 가져옴
        var empId = $(this).data('empid'); // 저장 버튼이 속한 행의 직원 ID를 가져옴
        var empName = $row.find('.emp-name input').val(); // 수정된 직원 이름을 가져옴
        var phone = $row.find('.phone input').val(); // 수정된 전화번호를 가져옴
        var address = $row.find('.address input').val(); // 수정된 주소를 가져옴
        var email = $row.find('.email input').val(); // 수정된 이메일을 가져옴
        var depId = $row.find('.dep-id input').val(); // 수정된 부서 ID를 가져옴
        var position = $row.find('.position input').val(); // 수정된 직책을 가져옴

        // AJAX 요청을 통해 수정된 데이터를 서버에 전송
        $.ajax({
            url: '/personnel/updateEmployee',
            type: 'POST',
            contentType: 'application/json', // Content-Type을 application/json으로 설정
            data: JSON.stringify({
                empId: empId,
                empName: empName,
                phone: phone,
                address: address,
                email: email,
                depId: depId,
                position: position
            }),
            success: function(result, status, xhr) {
                console.log('직원 정보 수정 성공');
                // 수정된 내용을 화면에 반영할 수 있는 추가적인 작업 수행
                // 예: 수정된 정보를 다시 테이블에 표시하는 등
                // 저장 버튼을 다시 수정 버튼으로 변경
                $row.find('.editButton').prop('disabled', false); // 수정 버튼 활성화
                $row.find('.saveButtonContainer').empty(); // 저장 버튼 제거
                $row.find('.emp-name').text(empName);
                $row.find('.phone').text(phone);
                $row.find('.address').text(address);
                $row.find('.email').text(email);
                $row.find('.dep-id').text(depId);
                $row.find('.position').text(position);
            },
            error: function(xhr, status, er) {
                console.error('직원 정보 수정 실패:', er);
                // 실패 시 사용자에게 알림을 표시하거나 다른 처리를 수행할 수 있음
            }
        });
    });

    // 직원 삭제 버튼 클릭 시
    $('body').on('click', '.deleteButton', function() {
        var empId = $(this).data('empid'); // 삭제 버튼의 직원 ID를 가져옴
        $.ajax({
            url: '/personnel/deleteEmployee',
            type: 'post',
            data: {empId: empId}, // 서버에 empId를 전달
            success: function(result, status, xhr){
                console.log("직원 삭제 성공");
                selectEmployee(); // 삭제 후 직원 목록을 다시 불러옴
            },
            error: function(xhr, status, er){
                console.log(er);
            }
        });
    });

    // 직원 추가 버튼 클릭 시
    $('#insertEmployee').on('click', function(){
        var empName = $('#empName').val();
        var phone = $('#phone').val();
        var address = $('#address').val();
        var email = $('#email').val();
        var depId = $('#depId').val();
        var position = $('#position').val();
        $.ajax({
            url: '/personnel/insertEmployee',
            type: 'post',
            data: JSON.stringify({empName: empName, phone: phone, address: address, email: email, depId: depId, position: position}),
            contentType: 'application/json; charset=utf-8',
            success: function(result, status, xhr){
                console.log("직원 추가 성공");
                $('input').val('');
                selectEmployee(); // 직원 추가 후 직원 목록을 다시 불러옴
            },
            error: function(xhr, status, er){
                console.log(er);
            }
        });
    });

    // 직원 비밀번호 초기화 버튼 클릭 시
    $('body').on('click', '.resetPassword', function() {
        var empId = $(this).data('empid'); // 비밀번호를 초기화할 직원의 ID를 가져옴
        $.ajax({
            url: '/personnel/resetPassword', // 비밀번호 초기화를 처리할 컨트롤러의 URL
            type: 'post',
            data: {empId: empId}, // 서버에 직원 ID를 전달
            success: function(result, status, xhr){
                console.log("비밀번호 초기화 성공");
                // 초기화 후 다시 직원 목록을 불러옴
                selectEmployee();
            },
            error: function(xhr, status, er){
                console.log("비밀번호 초기화 실패:", er);
            }
        });
    });

});