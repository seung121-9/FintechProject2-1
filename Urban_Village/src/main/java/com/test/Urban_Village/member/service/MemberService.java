package com.test.Urban_Village.member.service;

import java.util.List;

import com.test.Urban_Village.member.dto.MemberDTO;

public interface MemberService {
	public List<MemberDTO> listMembers();
	public MemberDTO login(String id, String pwd);
	public int addMember(MemberDTO member);
}
