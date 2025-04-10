```jsp name=accommodationRegistration.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <title>숙소 등록</title>
    <style>
        body {
            font-family: sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
        }
        .container {
            width: 50%;
            margin: 0 auto;
            padding-top: 50px;
        }
        .form-box {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
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
        .submit-button {
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
        .submit-button:hover {
            background-color: #f44336;
        }
        .image-preview {
            margin-top: 10px;
            width: 100%;
            height: auto;
            display: block;
            margin-bottom: 10px;
        }
    </style>
    <script>
        function previewImages(event) {
            var output = document.getElementById('imagePreviewContainer');
            // 초기화
            output.innerHTML = '';
            var files = event.target.files;
            if (files) {
                for (var i = 0; i < files.length; i++) {
                    var file = files[i];
                    // 이미지 파일인지 확인
                    if (!file.type.startsWith('image/')) { 
                        continue;
                    }
                    var reader = new FileReader();
                    reader.onload = function(e) {
                        var img = document.createElement('img');
                        img.src = e.target.result;
                        img.alt = '이미지 미리보기';
                        img.className = 'image-preview';
                        output.appendChild(img);
                    };
                    reader.readAsDataURL(file);
                }
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <form method="post" action="${contextPath}/accommodation/addNewAccommodation" class="form-box" enctype="multipart/form-data">
            <h2>숙소 등록</h2>
            <input type="text" name="accommodation_id" value="등록후 숙소 아이디가 자동으로 생성됩니다." class="input-field" required readonly>
            <input type="text" name="admin_id" class="input-field" placeholder="관리자 ID" required>
            <input type="text" name="accommodation_name" class="input-field" placeholder="숙소 이름" required>
            <input type="file" name="accommodation_photo[]" class="input-field" placeholder="숙소 사진 경로" required onchange="previewImages(event)" multiple>
            <div id="imagePreviewContainer"></div>
            <input type="text" name="cleaner_admin_id" class="input-field" placeholder="청소 관리자 ID (선택)">
            <input type="number" name="capacity" class="input-field" placeholder="최대 인원 수" required>
            <input type="number" name="room_count" class="input-field" placeholder="방 개수" required>
            <input type="number" name="bathroom_count" class="input-field" placeholder="화장실 개수" required>
            <input type="number" name="bed_count" class="input-field" placeholder="침대 수" required>
            <input type="number" name="price" class="input-field" placeholder="가격" required>
            <select name="wifi_avail" class="input-field" required>
                <option value="">와이파이 여부 선택</option>
                <option value="Y">Y</option>
                <option value="N">N</option>
            </select>
            <button type="submit" class="submit-button">등록</button>
        </form>
    </div>
</body>
</html>