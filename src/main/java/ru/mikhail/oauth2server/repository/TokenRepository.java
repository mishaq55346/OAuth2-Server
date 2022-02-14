package ru.mikhail.oauth2server.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.mikhail.oauth2server.model.MyToken;
import ru.mikhail.oauth2server.model.Person;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Repository
public class TokenRepository {
    @Resource
    private SessionFactory sessionFactory;

    public MyToken getElement(Person p, String token_type) {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from MyToken where userId=:userId and token_type=:type")
                .setParameter("userId", p.getId())
                .setParameter("type", token_type);
        return (MyToken) q.list().get(0);
    }
    public MyToken getElement(int userId, String token_type) {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from MyToken where userId=:userId and token_type=:type")
                .setParameter("userId", userId)
                .setParameter("type", token_type);
        return (MyToken) q.list().get(0);
    }

    public void addElement(MyToken token) {
        Session session = sessionFactory.getCurrentSession();
        session.save(token);
    }

    @Transactional
    public void deleteElement(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("DELETE from MyToken " +
                "where userId=:userId")
                .setParameter("userId", person.getId())
                .executeUpdate();
    }
    @Transactional
    public void deleteElement(int userId) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("DELETE from MyToken " +
                "where userId=:userId")
                .setParameter("userId", userId)
                .executeUpdate();
    }

    public MyToken getElement(String token) {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from MyToken where token=:token")
                .setParameter("token", token);
        return (MyToken) q.list().get(0);
    }
}