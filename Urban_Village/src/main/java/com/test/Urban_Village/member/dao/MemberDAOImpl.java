package com.test.Urban_Village.member.dao;

import java.sql.Date;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.Urban_Village.member.dto.MemberDTO;
import com.test.Urban_Village.member.dto.PayDTO;

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
	public void addPay(PayDTO payDto) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.member.addPay", payDto);
	}
	
	
}
