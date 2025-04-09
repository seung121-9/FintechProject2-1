package com.test.Urban_Village.accommodation.service;

import java.util.List;
import java.util.Map;

import com.test.Urban_Village.accommodation.dto.AccommodationDTO;

public interface AccommodationService {



	List<AccommodationDTO> accList();
	AccommodationDTO findAccommodationId(String accommodationId);
	String addAccommodation(AccommodationDTO dto);
	String addNewAccommodation(Map<String, Object> accommodationMap);


}
