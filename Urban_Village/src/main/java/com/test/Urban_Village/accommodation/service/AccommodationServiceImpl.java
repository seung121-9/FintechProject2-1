package com.test.Urban_Village.accommodation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Urban_Village.accommodation.dao.AccommodationDAO;
import com.test.Urban_Village.accommodation.dao.AccommodationDAOImpl;
import com.test.Urban_Village.accommodation.dto.AccommodationDTO;

@Service
public class AccommodationServiceImpl implements AccommodationService {
@Autowired 
AccommodationDAO dao;

@Override
public List<AccommodationDTO> accList() {
	// TODO Auto-generated method stub
	return dao.accList();
}
@Override
public AccommodationDTO findAccommodationId(String accommodationId) {
    return dao.findAccommodationId(accommodationId);
}
@Override
public String addAccommodation(AccommodationDTO dto) {
   
    int result = dao.addAcommodation(dto);
    String generatedId = dao.getLastInsertedAccommodationId();
    
 
    return (result > 0) ? generatedId : null;
}

}
