<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="header">
	<div class="logo">
		Urban&Villiage
		</div>
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
				</c:otherwise>
			</c:choose>
		<h3>
		<a href="/Urban_Village/member/joinMember.do">회원가입</a>
		</h3>
	</div>
</div>
<div class="categories-container">
	<div class="categories">
		<a href="#">최고의 전망</a> <a href="#">호잇</a> <a href="#">유량</a> <a
			href="#">한적</a> <a href="#">최고</a> <a href="#">공원</a> <a href="#">한옥</a>
		<a href="#">소형주택</a> <a href="#">인기급상</a> <a href="#">Luxe</a> <a
			href="#">독채</a>
	</div>
</div>