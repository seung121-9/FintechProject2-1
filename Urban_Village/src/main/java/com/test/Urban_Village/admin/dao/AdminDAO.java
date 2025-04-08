package com.test.Urban_Village.admin.dao;

import com.test.Urban_Village.admin.dto.AdminDTO;

public interface AdminDAO {
	public AdminDTO login(AdminDTO admin);
	boolean checkIfUserIdExists(String userId);
}
