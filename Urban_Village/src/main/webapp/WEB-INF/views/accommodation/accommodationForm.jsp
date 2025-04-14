
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
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
        
        function validateForm() {
            const form = document.forms[0];

            // 필수값 확인
            if (form.admin_id.value.trim() === "") {
                alert("관리자 ID를 입력해주세요.");
                form.admin_id.focus();
                return false;
            }
            if (form.accommodation_name.value.trim() === "") {
                alert("숙소 이름을 입력해주세요.");
                form.accommodation_name.focus();
                return false;
            }
            if (form["accommodation_photo[]"].files.length === 0) {
                alert("숙소 사진을 하나 이상 선택해주세요.");
                return false;
            }

            // 숫자 필드 확인
            const numberFields = ["capacity", "room_count", "bathroom_count", "bed_count", "price"];
            for (let field of numberFields) {
                const value = form[field].value.trim();
                if (value === "" || isNaN(value) || parseInt(value) <= 0) {
                    alert(field + " 항목은 0보다 큰 숫자여야 합니다.");
                    form[field].focus();
                    return false;
                }
            }

            // 와이파이 선택 확인
            if (form.wifi_avail.value === "") {
                alert("와이파이 여부를 선택해주세요.");
                form.wifi_avail.focus();
                return false;
            }

            return true;
        }
        
        function checkAccommodationName() {
            var accommodationName = $("#accommodationName").val();
            if (accommodationName === "") {
                alert("숙소 이름을 입력하세요.");
                return;
            }

            $.ajax({
                url: "${contextPath}/accommodation/checkName.do",
                method: "POST",
                data: { name: accommodationName },
                success: function(response) {
                    if (response.exists) {
                        alert("숙소 이름이 이미 존재합니다.");
                    } else {
                        alert("사용 가능한 숙소 이름입니다.");
                    }
                },
                error: function() {
                    alert("숙소 이름 중복 체크 중 오류가 발생했습니다.");
                }
            });
        }
    </script>
</head>
<body>
    <div class="container">
        <form method="post" action="${contextPath}/accommodation/addNewAccommodation" class="form-box" enctype="multipart/form-data">
            <h2>숙소 등록</h2>
            <input type="text" name="accommodation_id" value="등록후 숙소 아이디가 자동으로 생성됩니다." class="input-field" required readonly>
            <input type="text" name="admin_id" class="input-field" placeholder="관리자 ID" required>
           <div style="display: flex; gap: 10px;">
                <input type="text" id="accommodationName" name="accommodation_name" class="input-field" placeholder="숙소 이름" required style="flex: 1;">
                <button type="button" class="submit-button" style="flex: 0 1 150px;" onclick="checkAccommodationName()">중복체크</button>
            </div>
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