package com.test.Urban_Village.member.service;

import java.sql.Date;
import java.util.List;

import com.test.Urban_Village.member.dto.MemberDTO;
import com.test.Urban_Village.member.dto.PayDTO;

public interface MemberService {
	public List<MemberDTO> listMembers();
	public MemberDTO login(String id, String pwd);
	public int addMember(MemberDTO member);
	boolean checkIfUserIdExists(String userId);
	public void addPay(PayDTO payDto);
	public List<PayDTO> payList();
	public List<MemberDTO> getUserInfoById(String id);
	int updateUserInfo(MemberDTO member);
	public List<PayDTO> reservationGetUserId(String loginId);
	int deleteMember(String id);
	List<PayDTO> getDailySales();
	List<PayDTO> getMonthlySales();
	List<PayDTO> getYearlySales();
}