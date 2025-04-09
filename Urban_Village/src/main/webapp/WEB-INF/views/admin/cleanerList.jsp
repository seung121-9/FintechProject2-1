<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>클리너 지원자 목록</title>
<style>
	body {
		font-family: '맑은 고딕', sans-serif;
		background-color: #fff;
		margin: 0;
		padding: 0;
	}
	.container {
		width: 70%;
		margin: 50px auto; /* 가운데 정렬 + 상하 여백 */
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
	thead {
		background-color: #f8d7da;
		color: #721c24;
	}
	th, td {
		border: 1px solid #f5c6cb;
		padding: 12px;
		text-align: center;
	}
	tr:nth-child(even) {
		background-color: #fff0f3;
	}
	tr:hover {
		background-color: #ffe3ec;
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
	<h2>클리너 지원자 목록</h2>

	<table class="table">
	    <thead>
	        <tr>
	            <th>아이디</th>
	            <th>이름</th>
	            <th>전화번호</th>
	            <th>등록일</th>
	            <th>상세보기</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach var="c" items="${cleanerList}">
	            <tr>
	                <td>${c.member_id}</td>
	                <td>${c.memberName}</td>
	                <td>${c.memberPhone}</td>
	                <td>${c.regdate}</td>
	                <td><a href="${contextPath}/admin/cleanerDetail.do?member_id=${c.member_id}">보기</a></td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>
</div>

</body>
</html>
