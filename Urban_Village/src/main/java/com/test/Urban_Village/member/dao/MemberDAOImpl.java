package com.test.Urban_Village.member.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.Urban_Village.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
@Autowired
SqlSession sqlSession;
	
	@Override
	public List<MemberDTO> listMembers() {
		// TODO Auto-generated method stub
		List<MemberDTO> membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.member.login", member);
	}
	@Override
	   public int addMember(MemberDTO member) {
	      // TODO Auto-generated method stub
	      return sqlSession.insert("mapper.member.join",member);
	   }
	@Override
    public boolean checkIfUserIdExists(String userId) {
        int count = sqlSession.selectOne("mapper.member.countMemberById", userId);
        return count > 0;
    }

	@Override
	public List<MemberDTO> getUserInfoById(String id) {
		// TODO Auto-generated method stub
		List<MemberDTO> memberList = sqlSession.selectList("mapper.member.getUserInfoById",id);
		return memberList;
	}

}
