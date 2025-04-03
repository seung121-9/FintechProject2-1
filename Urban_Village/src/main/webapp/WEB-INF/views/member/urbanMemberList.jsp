<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>A</title>
    <style>
        /* 이미지 기반 스타일 CSS 코드 */
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

        .search-bar {
            display: flex;
            align-items: center;
            border: 1px solid #ddd;
            border-radius: 5px;
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
        }

        .accommodation {
            width: 300px;
            margin: 20px;
            border: 1px solid #ddd;
            box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1);
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
        <table border="1" align="center" width="80%">
	<tr align="center" bgcolor="lightgreen">
			<td>아이디</td>
			<td>비번</td>
			<td>이름</td>
			<td>이메일</td>
			<td>birth</td>
			<td>phonenumber</td>
			<td>regdate</td>
			<td>gender</td>
			
		</tr>
		<c:forEach var="m" items="${membersList }">
			<tr align="center">
				<td>${m.id }</td>
				<td>${m.pwd }</td>
				<td>${m.name }</td>
				<td>${m.email }</td>
				<td>${m.birth }</td>
				<td>${m.phonenumber }</td>
				<td>${m.regdate }</td>
				<td>${m.gender }</td>
			</tr>
		</c:forEach>
	</table>
    </div>
</body>
</html>