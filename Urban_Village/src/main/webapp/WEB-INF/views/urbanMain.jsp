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
    <title>A</title>
    <style>
        body {
            font-family: sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 0 auto;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px 0;
        }

        .header .logo {
            font-size: 24px;
            font-weight: bold;
        }

        .header .user-links {
            display: flex;
            align-items: center;
        }

        .header .user-links a {
            text-decoration: none;
            color: #333;
            margin-left: 10px;
        }

        .search-bar {
            display: flex;
            align-items: center;
            border: 1px solid #ddd;
            border-radius: 5px;
           margin-left:600px;
            padding: 5px;
        }

        .search-bar input[type="text"] {
            border: none;
            padding: 8px;
            margin-right: 5px;
            flex-grow: 1;
        }

        .search-bar button {
            background-color: #ff5a5f;
            color: white;
            border: none;
            padding: 8px 15px;
            border-radius: 5px;
            cursor: pointer;
        }

        .categories {
            display: flex;
            justify-content: space-around;
            margin-bottom: 20px;
        }

        .categories a {
            text-decoration: none;
            color: #333;
            padding: 8px 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .accommodations {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .accommodation {
            width: 30%;
            margin: 20px;
            border: 1px solid #ddd;
            box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1);
            box-sizing: border-box; 
        }

        .accommodation img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        .details {
            padding: 10px;
        }

        .details h3 {
            margin-top: 0;
        }

        .details p {
            margin-bottom: 5px;
        }

        @media (max-width: 768px) {
            .accommodation {
                width: 45%;
            }
        }

        @media (max-width: 480px) {
            .accommodation {
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <div class="logo">Urban&Villiage</div>
            <div class="search-bar">
                <input type="text" placeholder="여행지를 검색하세요">
                <button>검색</button>
            </div>
            <div class="user-links"> <a href="#">로그인</a>
<<<<<<< HEAD
                <a href="/Urban_Village/urban/urbanJoin">회원가입</a>
=======
                <a href="${context }/Urban_Village/urban/joinMember">회원가입</a>
>>>>>>> refs/heads/대중
            </div>
        </div>
        <div class="categories">
            <a href="#">최고의 전망</a>
            <a href="#">호잇</a>
            <a href="#">유량</a>
            <a href="#">한적</a>
            <a href="#">최고</a>
            <a href="#">공원</a>
            <a href="#">나무집</a>
            <a href="#">소형주택</a>
            <a href="#">인기급상</a>
            <a href="#">Luxe</a>
            <a href="#">독채</a>
        </div>

        <div class="accommodations">
            <div class="accommodation">
                <img src="${pageContext.request.contextPath}/resources/image/image2.jpg" alt="숙소 이미지">
                <div class="details">
                    <h3>한국 Gangha-myeon, Yangpy...</h3>
                    <p>★ 5.0 한국 가평군</p>
                    <p>4월 12일 - 18일</p>
                    <p>₩ 183,729 / 박</p>
                    <p>게스트 한마디: 정말 예쁘고 깔끔한 곳....</p>
                </div>
            </div>
            <div class="accommodation">
                <img src="${pageContext.request.contextPath}/resources/image/image1.jpg" alt="숙소 이미지">
                <div class="details">
                    <h3>한국 Gangha-myeon, Yangpy...</h3>
                    <p>★ 5.0 한국 가평군</p>
                    <p>4월 12일 - 18일</p>
                    <p>₩ 183,729 / 박</p>
                    <p>게스트 한마디: 정말 예쁘고 깔끔한 곳....</p>
                </div>
            </div>
            <div class="accommodation">
                <img src="${pageContext.request.contextPath}/resources/image/image3.jpg" alt="숙소 이미지">
                <div class="details">
                    <h3>한국 Gapyeong-eup, Gapyeo...</h3>
                    <p>★ 4.6 한국 가평군</p>
                    <p>4월 20일 - 25일</p>
                    <p>₩ 303,553 / 박</p>
                    <p>게스트 한마디: 장보고 바로 오기 편했어요...</p>
                </div>
            </div>
            <div class="accommodation">
                <img src="${pageContext.request.contextPath}/resources/image/image4.jpg" alt="숙소 이미지">
                <div class="details">
                    <h3>한국 Okcheon-myeon, Yangp...</h3>
                    <p>★ 4.86 한국 가평군</p>
                    <p>5월 7일 - 12일</p>
                    <p>₩ 184,871 / 박</p>
                </div>
            </div>
            <div class="accommodation">
                <img src="${pageContext.request.contextPath}/resources/image/image5.jpg" alt="숙소 이미지">
                <div class="details">
                    <h3>한국 Gangha-myeon, Yangpy...</h3>
                    <p>★ 4.95 한국 가평군</p>
                    <p>6월 1일 - 6일</p>
                    <p>₩ 155,376 / 박</p>
                </div>
            </div>
            <div class="accommodation">
                <img src="${pageContext.request.contextPath}/resources/image/image6.jpg" alt="숙소 이미지">
                <div class="details">
                    <h3>한국 Gangha-myeon, Yangpy...</h3>
                    <p>★ 4.95 한국 가평군</p>
                    <p>4월 12일 - 17일</p>
                    <p>₩ 183,729 / 박</p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>