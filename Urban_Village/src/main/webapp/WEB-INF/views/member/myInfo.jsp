<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
   isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
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

.divlogo {
   color: #FF385C;
   font-size: 24px;
   font-weight: bold;
   margin-bottom: 20px;
}
.logo {
   font-size: 24px;
   font-weight: bold;
   text-decoration: none;
   color: #333;
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
   margin-left: 750px;
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
.footer {
   background-color: #f8f8f8;
   padding: 20px;
   text-align: center;
   border-top: 1px solid #ddd;
   font-size: 0.8em;
   color: #777;
   margin-left: 250px;
}

</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
        $(document).ready(function() {
            $("form").submit(function(event) {
                var phoneNumber = $("input[name='phonenumber']").val();
                var email = $("input[name='email']").val();
                var name = $("input[name='name']").val();
                var pwd = $("input[name='pwd']").val(); // 비밀번호는 수정 시 필수가 아닐 수 있음
                var birth = $("input[name='birth']").val();
                var gender = $("select[name='gender']").val();
                var hasError = false;
                var phoneRegex = /^\d{3}-\d{4}-\d{4}$/;
                var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

                $(".error-message").remove();

                if (name === "") {
                    $("<p class='error-message'>이름을 입력하세요.</p>").insertAfter($("input[name='name']"));
                    $("input[name='name']").focus();
                    hasError = true;
                }

                if (email === "") {
                    $("<p class='error-message'>이메일을 입력하세요.</p>").insertAfter($("input[name='email']"));
                    $("input[name='email']").focus();
                    hasError = true;
                } else if (!emailRegex.test(email)) {
                    $("<p class='error-message'>이메일 형식이 올바르지 않습니다.</p>").insertAfter($("input[name='email']"));
                    $("input[name='email']").focus();
                    hasError = true;
                }

                if (birth === "") {
                    $("<p class='error-message'>생년월일을 입력하세요.</p>").insertAfter($("input[name='birth']"));
                    $("input[name='birth']").focus();
                    hasError = true;
                }

                if (gender === "") {
                    $("<p class='error-message'>성별을 선택하세요.</p>").insertAfter($("select[name='gender']").parent());
                    $("select[name='gender']").focus();
                    hasError = true;
                }

                if (phoneNumber === "") {
                    $("<p class='error-message'>전화번호를 입력하세요.</p>").insertAfter($("input[name='phonenumber']"));
                    $("input[name='phonenumber']").focus();
                    hasError = true;
                } else if (!phoneRegex.test(phoneNumber)) {
                    $("<p class='error-message'>전화번호 형식이 올바르지 않습니다. (예: 010-1234-5678)</p>").insertAfter($("input[name='phonenumber']"));
                    $("input[name='phonenumber']").focus();
                    hasError = true;
                }

                // 비밀번호는 수정 시 필수가 아닐 수 있으므로 검사 조건에 따라 추가

                if (hasError) {
                    event.preventDefault();
                }
            });
        });
    </script>
</head>
<body>
   <div class="sidebar">
      <div class="divlogo"><a href="/Urban_Village/" class="logo"> Urban&Village </a></div>
	  <button style="background: #FF385C; color: white;" class="btn" onclick="location.href='${contextPath }/member/myInfo.do?id=${loginId}'">내정보 확인</button>
      <button class="btn" onclick="location.href='${contextPath }/wishList/wishList.do?memberId=${loginId}'">위시리스트</button>
      <button class="btn" onclick="location.href='${contextPath }/cleaner/cleanerForm.do'">구직지원</button>
      <button class="btn" onclick="location.href='${contextPath}/member/deleteMemberForm.do'">회원탈퇴</button>
      <button class="btn" onclick="location.href='${contextPath}/reservation/reservationHistory.do'">예약확인하기</button>
   </div>
   <div class="content">
      <h2>내 정보 페이지</h2>
      <div class="info-box">
         <form action="${contextPath}/member/updateUserInfo.do" method="post">
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
                  <label for="name" class="form-label">이름</label> <input type="text"
                     class="form-control" id="name" name="name"
                     value="${memberList[0].name}">
               </div>
              
               <button type="submit" class="btn btn-primary">수정하기</button>
            </c:if>
         </form>
      </div>
   </div>
   <div class="footer">
	<div class="footer-links">
		<a href="#">© 2025 Urban&Villiage, Inc.</a> <a href="#">개인 정보 처리
			방침</a> <a href="#">쿠키 정책</a> <a href="#">이용 약관</a> <a href="#">사이트 맵</a>
		<a href="#">한국의 변경된 환불 정책</a> <a href="#">회사 세부 정보</a>
	</div>
	<div class="footer-details">
		웹사이트: Urban&Villiage Ireland UC, private unlimited company, 8 Hanover
		Quay, Dublin 2, D02 DP23 Ireland. (Dermot Clark, Allan Pättwell,
		Andrea Finnegan, VAT 번호: IE9827384L) <a href="mailto:naver.com">알아서
			찾아보쇼</a>. 사이트, 010-1111-1111. 호스팅 서비스 제공업체가 아닙니다. 본 서비스에서 이루어지는 숙박 계약의
		당사자가 아닙니다. 이용자에게 숙소를 제공하는 호스트에게 있습니다.
	</div>
</div>
</body>
</html>