package com.test.Urban_Village.accommodation.dto;


public class AccommodationIdDTO {
    
    private String adminId;           // 관리자의 ID
    private String accommodationId;   // 숙소의 고유 ID
    
    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(String accommodationId) {
        this.accommodationId = accommodationId;
    }
}
