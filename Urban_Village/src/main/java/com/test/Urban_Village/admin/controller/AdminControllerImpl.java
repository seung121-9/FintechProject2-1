package com.test.Urban_Village.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.test.Urban_Village.admin.service.AdminService;
import com.test.Urban_Village.admin.service.AdminServiceImpl;

@Controller
public class AdminControllerImpl implements AdminController {
@Autowired 
AdminServiceImpl service;
}
