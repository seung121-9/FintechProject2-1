package com.test.Urban_Village.member.service;

import java.util.List;
import com.test.Urban_Village.member.dto.MemberDTO;

public interface MemberService {
	
	//DAO瑜� �샇異쒗븯�뿬 鍮꾩쫰�땲�뒪 濡쒖쭅�쓣 泥섎━�븯�뒗 �뿭�븷�쓣 �븳�떎.
	List<MemberDTO> listMembers();
	MemberDTO memberDetail(String id);
	int delMember(String id);
	int addMember(MemberDTO member);
	int modMember(MemberDTO member);
	MemberDTO login(MemberDTO member);
	void saveOpenAIRequest(String inputText, String responseText);
}
