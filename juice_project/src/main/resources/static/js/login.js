$(document).ready(function(){
    var empId = localStorage.getItem('empId');
    var rememberCheck = localStorage.getItem('rememberCheck');
    if (empId) {
        $('#employeeId').val(empId);
    }
    if (rememberCheck === 'true') {
        $('#rememberId').prop('checked', true);
    } else {
        $('#rememberId').prop('checked', false);
    }
    $('#loginForm').submit(function() {
        if ($('#rememberId').is(':checked')) {
            localStorage.setItem('empId', $('#employeeId').val());
            localStorage.setItem('rememberCheck', 'true');
        } else {
            localStorage.removeItem('empId');
            localStorage.setItem('rememberCheck', 'false');
        }
    });
});
