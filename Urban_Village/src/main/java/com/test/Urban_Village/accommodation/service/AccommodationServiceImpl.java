package com.test.Urban_Village.accommodation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Urban_Village.accommodation.dao.AccommodationDAO;
import com.test.Urban_Village.accommodation.dao.AccommodationDAOImpl;

@Service
public class AccommodationServiceImpl implements AccommodationService {
@Autowired AccommodationDAOImpl dao;
	
}
