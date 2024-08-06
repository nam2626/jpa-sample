package model.service;

import model.dao.MemberDAO;
import model.entity.Member;

import java.util.List;

public class MemberService {
    private static MemberService instance = new MemberService();

    private MemberDAO memberDao;

    private MemberService() {
        this.memberDao = new MemberDAO();
    }

    public static MemberService getInstance() {
        return instance;
    }

    public void close() {
        memberDao.close();
    }

    public void insertMember(Member member) {
        memberDao.insertMember(member);
    }

    public Member selectMember(String memberId) {
        return memberDao.selectMember(memberId);
    }

    public void updateMember(Member member) {
        memberDao.updateMember(member);
    }

    public void deleteMember(String memberId) {
        memberDao.deleteMember(memberId);
    }

    public void updateMemberGrade(String memberId, int gradeNo) {
        memberDao.updateMemberGrade(memberId, gradeNo);
    }

    //전체 회원 데이터 리턴
    public List<Member> getMemberList() {
        return memberDao.getMemberList();
    }


    public List<Member> searhMember(String name) {
        return memberDao.searchNameMemberList(name);
    }
}
