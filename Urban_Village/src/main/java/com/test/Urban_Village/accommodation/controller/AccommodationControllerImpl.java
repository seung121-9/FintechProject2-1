package com.test.Urban_Village.accommodation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.test.Urban_Village.accommodation.service.AccommodationService;

@Controller
public class AccommodationControllerImpl implements AccommodationController {
@Autowired
AccommodationService service;



}
