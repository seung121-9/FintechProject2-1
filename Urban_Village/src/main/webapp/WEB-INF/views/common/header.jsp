<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
	<table border="0" width="100%">
		<tr>
			<td>
				<a href="/pro13/main.do">
					<img src="/pro13/resources/image/duke_swing.gif">
				</a>
			</td>
			<td>
				<h1><font size="30">스프링실습 홈페이지</font></h1>
			</td>
			<c:choose>
				<c:when test="${isLogin == true }">
					<td>
						<h3>${loginId }</h3>
						<h3><a href="/pro13/member/logout.do">로그아웃</a></h3>
					</td>
				</c:when>
				<c:otherwise>
					<td>
						<a href="/pro13/member/loginForm.do"><h3>로그인</h3></a>
					</td>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
</body>
</html>