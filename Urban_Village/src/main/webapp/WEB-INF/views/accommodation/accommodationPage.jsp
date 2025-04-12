<%@page
	import="com.test.Urban_Village.accommodation.dto.AccommodationDTO"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    // 현재 시간을 타임스탬프로 사용
    long currentTimestamp = System.currentTimeMillis();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<script type="text/javascript"
	src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=4144168e9f9cd514608615aac5e437e5"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">



<style>
.heart {
	font-size: 24px;
	cursor: pointer;
	color: #ccc;
}

.heart.active {
	color: red;
}

.hidden {
	display: none;
}
.error-message {
         font-size: 0.9em;
         color: red;
         margin-top: 4px;
         margin-bottom: 8px;
      }

</style>
</head>
<body>

	<main class="container mt-4">
		<div class="d-flex justify-content-between align-items-center">

			<h1 class="fw-bold">🌟
				${sessionScope.accommodation.accommodation_name}</h1>
			<span class="heart" onclick="toggleHeart()">❤️</span>
		</div>
		<p class="text-muted">${sessionScope.accommodation.capacity}</p>
		<p name="commodation_id">숙소 ID
			:${sessionScope.accommodation.accommodation_id}</p>
		  <div class="container mt-4">
         <h3 class="fw-bold">숙소 이미지</h3>
         <div class="row">
            <!-- DB에 저장된 이미지 파일명이 콤마로 구분되어 있다고 가정 -->
            <c:set var="imageStr" value="${sessionScope.accommodation.accommodation_photo}" />
            <c:set var="images" value="${fn:split(imageStr, ',')}" />
            <c:forEach var="img" items="${images}">
               <div class="col-md-6">
                  <img src="${contextPath}/download.do?imageFileName=${img}&accommodation_id=${sessionScope.accommodation.accommodation_id}&timestamp=<%= currentTimestamp %>" 
                       class="img-fluid rounded mb-3" alt="숙소 이미지">

				</div>
            </c:forEach>
         </div>
      </div>

		<div class="row">
			<div class="col-md-6">
				<h3 class="fw-bold">${sessionScope.accommodation.price}원/ 박</h3>
				<p>
					<strong>⭐ 4.93 후기 294개</strong>
				</p>
				<input type="date" id="checkin" class="form-control mb-2"
					onchange="calculatePrice()" placeholder="YYYY-MM-DD"> <input
					type="date" id="checkout" class="form-control mb-2"
					onchange="calculatePrice()" placeholder="YYYY-MM-DD"> <label>인원:</label>
				<select id="guests" class="form-control mb-2">
					<option value="1">1명</option>
					<option value="2">2명</option>
					<option value="3">3명</option>
					<option value="4">4명</option>
				</select>
				<p class="fw-bold">
					총 금액: <span id="totalPrice">₩0</span>
				</p>
				<button type="button" class="btn btn-danger w-100" onclick="goToReservation()">예약하기</button>

			</div>

			<div class="col-md-6">
				<h3>편의시설 확인</h3>
				<ul>
					<li>✅ WiFi ${sessionScope.accommodation.wifi_avail}</li>
					<li>✅ 침실 갯수 ${sessionScope.accommodation.room_count}</li>
					<li>✅ 화장실 갯수 ${sessionScope.accommodation.bathroom_count}</li>
					<li>✅ 침대 갯수 ${sessionScope.accommodation.bed_count}</li>
				</ul>
				<h3>숙소 규칙</h3>
				<ul>
					<li>🚫 반려동물 금지</li>
					<li>🚫 금연</li>
					<li>🔇 밤 10시 이후 정숙</li>
				</ul>
			</div>
		</div>

		<h3 class="mt-4">위치 ${sessionScope.accommodation.capacity}</h3>
		<div id="map" style="width: 100%; height: 400px; background: #ddd;"></div>

		<h3 class="mt-4">📝 후기</h3>
		<div id="reviews">
			<div class="review">
				<p>
					<strong>김철수</strong> ⭐⭐⭐⭐⭐
				</p>
				<p>"경치도 좋고, 숙소가 깔끔해서 너무 만족했습니다!"</p>
			</div>
			<div class="review">
				<p>
					<strong>이영희</strong> ⭐⭐⭐⭐☆
				</p>
				<p>"사진보다 더 예쁘고, 조용한 분위기가 최고였어요!"</p>
			</div>
			<div class="review hidden">
				<p>
					<strong>박지훈</strong> ⭐⭐⭐⭐⭐
				</p>
				<p>"재방문 의사 100%! 너무 좋아요."</p>
			</div>
			<button class="btn btn-outline-secondary mt-2"
				onclick="toggleReviews()">후기 더보기</button>
		</div>

	</main>


	<script>
	function calculatePrice() {
	    let checkin = document.getElementById("checkin").value;
	    let checkout = document.getElementById("checkout").value;
	    let pricePerNight = Number("<c:out value='${sessionScope.accommodation.price}' />");

	    if (checkin && checkout) {
	    	
	        let nights = (new Date(checkout) - new Date(checkin)) / (1000 * 60 * 60 * 24);
	        if (nights > 0) {
	            let totalPrice = nights * pricePerNight;
	            document.getElementById("totalPrice").textContent = "₩" + totalPrice.toLocaleString();

	        } else {
	            document.getElementById("totalPrice").textContent = "₩0";
	        }
	    }
	}

    
    // 카카오맵 초기화 함수
    function initKakaoMap() {
        var container = document.getElementById('map'); // 지도 표시 영역
        var options = {
            center: new kakao.maps.LatLng(37.653, 127.236), // 남양주 좌표
            level: 5 // 확대 레벨 (낮을수록 더 확대)
        };

        var map = new kakao.maps.Map(container, options); // 지도 생성
        var marker = new kakao.maps.Marker({ 
            position: new kakao.maps.LatLng(37.653, 127.236), 
            map: map 
        });
    }

    // 찜하기(하트) 기능
    function toggleHeart() {
        let heart = document.querySelector(".heart");
        heart.classList.toggle("active");
        alert(heart.classList.contains("active") ? "찜 목록에 추가되었습니다!" : "찜 목록에서 제거되었습니다.");
    }
	
    
    
    document.addEventListener('DOMContentLoaded', function() {
        const checkinInput = document.getElementById('checkin');
        const checkoutInput = document.getElementById('checkout');
        const guestsInput = document.getElementById('guests');

        // ✅ 로컬스토리지 완전 초기화
        localStorage.removeItem('reservationCheckin');
        localStorage.removeItem('reservationCheckout');
        localStorage.removeItem('reservationGuests');
        localStorage.removeItem('reservationTotalPrice');

        // ✅ input 초기화
        if (checkinInput) checkinInput.value = "";
        if (checkoutInput) checkoutInput.value = "";
        if (guestsInput) guestsInput.selectedIndex = 0; // 첫 번째 옵션 선택
    });

    function goToReservation() {
        let checkin = document.getElementById("checkin").value;
        let checkout = document.getElementById("checkout").value;
        let guests = document.getElementById("guests").value;
        let pricePerNight = Number("<c:out value='${sessionScope.accommodation.price}' />");
        let nights = (new Date(checkout) - new Date(checkin)) / (1000 * 60 * 60 * 24);
        let totalPrice = nights > 0 ? nights * pricePerNight : 0;
        let hasError = false;

     // 기존에 등록된 error-message 삭제
        $(".error-message").remove();

        if (!checkin) {
           if ($("#checkin").next(".error-message").length === 0) {
              $("<p class='error-message'>체크인 날짜를 선택해주세요.</p>").insertAfter($("#checkin"));
           }
           $("#checkin").focus();
           hasError = true;
        }

        if (!checkout) {
           if ($("#checkout").next(".error-message").length === 0) {
              $("<p class='error-message'>체크아웃 날짜를 선택해주세요.</p>").insertAfter($("#checkout"));
           }
           $("#checkout").focus();
           hasError = true;
        } else if (checkin && checkout && (checkin >= checkout)) {
           if ($("#checkout").next(".error-message").length === 0) {
              $("<p class='error-message'>체크아웃 날짜는 체크인 날짜 이후여야 합니다.</p>").insertAfter($("#checkout"));
           }
           $("#checkout").focus();
           hasError = true;
        }

        if (!guests || isNaN(guests) || Number(guests) < 1) {
           if ($("#guests").next(".error-message").length === 0) {
              $("<p class='error-message'>인원수를 선택해주세요.</p>").insertAfter($("#guests"));
           }
           $("#guests").focus();
           hasError = true;
        }

        if (hasError) {
           return;
        }

        let nights = (new Date(checkout) - new Date(checkin)) / (1000 * 60 * 60 * 24);
        let totalPrice = nights > 0 ? nights * pricePerNight * Number(guests) : 0;


        // 로컬 스토리지 저장
        localStorage.setItem('reservationCheckin', checkin);
        localStorage.setItem('reservationCheckout', checkout);
        localStorage.setItem('reservationGuests', guests);
        localStorage.setItem('reservationTotalPrice', totalPrice);

        // 예약 페이지로 이동
        window.location.href = "/Urban_Village/reservation/reservationForm.do";
    }



    // 후기 더보기 기능
    function toggleReviews() {
        document.querySelectorAll(".review.hidden").forEach(el => el.classList.toggle("hidden"));
    }

    // 페이지 로드 시 지도 표시
    window.onload = initKakaoMap;
</script>
</body>
</html>