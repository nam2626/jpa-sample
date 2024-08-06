package config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.entity.Grade;

public class GradeSettingMain {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("member");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(new Grade(1, "Bronze"));
        em.persist(new Grade(2, "Silver"));
        em.persist(new Grade(3, "Gold"));
        em.persist(new Grade(4, "Platinum"));
        em.persist(new Grade(5, "Diamond"));
        em.getTransaction().commit();

        em.close();
        factory.close();
    }

}
