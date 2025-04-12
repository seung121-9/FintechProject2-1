<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	function validateForm() {
		var id = document.getElementById("id").value;
		var pwd = document.getElementById("pwd").value;

		if (id === "" || pwd === "") {
			alert("아이디와 비밀번호를 모두 입력해주세요.");
			return false;
		}
		return true;
	}

	function deleteConfirm() {
		if (confirm("정말로 탈퇴하시겠습니까? 모든 정보가 삭제됩니다.")) {
			document.deleteForm.submit();
		}
	}
</script>
</head>
<body>
	<div class="container">
		<h1>회원 탈퇴</h1>
		<form name="deleteForm" action="${contextPath}/member/deleteMember.do" method="post" onsubmit="return validateForm()">
			<div class="form-group">
				<label for="id">아이디:</label>
				<input type="text" class="form-control" id="id" name="id" value="${sessionScope.loginId}" readonly>
			</div>
			<div class="form-group">
				<label for="pwd">비밀번호:</label>
				<input type="password" class="form-control" id="pwd" name="pwd">
			</div>
			<button type="button" class="btn btn-danger" onclick="deleteConfirm()">회원 탈퇴</button>
			<button type="button" class="btn btn-secondary" onclick="history.back()">취소</button>
		</form>
	</div>
</body>
</html>