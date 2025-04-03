package com.test.Urban_Village.member.dao;

import java.util.List;

import com.test.Urban_Village.member.dto.MemberDTO;

public interface MemberDAO {
	public List<MemberDTO> listMembers();
	public MemberDTO login(MemberDTO member);
	public int addMember(MemberDTO member);
	boolean checkIfUserIdExists(String userId);
}
