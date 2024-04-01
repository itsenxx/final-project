$(document).ready(function() {
    function selectEmployee() {
        $.ajax({
            url: '/personnel/selectEmployee',
            type: 'get',
            success: function(response) {
                var newTableRows = '';
                $.each(response, function(index, employee) {
                    newTableRows += '<tr>' +
                                        '<td>' + employee.empId + '</td>' +
                                        '<td>' + employee.empName + '</td>' +
                                        '<td>' + employee.phone + '</td>' +
                                        '<td>' + employee.address + '</td>' +
                                        '<td>' + employee.email + '</td>' +
                                        '<td>' + employee.depId + '</td>' +
                                        '<td>' + employee.position + '</td>' +
                                        '<td><a href="/personnel/modify">수정</a></td>' +
                                        '<td><a href="/personnel/delete">삭제</a></td>' +
                                    '</tr>';
                });
                $('.employee .t_body table').html(newTableRows);
            },
            error: function(xhr, status, er){
                console.log(er);
            }
        });
    }
    selectEmployee();
});
