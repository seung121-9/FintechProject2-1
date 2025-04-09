package com.test.Urban_Village.accommodation.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Urban_Village.accommodation.dao.AccommodationDAO;
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
    String generatedId = dao.getLastInsertedAccommodationId2();
    
 
    return (result > 0) ? generatedId : null;
}
@Override
public String addNewAccommodation(Map<String, Object> accommodationMap) {
    int result = dao.insertAccommodation(accommodationMap);
    if (result > 0) {
        return dao.getLastInsertedAccommodationId();
    }
    return null;
}


}
