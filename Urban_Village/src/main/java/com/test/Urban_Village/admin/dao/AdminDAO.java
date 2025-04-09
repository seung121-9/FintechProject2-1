package com.test.Urban_Village.admin.dao;

import java.util.List;

import com.test.Urban_Village.admin.dto.AdminDTO;
import com.test.Urban_Village.cleaner.dto.CleanerDTO;

public interface AdminDAO {
	public AdminDTO login(AdminDTO admin);
	boolean checkIfUserIdExists(String userId);
	public List<CleanerDTO> selectCleanerList();
	public CleanerDTO selectCleanerDetail(String member_id);
}
