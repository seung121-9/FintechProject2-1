package com.test.Urban_Village.accommodation.dto;

public class AccommodationDTO {

    private String accommodation_id;     // 숙소 고유번호
    private String admin_id;             // 관리자 ID
    private String accommodation_name;   // 숙소 이름
    private String accommodation_photo;  // 숙소 사진 경로
    private String cleaner_admin_id;     // 청소 관리자 ID
    private int capacity;                // 최대 인원 수
    private int room_count;              // 방 개수
    private int bathroom_count;          // 화장실 개수
    private int bed_count;               // 침대 수
    private String wifi_avail;           // 와이파이 유무
    private String review_data;          // 리뷰 데이터
    private int price;

    public String getAccommodation_id() {
        return accommodation_id;
    }
    public void setAccommodation_id(String accommodation_id) {
        this.accommodation_id = accommodation_id;
    }
    public String getAdmin_id() {
        return admin_id;
    }
    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }
    public String getAccommodation_name() {
        return accommodation_name;
    }
    public void setAccommodation_name(String accommodation_name) {
        this.accommodation_name = accommodation_name;
    }
    public String getAccommodation_photo() {
        return accommodation_photo;
    }
    public void setAccommodation_photo(String accommodation_photo) {
        this.accommodation_photo = accommodation_photo;
    }
    public String getCleaner_admin_id() {
        return cleaner_admin_id;
    }
    public void setCleaner_admin_id(String cleaner_admin_id) {
        this.cleaner_admin_id = cleaner_admin_id;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getRoom_count() {
        return room_count;
    }
    public void setRoom_count(int room_count) {
        this.room_count = room_count;
    }
    public int getBathroom_count() {
        return bathroom_count;
    }
    public void setBathroom_count(int bathroom_count) {
        this.bathroom_count = bathroom_count;
    }
    public int getBed_count() {
        return bed_count;
    }
    public void setBed_count(int bed_count) {
        this.bed_count = bed_count;
    }
    public String getWifi_avail() {
        return wifi_avail;
    }
    public void setWifi_avail(String wifi_avail) {
        this.wifi_avail = wifi_avail;
    }
    public String getReview_data() {
        return review_data;
    }
    public void setReview_data(String review_data) {
        this.review_data = review_data;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}