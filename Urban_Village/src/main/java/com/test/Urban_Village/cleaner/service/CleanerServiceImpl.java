package com.test.Urban_Village.cleaner.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Urban_Village.cleaner.dao.CleanerDAO;
import com.test.Urban_Village.cleaner.dto.CleanerDTO;

@Service
public class CleanerServiceImpl implements CleanerService {

	@Autowired
	CleanerDAO dao;


	@Override
	public void addCleaner(Map<String, Object> cleanerMap) {
	    dao.insertCleaner(cleanerMap);
	}






}
