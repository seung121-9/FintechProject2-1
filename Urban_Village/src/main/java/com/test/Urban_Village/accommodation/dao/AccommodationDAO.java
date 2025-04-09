package com.test.Urban_Village.accommodation.dao;

import java.util.List;
import java.util.Map;

import com.test.Urban_Village.accommodation.dto.AccommodationDTO;

public interface AccommodationDAO {

	List<AccommodationDTO> accList();

	AccommodationDTO findAccommodationId(String accommodationId);

	int addAcommodation(AccommodationDTO dto);


	String getLastInsertedAccommodationId();

	int insertAccommodation(Map<String, Object> accommodationMap);

	String getLastInsertedAccommodationId2();

	


}
