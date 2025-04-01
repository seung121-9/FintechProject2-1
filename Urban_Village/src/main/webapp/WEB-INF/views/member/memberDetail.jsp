<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정창</title>
</head>
<body>
	<form method='post' action='${contextPath }/member/modMember.do'>
		<h1 style='text-align:center'>회원 정보 수정창</h1>
		<table align='center'>
			<tr>
				<td width='200'><p align='right'>아이디</p></td>
				<td width='400'><input type='text' name='id' value="${member.id }" readonly="readonly"></td>
			</tr>
			<tr>
				<td width='200'><p align='right'>암호</p></td>
				<td width='400'><input type='password' name='pwd' value="${member.pwd }"></td>
			</tr>
			<tr>
				<td width='200'><p align='right'>이름</p></td>
				<td width='400'><input type='text' name='name' value="${member.name }"></td>
			</tr>
			<tr>
				<td width='200'><p align='right'>이메일</p></td>
				<td width='400'><input type='email' name='email' value="${member.email }"></td>
			</tr>
			<tr>
				<td width='200'><p align='right'>가입일자</p></td>
				<td widht='400'><input type="text" name='joinDate' value="${member.joinDate }" readonly="readonly"></td>
			</tr>
			<tr>
				<td width='200'><p>&nbsp;</p></td>
				<td>
					<input type='submit' value='수정하기'>
					<input type='reset' value='다시입력'>
				</td>	
			</tr>
		</table>
	</form>
</body>
</html>





