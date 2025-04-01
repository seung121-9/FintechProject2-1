package com.test.Urban_Village.dto;

public class AccommodationDTO {
	
	    private String accommodationId;      // 숙소 고유번호
	    private String adminId;              // 관리자 ID
	    private String accommodationName;    // 숙소 이름
	    private String accommodationPhoto;   // 숙소 사진 경로
	    private String cleanerAdminId;       // 청소 관리자 ID
	    private int capacity;                // 최대 인원 수
	    private int roomCount;               // 방 개수
	    private int bathroomCount;           // 화장실 개수
	    private int bedCount;                // 침대 수
	    private String wifiAvail;            // 와이파이 유무
	    private String reviewData;           // 리뷰 데이터
	    
	    public String getAccommodationId() {
	        return accommodationId;
	    }

	    public void setAccommodationId(String accommodationId) {
	        this.accommodationId = accommodationId;
	    }

	    public String getAdminId() {
	        return adminId;
	    }

	    public void setAdminId(String adminId) {
	        this.adminId = adminId;
	    }

	    public String getAccommodationName() {
	        return accommodationName;
	    }

	    public void setAccommodationName(String accommodationName) {
	        this.accommodationName = accommodationName;
	    }

	    public String getAccommodationPhoto() {
	        return accommodationPhoto;
	    }

	    public void setAccommodationPhoto(String accommodationPhoto) {
	        this.accommodationPhoto = accommodationPhoto;
	    }

	    public String getCleanerAdminId() {
	        return cleanerAdminId;
	    }

	    public void setCleanerAdminId(String cleanerAdminId) {
	        this.cleanerAdminId = cleanerAdminId;
	    }

	    public int getCapacity() {
	        return capacity;
	    }

	    public void setCapacity(int capacity) {
	        this.capacity = capacity;
	    }

	    public int getRoomCount() {
	        return roomCount;
	    }

	    public void setRoomCount(int roomCount) {
	        this.roomCount = roomCount;
	    }

	    public int getBathroomCount() {
	        return bathroomCount;
	    }

	    public void setBathroomCount(int bathroomCount) {
	        this.bathroomCount = bathroomCount;
	    }

	    public int getBedCount() {
	        return bedCount;
	    }

	    public void setBedCount(int bedCount) {
	        this.bedCount = bedCount;
	    }

	    public String getWifiAvail() {
	        return wifiAvail;
	    }

	    public void setWifiAvail(String wifiAvail) {
	        this.wifiAvail = wifiAvail;
	    }

	    public String getReviewData() {
	        return reviewData;
	    }

	    public void setReviewData(String reviewData) {
	        this.reviewData = reviewData;
	    }
	}
