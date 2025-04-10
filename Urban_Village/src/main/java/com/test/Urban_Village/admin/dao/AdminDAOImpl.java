package com.test.Urban_Village.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.Urban_Village.admin.dto.AdminDTO;
import com.test.Urban_Village.cleaner.dto.CleanerDTO;

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

	@Override
	public List<CleanerDTO> selectCleanerList() {
		// TODO Auto-generated method stub
		return session.selectList("mapper.cleaner.selectCleanerList");
	}

	@Override
	public CleanerDTO selectCleanerDetail(String member_id) {
		// TODO Auto-generated method stub
		return session.selectOne("mapper.cleaner.selectCleanerDetail", member_id);
	}

	@Override
	public List<String> getAccCleanerId() {
		// TODO Auto-generated method stub
		return session.selectList("mapper.cleaner.getAccCleanerId");
	}

}
