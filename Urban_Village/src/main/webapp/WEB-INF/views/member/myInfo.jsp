<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>내 정보</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
body {
	background-color: #f8f9fa;
	font-family: 'Arial', sans-serif;
}

.sidebar {
	width: 250px;
	height: 100vh;
	background: white;
	padding: 20px;
	box-shadow: 2px 0 10px rgba(0, 0, 0, 0.1);
	position: fixed;
	left: 0;
	top: 0;
	display: flex;
	flex-direction: column;
	align-items: flex-start;
}

.logo {
	color: #FF385C;
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 20px;
}

.sidebar button {
	width: 100%;
	text-align: left;
	margin-bottom: 10px;
	padding: 10px;
	font-size: 16px;
	border-radius: 5px;
	border: none;
	background: #f8f9fa;
	transition: all 0.3s;
}

.sidebar button:hover {
	background: #FF385C;
	color: white;
}

.content {
	margin-left: 500px;
	padding: 40px;
}

.info-box {
	background: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	max-width: 500px;
}

.info-box label {
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="sidebar">
		<div class="logo">Airbnb</div>
		<button class="btn">내정보 확인</button>
		<button class="btn">위시리스트</button>
		<button class="btn">직원채용</button>
		<button class="btn">회원탈퇴</button>
		<button class="btn">예약확인하기</button>
	</div>
	<div class="content">
		<h2>내 정보 페이지</h2>
		<div class="content">
			<h2>내 정보 페이지</h2>
			<div class="info-box">
				<form action="${contextPath }/member/updateUserInfo.do"
					method="post">
					<c:if test="${memberList != null}">
						<div class="mb-3">
							<label for="id" class="form-label">아이디</label> <input type="text"
								class="form-control" id="id" name="id"
								value="${memberList[0].id}" readonly>
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">비밀번호</label> <input
								type="password" class="form-control" id="pwd" name="pwd"
								value="${memberList[0].pwd}">
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">이메일</label> <input
								type="email" class="form-control" id="email" name="email"
								value="${memberList[0].email}">
						</div>
						<div class="mb-3">
							<label for="birthdate" class="form-label">생년월일</label> <input
								type="date" class="form-control" id="birthdate" name="birth"
								value="${memberList[0].birth}" readonly>
						</div>
						<div class="mb-3">
							<label for="gender" class="form-label">성별</label> <select
								class="form-control" id="gender" name="gender" readonly>
								<option value="남성"
									${memberList[0].gender == '남성' ? 'selected' : ''}>남성</option>
								<option value="여성"
									${memberList[0].gender == '여성' ? 'selected' : ''}>여성</option>
							</select>
						</div>
						<div class="mb-3">
							<label for="phone" class="form-label">전화번호</label> <input
								type="tel" class="form-control" id="phone" name="phonenumber"
								value="${memberList[0].phonenumber}">
						</div>
						<div class="mb-3">
							<label for="name" class="form-label">이름</label> <input
								type="text" class="form-control" id="name" name="name"
								value="${memberList[0].name}">
						</div>
						<button type="submit" class="btn btn-primary">수정하기</button>
					</c:if>
				</form>
			</div>
		</div>
	</div>
</body>
</html>