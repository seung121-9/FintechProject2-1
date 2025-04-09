package com.test.Urban_Village.cleaner.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.Urban_Village.cleaner.dto.CleanerDTO;

@Repository
public class CleanerDAOImpl implements CleanerDAO {

	@Autowired
	private SqlSession session;

	@Override
	public void insertCleaner(Map<String, Object> cleanerMap) {
	    session.insert("mapper.cleaner.insertCleaner", cleanerMap);
	}




}
