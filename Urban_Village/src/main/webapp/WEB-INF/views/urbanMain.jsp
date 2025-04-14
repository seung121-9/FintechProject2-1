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
    font-size: 20px;
    cursor: pointer;
    color: lightgray;
}
.heart-icon.liked {
    color: red;
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
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
const contextPath = '${contextPath}';

/* function toggleWishlist(element, memberId, accommodationId) {
    $.ajax({
        url: contextPath + '/wishList/check.do',
        method: 'POST',
        data: {
            memberId: memberId,
            accommodationId: accommodationId
        },
        success: function(response) {
            if (response === "true") {
                // 이미 찜한 상태면 제거
                removeFromWishlist(memberId, accommodationId, element);
            } else {
                // 찜 안한 상태면 추가
                addToWishlist(memberId, accommodationId, element);
            }
        },
        error: function() {
            alert("찜 처리 중 오류가 발생했습니다.");
        }
    });
}

function addToWishlist(memberId, accommodationId, element) {
    $.ajax({
        url:contextPath +  '/wishList/add.do',
        method: 'POST',
        data: {
            memberId: memberId,
            accommodationId: accommodationId
        },
        success: function(response) {
            if (response == "1") {
                // 찜 성공 시 하트 아이콘 상태 변경
                $(element).addClass("liked").html("&#9829;"); // ♥
            }
        },
        error: function() {
            alert("찜 추가 중 오류 발생");
        }
    });
}

function removeFromWishlist(memberId, accommodationId, element) {
    $.ajax({
        url: contextPath + '/wishList/remove.do',
        method: 'POST',
        data: {
            memberId: memberId,
            accommodationId: accommodationId
        },
        success: function(response) {
            if (response == "1") {
                // 찜 제거 시 하트 아이콘 원래대로
                $(element).removeClass("liked").html("&#9825;"); // ♡
            }
        },
        error: function() {
            alert("찜 삭제 중 오류 발생");
        }
    });
} */
function toggleWishlist(element, memberId, accommodationId) {
    $.ajax({
        url: contextPath + '/wishList/check.do',
        method: 'POST',
        data: {
            memberId: memberId,
            accommodationId: accommodationId
        },
        success: function(response) {
            if (response === "true") {
                // 이미 찜한 상태면 제거
                removeFromWishlist(memberId, accommodationId, element);
            } else {
                // 찜 안한 상태면 추가
                addToWishlist(memberId, accommodationId, element);
            }
        },
        error: function() {
            alert("찜 처리 중 오류가 발생했습니다.");
        }
    });
}

function addToWishlist(memberId, accommodationId, element) {
    $.ajax({
        url: contextPath + '/wishList/add.do',
        method: 'POST',
        data: {
            memberId: memberId,
            accommodationId: accommodationId
        },
        success: function(response) {
            if (response == "1") {
                // 찜 성공 시 하트 아이콘 상태 변경
                $(element).addClass("liked").html("&#9829;"); // ♥
                alert("위시리스트에 추가되었습니다."); // 추가 성공 메시지
            }
        },
        error: function() {
            alert("찜 추가 중 오류 발생");
        }
    });
}

function removeFromWishlist(memberId, accommodationId, element) {
    $.ajax({
        url: contextPath + '/wishList/remove.do',
        method: 'POST',
        data: {
            memberId: memberId,
            accommodationId: accommodationId
        },
        success: function(response) {
            if (response == "1") {
                // 찜 제거 시 하트 아이콘 원래대로
                $(element).removeClass("liked").html("&#9825;"); // ♡
                alert("위시리스트에서 제거되었습니다."); // 삭제 성공 메시지
            }
        },
        error: function() {
            alert("찜 삭제 중 오류 발생");
        }
    });
}


</script>
<head>
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
                <span class="heart-icon ${accommodation.liked ? 'liked' : ''}"
      onclick="event.stopPropagation(); toggleWishlist(this, '${loginId}', '${accommodation.accommodation_id}')">
    &#10084;
</span>
            <a href="${pageContext.request.contextPath}/accommodation/accommodationPage.do?accommodation_id=${accommodation.accommodation_id}&accommodation_name=${accommodation.accommodation_name} ">

                    <c:set var="imageStr" value="${accommodation.accommodation_photo}" />
                    <c:set var="images" value="${fn:split(imageStr, ',')}" />
                    <img src="${contextPath}/download.do?imageFileName=${images[0]}&accommodation_id=${accommodation.accommodation_id}&timestamp=<%= System.currentTimeMillis() %>"
                         alt="${accommodation.accommodation_name}" style="max-width: 200px; margin: 5px;">
                    <div class="details">
                       <c:forEach var="bestAcc" items="${hostBestAccIdList}">
    						<c:if test="${accommodation.accommodation_id eq bestAcc.accommodation_id}">
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
</div>
</body>
</html>