<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>A Login</title>
    <style>
        body {
            font-family: sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
        }

        .login-form {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            margin-top: 30px;
            width: 300px;
            margin: 50px auto;
        }

        .login-form table {
            width: 100%;
        }

        .login-form td {
            padding: 10px;
        }

        .input-field {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border-radius: 8px;
            border: 1px solid #ddd;
            font-size: 16px;
            background-color: #f7f7f7;
            transition: all 0.3s ease;
        }

        .input-field:focus {
            border-color: #ff5a5f;
            background-color: white;
            outline: none;
        }

        .login-button {
            background-color: #ff5a5f;
            color: white;
            border: none;
            padding: 12px 24px;
            font-size: 16px;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            margin-top: 10px;
        }

        .login-button:hover {
            background-color: #f44336;
        }
        
        .admin-login-button {
            background-color: green;
            color: white;
            border: none;
            padding: 12px 24px;
            font-size: 16px;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <div class="login-form">
        
        <form method="post" action="/Urban_Village/admin/login.do">
            <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="id" class="input-field" placeholder="아이디를 입력하세요"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" name="pwd" class="input-field" placeholder="비밀번호를 입력하세요"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit" class="login-button">로그인</button>
                    </td>
                </tr>
            </table>    
        </form>
    </div>
</body>
</html>
