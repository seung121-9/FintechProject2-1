package com.test.Urban_Village.member.dao;

import java.sql.Date;
import java.util.List;

import com.test.Urban_Village.member.dto.MemberDTO;
import com.test.Urban_Village.member.dto.PayDTO;

public interface MemberDAO {
	public List<MemberDTO> listMembers();
	public MemberDTO login(MemberDTO member);
	public int addMember(MemberDTO member);
	public boolean checkIfUserIdExists(String userId);
	public void addPay(PayDTO payDto);
	public List<PayDTO> payList();
	public List<MemberDTO> getUserInfoById(String id);
	public int updateUserInfo(MemberDTO member);
	public List<PayDTO> reservationGetUserId(String loginId);
}
