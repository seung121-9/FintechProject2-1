<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%-- <link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/style.css"> --%>
<script>
    function toggleHeart(icon) {
        if (icon.classList.contains("liked")) {
            icon.innerHTML = "&#9825;"; // 빈 하트
            icon.classList.remove("liked");
        } else {
            icon.innerHTML = "&#9829;"; // 채워진 하트
            icon.classList.add("liked");
        }
    }
    function name() {

    }
</script>
<head>
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
</head>

<body>
    <div class="container">

        <div class="categories-container">
            <div class="categories">
                <a href="#">최고의 전망</a> <a href="#">호잇</a> <a href="#">유량</a> <a
                    href="#">한적</a> <a href="#">최고</a> <a href="#">공원</a> <a href="#">한옥</a>
                <a href="#">소형주택</a> <a href="#">인기급상</a> <a href="#">Luxe</a> <a
                    href="#">독채</a>
            </div>
        </div>
            <div class="accommodations">
    <c:forEach items="${accommodationList}" var="accommodation">
        <div class="accommodation">
            <a href="${pageContext.request.contextPath}/accommodation/accommodationPage.do?accommodation_id=${accommodation.accommodation_id}">
                <span class="heart-icon"
                        onclick="event.stopPropagation(); toggleHeart(this)">&#9825;</span>
                <img src="${accommodation.accommodation_photo}"
                        alt="${accommodation.accommodation_name}">
                <div class="details">
                    <h3>${accommodation.accommodation_name}</h3>
                    <p>★ 5.0 ${accommodation.capacity}</p>
                    <p>₩ ${accommodation.price} / 박</p>
                    <p>게스트 한마디: 정말 예쁘고 깔끔한 곳....</p>
                </div>
            </a>
        </div>
    </c:forEach>
</div>

<%-- <div id="accommodationDetails" style="display: none;"></div> --%>

            <div class="accommodation">
                <span class="heart-icon" onclick="toggleHeart(this)">&#9825;</span>
                <a href="${pageContext.request.contextPath}/accommodation/accommodationPage.do?accommodation_id=A1"> <img
                    src="${pageContext.request.contextPath}/resources/image/image1.jpg"
                    alt="숙소 이미지">
                    <div class="details">
                        <h3>한국 Gangha-myeon, Yangpy...</h3>
                        <p>★ 5.0 한국 가평군</p>
                        <p>4월 12일 - 18일</p>
                        <p>₩ 183,729 / 박</p>
                        <p>게스트 한마디: 정말 예쁘고 깔끔한 곳....</p>
                    </div>
                </a>
            </div>
            <div class="accommodation">
                <span class="heart-icon" onclick="toggleHeart(this)">&#9825;</span>
                <a href="${pageContext.request.contextPath}/accommodation/accommodationPage.do?accommodation_id=A2"> <img
                    src="${pageContext.request.contextPath}/resources/image/image3.jpg"
                    alt="숙소 이미지">
                    <div class="details">
                        <h3>한국 Gapyeong-eup, Gapyeo...</h3>
                        <p>★ 4.6 한국 가평군</p>
                        <p>4월 20일 - 25일</p>
                        <p>₩ 303,553 / 박</p>
                        <p>게스트 한마디: 장보고 바로 오기 편했어요...</p>
                    </div>
                </a>
            </div>
            <div class="accommodation">
                <span class="heart-icon" onclick="toggleHeart(this)">&#9825;</span>
                <a href="${pageContext.request.contextPath}/accommodation/accommodationPage.do?accommodation_id=A3"> <img
                    src="${pageContext.request.contextPath}/resources/image/image4.jpg"
                    alt="숙소 이미지">
                    <div class="details">
                        <h3>한국 Okcheon-myeon, Yangp...</h3>
                        <p>★ 4.86 한국 가평군</p>
                        <p>5월 7일 - 12일</p>
                        <p>₩ 184,871 / 박</p>
                    </div>
                </a>
            </div>
            <div class="accommodation">
                <span class="heart-icon" onclick="toggleHeart(this)">&#9825;</span>
                <a href="${pageContext.request.contextPath}/accommodation/accommodationPage.do?accommodation_id=A4"> <img
                    src="${pageContext.request.contextPath}/resources/image/image5.jpg"
                    alt="숙소 이미지">
                    <div class="details">
                        <h3>한국 Gangha-myeon, Yangpy...</h3>
                        <p>★ 4.95 한국 가평군</p>
                        <p>6월 1일 - 6일</p>
                        <p>₩ 155,376 / 박</p>
                    </div>
                </a>
            </div>
            <div class="accommodation">
                <span class="heart-icon" onclick="toggleHeart(this)">&#9825;</span>
                <a href="${pageContext.request.contextPath}/accommodation/accommodationPage.do?accommodation_id=A5"> <img
                    src="${pageContext.request.contextPath}/resources/image/image6.jpg"
                    alt="숙소 이미지">
                    <div class="details">
                        <h3>한국 Gangha-myeon, Yangpy...</h3>
                        <p>★ 4.95 한국 가평군</p>
                        <p>4월 12일 - 17일</p>
                        <p>₩ 183,729 / 박</p>
                    </div>
                </a>
            </div>
        </div>
    </div>
</body>
</html>