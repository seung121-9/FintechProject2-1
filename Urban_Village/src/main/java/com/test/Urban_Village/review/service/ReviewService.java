package com.test.Urban_Village.review.service;

import java.util.List;
import java.util.Map;

import com.test.Urban_Village.review.dto.ReviewDTO;

public interface ReviewService {


	String addReviewAndGetId(Map<String, Object> reviewMap) throws Exception;

	List<ReviewDTO> getReviewsByAccommodationId(String accommodation_id);

	


}
