package com.test.Urban_Village.accommodation.service;

import java.util.List;

import com.test.Urban_Village.accommodation.dto.AccommodationDTO;

public interface AccommodationService {



	List<AccommodationDTO> accList();
	AccommodationDTO findAccommodationById();
	String addAccommodation(AccommodationDTO dto);


}
