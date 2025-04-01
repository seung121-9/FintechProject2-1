package com.test.Urban_Village.dto;

public class AdminDTO {

	    private String adminId;           // 관리자 ID
	    private String pwd;               // 비밀번호
	    private String email;             // 이메일
	    private String name;              // 관리자 이름
	    private String phoneNumber;       // 관리자 전화번호
	    private String organization;      // 소속 기관
	    private String location;          // 소속 위치
	    
	    public String getAdminId() {
	        return adminId;
	    }

	    public void setAdminId(String adminId) {
	        this.adminId = adminId;
	    }

	    public String getPwd() {
	        return pwd;
	    }

	    public void setPwd(String pwd) {
	        this.pwd = pwd;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public String getOrganization() {
	        return organization;
	    }

	    public void setOrganization(String organization) {
	        this.organization = organization;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }
	}

