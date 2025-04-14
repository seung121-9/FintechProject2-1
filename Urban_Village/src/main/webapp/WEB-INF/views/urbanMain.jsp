<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />

<title></title>
<style>
.heart-icon {
    cursor: pointer;
    font-size: 20px;
    color: lightgray; /* 기본 하트 색상 */
}

.heart-icon.liked {
    color: red; /* 찜했을 때 하트 색상 */
}

.accommodation {
    border: 1px solid #ccc;
    padding: 10px;
    margin-bottom: 10px;
    display: flex;
    align-items: center;
}

.accommodation > a {
    display: flex;
    align-items: center;
    text-decoration: none;
    color: black;
}

.accommodation img {
    max-width: 100px;
    margin-right: 10px;
}

.details {
    flex-grow: 1;
}

.categories-container {
    margin-bottom: 20px;
}

.categories a {
    display: inline-block;
    padding: 5px 10px;
    margin-right: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
    text-decoration: none;
    color: black;
}
@keyframes blink {
  0% { opacity: 1; }
  50% { opacity: 0; }
  100% { opacity: 1; }
}

.blink-text {
  color: red;
  animation: blink 1s infinite;
}
</style>

<script>
    function toggleWishlist(icon, memberId, accommodationId) {
        event.stopPropagation(); // 부모 요소의 onclick 이벤트 막기

        let isLiked = icon.classList.contains("liked");
        let url = isLiked ? "${contextPath}/wishList/remove.do" : "${contextPath}/wishList/add.do";

        $.ajax({
            url: url,
            type: "POST",
            data: {
                memberId: memberId,
                accommodationId: accommodationId
            },
            success: function(response) {
                if (response === "1") {
                    icon.classList.toggle("liked");
                    icon.innerHTML = isLiked ? "&#9825;" : "&#9829;";
                    let message = isLiked ? "위시리스트에서 제거되었습니다." : "위시리스트에 추가되었습니다.";
                    alert(message);
                } else if (response === "0") {
                    let message = isLiked ? "위시리스트 제거에 실패했습니다." : "위시리스트 추가에 실패했습니다.";
                    alert(message);
                } else {
                    alert("로그인 후 이용해주세요.");
                }
            },
            error: function(error) {
                console.error("Error toggling wishlist:", error);
                alert("서버와 통신 중 오류가 발생했습니다.");
            }
        });
    }

    $(document).ready(function() {
        // 페이지 로딩 시 각 숙소의 찜 여부 확인
        $(".accommodation").each(function() {
            let accommodationId = $(this).data("accommodation-id");
            let heartIcon = $(this).find(".heart-icon");
            let memberId = "${loginId}"; // 세션에서 로그인 아이디 가져오기

            if (memberId) {
                $.ajax({
                    url: "${contextPath}/wishList/check.do",
                    type: "GET",
                    data: {
                        memberId: memberId,
                        accommodationId: accommodationId
                    },
                    success: function(response) {
                        if (response === "true") {
                            heartIcon.addClass("liked");
                            heartIcon.html("&#9829;");
                        }
                    },
                    error: function(error) {
                        console.error("Error checking wishlist:", error);
                    }
                });
            }
        });
    });
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
        <div class="accommodation"
             onclick="location.href='${contextPath}/accommodation/accommodationPage.do?accommodation_id=${accommodation.accommodation_id}'"
             data-accommodation-id="${accommodation.accommodation_id}">
            <a href="${pageContext.request.contextPath}/accommodation/accommodationPage.do?accommodation_id=${accommodation.accommodation_id}&accommodation_name=${accommodation.accommodation_name} ">
                <span class="heart-icon"
                      onclick="event.stopPropagation(); toggleWishlist(this, '${loginId}', '${accommodation.accommodation_id}')">&#9825;</span>
                    <c:set var="imageStr" value="${accommodation.accommodation_photo}" />
                    <c:set var="images" value="${fn:split(imageStr, ',')}" />
                    <img src="${contextPath}/download.do?imageFileName=${images[0]}&accommodation_id=${accommodation.accommodation_id}&timestamp=<%= System.currentTimeMillis() %>"
                         alt="${accommodation.accommodation_name}" style="max-width: 200px; margin: 5px;">
                    <div class="details">
                        <c:forEach var="bestAcc" items="${sessionScope.hostBestAccIdList}">
    						<c:if test="${accommodation.accommodation_id == bestAcc.accommodation_id}">
               					 <p class="blink-text">★ 호스트 추천 숙소 ★</p>
            				</c:if>
						</c:forEach>
                        <h3>${accommodation.accommodation_name}</h3>
                        <p>★ 5.0 </p>
                        <p>₩ ${accommodation.price} / 박</p>
                    </div>
            </a>
        </div>
    </c:forEach>
</div>
</body>
</html>