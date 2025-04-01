<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="msg" value='<%=request.getParameter("msg") %>' />
<c:set var="id" value='<%=request.getParameter("id") %>' />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
<style>
	.cls1 {
		font-size:40px;
		text-align:center;
	}
	.cls2 {
		font-size:20px;
		text-align:center;
	}
</style>
<c:choose>
	<c:when test='${msg == "addMember" }'>
		<script>
			alert('${id } 회원을 등록했습니다.');
		</script>
	</c:when>
	<c:when test="${msg == 'modMember' }">
		<script>
			alert('${id } 회원을 수정했습니다.');
		</script>
	</c:when>
	<c:when test="${msg == 'delMember' }">
		<c:if test="${empty id }">
			<script>
				alert('삭제에 실패 했습니다.');
			</script>
		</c:if>
		<c:if test="${not empty id }">
			<script>
				alert('${id } 회원을 삭제했습니다.');
			</script>
		</c:if>
	</c:when>
	<c:when test="${isLogin == true }">
		<script>
			alert('${loginId} 님이 로그인 했습니다.');
		</script>
	</c:when>
</c:choose>
</head>
<body>
	<p class="cls1">회원정보</p>
	<table align="center" border='1'>
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>암호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>이메일</b></td>
			<td width="7%"><b>가입일자</b></td>
			<td width="7%"><b>삭제</b></td>
		</tr>
	<c:choose>
		<c:when test="${membersList == null }">
			<tr>
				<td colspan="5">
					<b>등록된 회원이 없습니다.</b>
				</td>
		</c:when>
		<c:otherwise>
			<c:forEach var="mem" items="${membersList }">	
				<tr align="center">
					<td>
						<a href="${contextPath}/member/memberDetail.do?id=${mem.id}">${mem.id }</a>
					</td>
					<td>${mem.pwd }</td>
					<td>${mem.name }</td>
					<td>${mem.email }</td>
					<td>${mem.joinDate }</td>					
					<td>	
						<a href="${contextPath }/member/delMember.do?id=${mem.id }">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</table>
	<a href="${contextPath }/member/joinMember.do"><p class="cls2">회원가입하기</p></a>
	</body>
</html>











