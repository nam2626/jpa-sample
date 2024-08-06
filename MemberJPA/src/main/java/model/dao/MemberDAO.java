package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.entity.Member;

import java.util.List;

public class MemberDAO {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("member");
    EntityManager em = factory.createEntityManager();

    public void close() {
    	em.close();
    	factory.close();
    }

    public void insertMember(Member member) {
    	em.getTransaction().begin();
    	em.persist(member);
    	em.getTransaction().commit();
    }

    public Member selectMember(String memberId) {
    	return em.find(Member.class, memberId);
    }

    public void updateMember(Member member) {
    	em.getTransaction().begin();
    	em.merge(member);
    	em.getTransaction().commit();
    }

    public void deleteMember(String memberId) {
    	em.getTransaction().begin();
    	Member member = em.find(Member.class, memberId);
    	em.remove(member);
    	em.getTransaction().commit();
    }

    public void updateMemberGrade(String memberId, int gradeNo) {
    	em.getTransaction().begin();
    	Member member = em.find(Member.class, memberId);
    	member.setGradeNo(gradeNo);
        em.merge(member);
    	em.getTransaction().commit();
    }

    public List<Member> getMemberList() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> searchNameMemberList(String name) {
        return em.createQuery("select m from Member m where m.memberName like '%' || :name || '%'", Member.class).setParameter("name", name).getResultList();
    }
}
