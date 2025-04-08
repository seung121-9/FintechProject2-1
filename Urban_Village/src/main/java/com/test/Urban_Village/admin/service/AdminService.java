package com.test.Urban_Village.admin.service;

import com.test.Urban_Village.admin.dto.AdminDTO;

public interface AdminService {
	public AdminDTO login(String id, String pwd);
	boolean checkIfUserIdExists(String adminId);
}
