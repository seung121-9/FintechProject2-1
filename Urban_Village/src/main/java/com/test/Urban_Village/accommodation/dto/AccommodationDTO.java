package com.test.Urban_Village.accommodation.dto;

public class AccommodationDTO {
	
	    private String accommodationId;      // ���� ������ȣ
	    private String adminId;              // ������ ID
	    private String accommodationName;    // ���� �̸�
	    private String accommodationPhoto;   // ���� ���� ���
	    private String cleanerAdminId;       // û�� ������ ID
	    private int capacity;                // �ִ� �ο� ��
	    private int roomCount;               // �� ����
	    private int bathroomCount;           // ȭ��� ����
	    private int bedCount;                // ħ�� ��
	    private String wifiAvail;            // �������� ����
	    private String reviewData;           // ���� ������
	    
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
