<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="header">
	<a href="/Urban_Village/" style="text-decoration: none;">
	<div class="logo">
		Urban&Villiage
		</div>
		</a>
	<div class="search-bar">
		<input type="text" placeholder="여행지를 검색하세요">
		<button>검색</button>
	</div>
	<div class="user-links">
	<c:choose>
				<c:when test="${isLogin == true }">
					<td>
						<h3>${loginId }님</h3>
						<h3><a href="/Urban_Village/member/logout.do">로그아웃</a></h3>
					</td>
				</c:when>
				<c:otherwise>
					<td>
						<h3><a href="/Urban_Village/member/loginForm.do">로그인</a></h3>
					</td>
					<h3>
		<a href="/Urban_Village/member/joinMember.do">회원가입</a>
		</h3>
				</c:otherwise>
			</c:choose>
		
	</div>
</div>
