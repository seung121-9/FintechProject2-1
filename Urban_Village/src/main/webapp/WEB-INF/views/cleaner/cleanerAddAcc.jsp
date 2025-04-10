<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>클리너 등록</title>
</head>
<body>
	<h1>비어있는 숙소 리스트</h1>

	<c:if test="${empty accListByCleanerNull}">
		<p>비어있는 숙소가 없습니다.</p>
	</c:if>

	<c:forEach var="acc" items="${accListByCleanerNull}" varStatus="status">
	<form action="${contextPath }/cleaner/addCleanerId.do" method="post">
	<div>
		숙소 ID: ${acc.accommodation_id} <br/>
		숙소 이름: ${acc.accommodation_name} <br/>
		청소 관리자: ${acc.cleaner_admin_id} 
		<input type="text" name="cleaner_admin_id" id="add_${status.index}">
		<input type="submit" value="이곳에 배정">
		<hr/>
	</div>
	</form>
</c:forEach>

</body>
<script>
document.addEventListener('DOMContentLoaded', function () {
    const member_id = localStorage.getItem('addAccMemberId');
    
    if (member_id) {
        // 모든 input 요소에 반복적으로 넣어줌
        document.querySelectorAll('input[id^="add_"]').forEach(input => {
            input.value = member_id;
        });
    }
});

</script>

</html>
