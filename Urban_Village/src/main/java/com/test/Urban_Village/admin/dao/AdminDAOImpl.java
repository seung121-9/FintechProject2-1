package com.test.Urban_Village.admin.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.Urban_Village.admin.dto.AdminDTO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Autowired 
	SqlSession session;

	@Override
	public AdminDTO login(AdminDTO admin) {
		// TODO Auto-generated method stub
		return session.selectOne("mapper.admin.login",admin);
	}

	@Override
	public boolean checkIfUserIdExists(String adminId) {
		// TODO Auto-generated method stub
		int count = session.selectOne("mapper.admin.countAdminById",adminId);
		return false;
	}

}
