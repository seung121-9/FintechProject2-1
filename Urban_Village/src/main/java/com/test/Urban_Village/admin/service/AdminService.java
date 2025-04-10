package com.test.Urban_Village.admin.service;

import java.util.List;

import com.test.Urban_Village.admin.dto.AdminDTO;
import com.test.Urban_Village.cleaner.dto.CleanerDTO;

public interface AdminService {
	public AdminDTO login(String id, String pwd);
	boolean checkIfUserIdExists(String adminId);
	public List<CleanerDTO> getCleanerList();
	public CleanerDTO getCleanerDetail(String memberId);
	public List<String> getAccCleanerId();
}
