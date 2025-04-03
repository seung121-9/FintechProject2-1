package com.test.Urban_Village.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Urban_Village.member.dao.MemberDAO;
import com.test.Urban_Village.member.dao.MemberDAOImpl;
import com.test.Urban_Village.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
		@Autowired
		MemberDAO dao;
		
		@Override
		public List<MemberDTO> listMembers() {
			// TODO Auto-generated method stub
			return dao.listMembers();
		}

		@Override
		public MemberDTO login(String id, String pwd) {
		    MemberDTO member = new MemberDTO();
		    member.setId(id);
		    member.setPwd(pwd);
		    return dao.login(member); // DB에서 해당 정보를 조회
		}

		@Override
	      public int addMember(MemberDTO member) {
	         // TODO Auto-generated method stub
	         return dao.addMember(member);
	      }
	

	}
