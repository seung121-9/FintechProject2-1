package com.test.Urban_Village.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Urban_Village.admin.dao.AdminDAOImpl;

@Service
public class AdminServiceImpl implements AdminService {
@Autowired 
AdminDAOImpl dao;
}
