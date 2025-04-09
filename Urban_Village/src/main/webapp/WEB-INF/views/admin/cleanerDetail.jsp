<%-- <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>클리너 목록</title>
<body>
<h2>클리너 지원자 상세 정보</h2>
<table class="table">
    <tr><th>아이디</th><td>${cleaner.member_id}</td></tr>
    <tr><th>이름</th><td>${cleaner.memberName}</td></tr>
    <tr><th>전화번호</th><td>${cleaner.memberPhone}</td></tr>
    <tr><th>생년월일</th><td>${cleaner.memberBirth}</td></tr>
    <tr><th>성별</th><td>${cleaner.memberGender}</td></tr>
    <tr><th>주소</th><td>${cleaner.address}</td></tr>
    <tr><th>등록일</th><td>${cleaner.regdate}</td></tr>
    <tr><th>소득증빙자료</th>
        <td><a href="${contextPath}${cleaner.incomeProof}" target="_blank">파일보기</a></td>

    </tr>
</table>
</body>
</html> --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>클리너 상세 정보</title>
<style>
	body {
		font-family: '맑은 고딕', sans-serif;
		background-color: #fff;
		margin: 0;
		padding: 0;
	}
	.container {
		width: 70%;
		margin: 50px auto;
	}
	h2 {
		color: #d63384;
		border-bottom: 2px solid #d63384;
		padding-bottom: 10px;
		margin-bottom: 30px;
	}
	table {
		width: 100%;
		border-collapse: collapse;
	}
	th, td {
		border: 1px solid #f5c6cb;
		padding: 12px;
		text-align: left;
	}
	tr:nth-child(odd) {
		background-color: #fff0f3;
	}
	a {
		color: #d63384;
		text-decoration: none;
		font-weight: bold;
	}
	a:hover {
		text-decoration: underline;
	}
</style>
</head>
<body>

<div class="container">
	<h2>클리너 지원자 상세 정보</h2>

	<table class="table">
	    <tr><th>아이디</th><td>${cleaner.member_id}</td></tr>
	    <tr><th>이름</th><td>${cleaner.memberName}</td></tr>
	    <tr><th>전화번호</th><td>${cleaner.memberPhone}</td></tr>
	    <tr><th>생년월일</th><td>${cleaner.memberBirth}</td></tr>
	    <tr><th>성별</th><td>${cleaner.memberGender}</td></tr>
	    <tr><th>주소</th><td>${cleaner.address}</td></tr>
	    <tr><th>등록일</th><td>${cleaner.regdate}</td></tr>
	    <tr><th>소득증빙자료</th>
	        <td>
	        	<a href="${contextPath}${cleaner.incomeProof}" target="_blank">파일보기</a>
	        </td>
	    </tr>
	</table>
</div>

</body>
</html>

