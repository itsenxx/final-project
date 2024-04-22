// 유효성 검사: 제품 번호, 담당자 ID

$(document).ready(function(){
    var isValidProdId = false;

    // 제품번호 유효성 검사
    function checkProdId() {
        var prodId = $('#prod_id').val();
        if(prodId){
            $.ajax({
                url: '/production/checkProdId',
                type: 'GET',
                data: {prod_id: prodId},
                success: function(response) {
                    isValidProdId = response.isValid;
                    if(!isValidProdId){
                        alert('제품번호를 확인해 주세요.');
                        $('#prod_id').focus();
                    }
                    enableSubmitIfValid();
                },
                error: function(xhr, status, error) {
                    // 서버 오류 처리
                    console.error('서버 오류:', error);
                }
            });
        }
    }

    // 전송 버튼 활성화
    function enableSubmitIfValid() {
        if (isValidProdId) {
            $('#submitBtn').prop('disabled', false);
        } else {
            $('#submitBtn').prop('disabled', true);
        }
    }

    // 제품번호 입력값 변경 이벤트 핸들러
    $('#prod_id').change(function() {
        isValidProdId = false;
        checkProdId();
    });

    // 초기 로드 시 전송 버튼 비활성화
    $('#submitBtn').prop('disabled', true);
});