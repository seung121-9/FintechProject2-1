package com.test.Urban_Village.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Urban_Village.admin.dao.AdminDAO;
import com.test.Urban_Village.admin.dao.AdminDAOImpl;
import com.test.Urban_Village.admin.dto.AdminDTO;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired 
	AdminDAO dao;

	@Override
	public AdminDTO login(String id, String pwd) {
		// TODO Auto-generated method stub
		AdminDTO admin = new AdminDTO();
		admin.setAdmin_id(id);
		admin.setPwd(pwd);
		return dao.login(admin);
	}

	@Override
	public boolean checkIfUserIdExists(String adminId) {
		// TODO Auto-generated method stub
		return dao.checkIfUserIdExists(adminId);
	}
}
