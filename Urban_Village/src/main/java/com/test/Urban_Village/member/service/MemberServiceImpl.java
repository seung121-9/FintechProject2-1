package com.test.Urban_Village.member.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.Urban_Village.member.dao.MemberDAO;
import com.test.Urban_Village.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;  // MemberDAO瑜� 二쇱엯諛쏆븘 �궗�슜

    @Override
    public List<MemberDTO> listMembers() {
        return memberDAO.listMembers();
    }

    @Override
    public MemberDTO memberDetail(String id) {
        return memberDAO.memberDetail(id);
    }

    @Override
    public int delMember(String id) {
        return memberDAO.delMember(id);
    }

    @Override
    public int addMember(MemberDTO member) {
        return memberDAO.addMember(member);
    }

    @Override
    public int modMember(MemberDTO member) {
        return memberDAO.modMember(member);
    }

    @Override
    public MemberDTO login(MemberDTO member) {
        return memberDAO.login(member);
    }

    @Override
    public void saveOpenAIRequest(String inputText, String responseText) {
        // MyBatis瑜� �씠�슜�븯�뿬 OpenAI �슂泥� 諛� �쓳�떟�쓣 DB�뿉 ���옣
        memberDAO.saveOpenAIRequest(inputText, responseText);
    }
}
