package com.test.Urban_Village.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.test.Urban_Village.member.dto.MemberDTO;

@Mapper
public interface MemberDAO {
	// 紐⑤뱺 �쉶�썝 紐⑸줉 議고쉶
	List<MemberDTO> listMembers();
	
	// �듅�젙 �쉶�썝 �젙蹂� 議고쉶
	MemberDTO memberDetail(String id);
	
	// �쉶�썝 �궘�젣
	int delMember(String id);
	
	// �쉶�썝 異붽�
	int addMember(MemberDTO member);
	
	// �쉶�썝 �젙蹂� �닔�젙
	int modMember(MemberDTO member);
	
	// 濡쒓렇�씤 (ID, PWD 寃�利�)
	MemberDTO login(MemberDTO member);
	
	// OpenAI �슂泥� 諛� �쓳�떟 ���옣 荑쇰━
    void saveOpenAIRequest(@Param("inputText") String inputText, @Param("responseText") String responseText);
}
