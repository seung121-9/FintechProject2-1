<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인창</title>
    <c:choose>
        <c:when test='${param.result == "loginFailed"}'>
            <script>
                alert('아이디나 비밀번호가 틀립니다. 다시 로그인 하세요.');
            </script>
        </c:when>
        <c:when test="${param.result == 'logout' }">
            <script>
                alert('로그아웃 되었습니다. 다시 로그인 하세요.');
            </script>
        </c:when>
        <c:when test="${param.result == 'notLogin' }">
            <script>
                alert('로그인이 되어 있지 않습니다. 로그인 하세요.');
            </script>
        </c:when>
    </c:choose>

    <style>
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 100%;
            max-width: 400px;
            margin: 50px auto;
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .input-group {
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 8px;
            color: #333;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-top: 6px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        .form-actions {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .form-actions input[type="submit"] {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .form-actions input[type="submit"]:hover {
            background-color: #555;
        }

        .form-actions input[type="reset"] {
            background-color: #ddd;
            color: #333;
            padding: 10px 20px;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .form-actions input[type="reset"]:hover {
            background-color: #bbb;
        }

        .link-group {
            text-align: center;
            margin-top: 20px;
        }

        .link-group a {
            color: #333;
            text-decoration: none;
            margin: 0 10px;
            font-size: 14px;
        }

        .link-group a:hover {
            text-decoration: underline;
        }
    </style>

</head>
<body>

    <div class="container">
        <h2>로그인</h2>
        <form method="post" action="/pro13/member/login.do">
            <div class="input-group">
                <label for="id">아이디</label>
                <input type="text" name="id" id="id" size="20">
            </div>
            <div class="input-group">
                <label for="pwd">비밀번호</label>
                <input type="password" name="pwd" id="pwd" size="20">
            </div>

            <div class="form-actions">
                <input type="submit" value="로그인">
                <input type="reset" value="다시입력">
            </div>

            <div class="link-group">
                <a href="#">아이디 찾기</a>
                <a href="#">비밀번호 찾기</a>
                <a href="/member/joinMember.do">회원가입</a>
            </div>
        </form>
    </div>

</body>
</html>
