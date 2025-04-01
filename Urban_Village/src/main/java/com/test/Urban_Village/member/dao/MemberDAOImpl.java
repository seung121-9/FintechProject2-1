package com.test.Urban_Village.member.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.Urban_Village.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession; // MyBatis�쓽 SqlSession�쓣 �옄�룞 二쇱엯
	
	@Override
	public List<MemberDTO> listMembers() {
		// �쉶�썝 紐⑸줉 議고쉶 荑쇰━ �떎�뻾
		return sqlSession.selectList("mapper.member.listMembers");
	}

	@Override
	public MemberDTO memberDetail(String id) {
		// �듅�젙 �쉶�썝 �젙蹂� 議고쉶 荑쇰━ �떎�뻾
		return sqlSession.selectOne("mapper.member.memberDetail", id);
	}

	@Override
	public int delMember(String id) {
		// �쉶�썝 �궘�젣 荑쇰━ �떎�뻾
		return sqlSession.delete("mapper.member.delMember", id);
	}

	@Override
	public int addMember(MemberDTO member) {
		// �쉶�썝 媛��엯 荑쇰━ �떎�뻾
		return sqlSession.insert("mapper.member.addMember", member);
	}

	@Override
	public int modMember(MemberDTO member) {
		// �쉶�썝 �젙蹂� �닔�젙 荑쇰━ �떎�뻾
		return sqlSession.update("mapper.member.modMember", member);
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		// 濡쒓렇�씤 荑쇰━ �떎�뻾 (ID, PWD �솗�씤)
		return sqlSession.selectOne("mapper.member.login", member);
	}

	@Override
	public void saveOpenAIRequest(String inputText, String responseText) {
		// TODO Auto-generated method stub
		
	}
}
