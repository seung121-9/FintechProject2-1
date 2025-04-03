
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
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
</script>
</head>
<body>
	<div class="container">
		<div class="accommodations">
			<div class="accommodation">
				<span class="heart-icon" onclick="toggleHeart(this)">&#9825;</span>
				<img
					src="${pageContext.request.contextPath}/resources/image/image2.jpg"
					alt="숙소 이미지">
				<div class="details">
					<h3>한국 Gangha-myeon, Yangpy...</h3>
					<p>★ 5.0 한국 가평군</p>
					<p>4월 12일 - 18일</p>
					<p>₩ 183,729 / 박</p>
					<p>게스트 한마디: 정말 예쁘고 깔끔한 곳....</p>
				</div>
			</div>
			<div class="accommodation">
				<span class="heart-icon" onclick="toggleHeart(this)">&#9825;</span>
				<img
					src="${pageContext.request.contextPath}/resources/image/image1.jpg"
					alt="숙소 이미지">
				<div class="details">
					<h3>한국 Gangha-myeon, Yangpy...</h3>
					<p>★ 5.0 한국 가평군</p>
					<p>4월 12일 - 18일</p>
					<p>₩ 183,729 / 박</p>
					<p>게스트 한마디: 정말 예쁘고 깔끔한 곳....</p>
				</div>
			</div>
			<div class="accommodation">
				<span class="heart-icon" onclick="toggleHeart(this)">&#9825;</span>
				<img
					src="${pageContext.request.contextPath}/resources/image/image3.jpg"
					alt="숙소 이미지">
				<div class="details">
					<h3>한국 Gapyeong-eup, Gapyeo...</h3>
					<p>★ 4.6 한국 가평군</p>
					<p>4월 20일 - 25일</p>
					<p>₩ 303,553 / 박</p>
					<p>게스트 한마디: 장보고 바로 오기 편했어요...</p>
				</div>
			</div>
			<div class="accommodation">
				<span class="heart-icon" onclick="toggleHeart(this)">&#9825;</span>
				<img
					src="${pageContext.request.contextPath}/resources/image/image4.jpg"
					alt="숙소 이미지">
				<div class="details">
					<h3>한국 Okcheon-myeon, Yangp...</h3>
					<p>★ 4.86 한국 가평군</p>
					<p>5월 7일 - 12일</p>
					<p>₩ 184,871 / 박</p>
				</div>
			</div>
			<div class="accommodation">
				<span class="heart-icon" onclick="toggleHeart(this)">&#9825;</span>
				<img
					src="${pageContext.request.contextPath}/resources/image/image5.jpg"
					alt="숙소 이미지">
				<div class="details">
					<h3>한국 Gangha-myeon, Yangpy...</h3>
					<p>★ 4.95 한국 가평군</p>
					<p>6월 1일 - 6일</p>
					<p>₩ 155,376 / 박</p>
				</div>
			</div>
			<div class="accommodation">
				<span class="heart-icon" onclick="toggleHeart(this)">&#9825;</span>
				<img
					src="${pageContext.request.contextPath}/resources/image/image6.jpg"
					alt="숙소 이미지">
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