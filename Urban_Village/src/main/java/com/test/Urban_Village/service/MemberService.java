package com.test.Urban_Village.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Urban_Village.dao.MemberDAO;
import com.test.Urban_Village.dto.MemberDTO;

@Service
public class MemberService {
		@Autowired
		private MemberDAO dao;
		
	
		public List<MemberDTO> listMembers() {
			// TODO Auto-generated method stub
			return dao.listMembers();
		}


		public MemberDTO login(String id, String pwd) {
		    MemberDTO member = new MemberDTO();
		    member.setId(id);
		    member.setPwd(pwd);
		    return dao.login(member); // DB에서 해당 정보를 조회
		}


	

	}
