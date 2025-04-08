<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Urban&Village</title>
<link rel="stylesheet" href="/Urban_Village/resources/css/style.css">
<script>
        // 드롭다운 메뉴 토글
        function toggleDropdown() {
            let dropdown = document.getElementById("dropdownMenu");
            dropdown.style.display = (dropdown.style.display === "block") ? "none" : "block";
        }

        // 드롭다운 외부 클릭 시 닫기
        window.onclick = function(event) {
            if (!event.target.matches('.menu-btn') && !event.target.matches('.profile-img')) {
                let dropdown = document.getElementById("dropdownMenu");
                if (dropdown.style.display === "block") {
                    dropdown.style.display = "none";
                }
            }
        };
    </script>
<style>
/* 헤더 스타일 */
.header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 15px 20px;
    border-bottom: 1px solid #ddd;

    /* ✅ 검색창 중앙 정렬을 위한 추가 */
    position: relative;
}

/* 로고 */
.header .logo {
   font-size: 24px;
   font-weight: bold;
   text-decoration: none;
   color: #333;
}

/* 검색창 */
.search-bar {
    /* ✅ 가운데 정렬을 위한 수정 */
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    
    display: flex;
    align-items: center;
    border: 2px solid #ddd;
    border-radius: 30px;
    padding: 5px;
    background-color: white;
    width: 450px;
    height: 45px;
    z-index: 5;
}

.search-bar input[type="text"] {
   border: none;
   padding: 10px;
   font-size: 16px; /* 글씨 크기 증가 */
   flex-grow: 1;
   outline: none; /* 포커스 효과 제거 */
}

.search-bar button {
   background-color: #ff5a5f;
   color: white;
   border: none;
   padding: 10px 20px;
   border-radius: 30px;
   cursor: pointer;
   font-size: 20px; /* 버튼 글씨 크기 증가 */
}

/* 사용자 메뉴 */
.user-menu {
   position: relative;
}

/* 프로필 메뉴 */
.profile-menu {
   display: flex;
   align-items: center;
   cursor: pointer;
}

/* 프로필 이미지 */
.profile-img {
   width: 35px;
   height: 35px;
   border-radius: 50%;
   margin-right: 5px;
}

/* 햄버거 메뉴 버튼 */
.menu-btn {
   background: none;
   border: none;
   font-size: 20px;
   cursor: pointer;
}

/* 드롭다운 메뉴 */
.dropdown-content {
   display: none;
   position: absolute;
   right: 0;
   background-color: white;
   box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
   min-width: 200px;
   border-radius: 10px;
   overflow: hidden;
   z-index: 10;
}

.dropdown-content a {
   display: block;
   padding: 10px;
   text-decoration: none;
   color: black;
}

.dropdown-content a:hover {
   background-color: #f1f1f1;
}

.dropdown-content hr {
   margin: 5px 0;
   border: 0.5px solid #ddd;
}

/* 반응형 스타일 */
@media ( max-width : 768px) {
   .header {
      flex-direction: column;
      align-items: flex-start;
   }
   .search-bar {
      width: 100%;
      margin-top: 10px;
   }
}
</style>
</head>
<body>

   <!-- 헤더 시작 -->
   <div class="header">
      <!-- 로고 -->
      <a href="/Urban_Village/" class="logo"> Urban&Village </a>

      <!-- 검색창 -->
      <div class="search-bar">
         <input type="text" placeholder="여행지를 검색하세요">
         <button>검색</button>
      </div>

      <!-- 사용자 메뉴 -->
      <div class="user-menu">
         <c:choose>
            <c:when test="${isLogin == true}">
               <!-- 로그인 상태 -->
               <div class="profile-menu">
                  <img src="/Urban_Village/resources/images/profile.png"
                     class="profile-img" alt="프로필 이미지">
                  <button class="menu-btn" onclick="toggleDropdown()">☰</button>
               </div>

               <!-- 드롭다운 메뉴 -->
               <div id="dropdownMenu" class="dropdown-content">
                  <a href="#">여행(예약확인)</a> <a href="#">위시리스트</a>
                  <hr>
                  <a href="#">호스트 추천하기</a> <a href="#">계정</a> <a href="#">직원채용</a>
                  <hr>
                  <a href="#">도움말 센터</a> <a href="/Urban_Village/member/logout.do">로그아웃</a>
               </div>
            </c:when>
            <c:when test="${isAdmin == true}">
               <!-- 로그인 상태 -->
               <div class="profile-menu">
                  <img src="/Urban_Village/resources/images/profile.png"
                     class="profile-img" alt="프로필 이미지">
                  <button class="menu-btn" onclick="toggleDropdown()">☰</button>
               </div>

               <!-- 드롭다운 메뉴 -->
               <div id="dropdownMenu" class="dropdown-content">
                  <a href="#">숙소 추가</a> <a href="#">지원자 현황</a>
                  <hr>
                  <a href="#">직원 배정</a> <a href="#">계정</a> <a href="#">매출</a>
                  <hr>
                  <a href="#">회원 관리</a> <a href="/Urban_Village/member/logout.do">로그아웃</a>
               </div>
            </c:when>
            <c:otherwise>
               <!-- 로그아웃 상태 -->
               <a href="/Urban_Village/member/loginForm.do">로그인</a>
               <a href="/Urban_Village/member/joinMember.do">회원가입</a>
            </c:otherwise>
         </c:choose>
      </div>
   </div>
   
   
   <!-- 헤더 끝 -->

</body>
</html>
