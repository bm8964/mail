// 전체 선택 체크박스를 클릭하면 다른 체크박스들도 선택/해제 되도록
function toggleSelectAll() {
    const selectAllCheckbox = document.getElementById('selectAll');
    const mailCheckboxes = document.querySelectorAll('.mailCheckbox');
    mailCheckboxes.forEach(checkbox => {
        checkbox.checked = selectAllCheckbox.checked;
    });

    toggleDeleteButton(); // 삭제 버튼 상태 업데이트
}

// 개별 체크박스를 클릭하면 삭제 버튼 활성화/비활성화
document.querySelectorAll('.mailCheckbox').forEach(checkbox => {
    checkbox.addEventListener('change', toggleDeleteButton);
});

// 삭제 버튼 활성화/비활성화
function toggleDeleteButton() {
    const mailCheckboxes = document.querySelectorAll('.mailCheckbox');
    const deleteButton = document.getElementById('deleteBtn');
    const anyChecked = Array.from(mailCheckboxes).some(checkbox => checkbox.checked);

    deleteButton.disabled = !anyChecked; // 체크된 메일이 하나라도 있으면 삭제 버튼 활성화
}

// 메일 삭제 버튼 클릭 시
document.getElementById('deleteBtn').addEventListener('click', function() {
    const mailCheckboxes = document.querySelectorAll('.mailCheckbox');
    mailCheckboxes.forEach((checkbox, index) => {
        if (checkbox.checked) {
            // 삭제된 메일은 테이블에서 제거
            checkbox.closest('tr').remove();
        }
    });
});
// 필터링 버튼 클릭 시 모달 열기
document.getElementById('openFilterModal').addEventListener('click', function() {
    document.getElementById('filterModal').style.display = 'block';
});

// 모달 닫기 버튼 클릭 시 모달 닫기
document.getElementById('closeModal').addEventListener('click', function() {
    document.getElementById('filterModal').style.display = 'none';
});

// 모달 외부 클릭 시 모달 닫기
window.addEventListener('click', function(event) {
    if (event.target === document.getElementById('filterModal')) {
        document.getElementById('filterModal').style.display = 'none';
    }
});
