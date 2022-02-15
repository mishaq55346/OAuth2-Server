package ru.mikhail.oauth2server.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.mikhail.oauth2server.model.DisplayablePerson;
import ru.mikhail.oauth2server.model.Person;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    @Resource
    private SessionFactory sessionFactory;
    @Transactional
    public Person getElement(String name, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from Person where name= :name " + "and password= :password")
                .setParameter("name", name)
                .setParameter("password", password);
        return (Person) q.list().get(0);
    }
    @Transactional
    public Person getElement(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from Person where name= :name")
                .setParameter("name", name);
        return (Person) q.list().get(0);
    }
    @Transactional
    public void addElement(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    @Transactional
    public void deleteElement(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("DELETE from Person " +
                "where name=:name and password=:password")
                .setParameter("name", person.getName())
                .setParameter("password", person.getPassword())
                .executeUpdate();
    }

    public List<DisplayablePerson> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("SELECT p.name,p.enabled, p.roles, p.permissions  from Person p");

        List<Object[]> rows = q.list();
        List<DisplayablePerson> list = new ArrayList<>();
        for (Object[] objects : rows)
            list.add(new DisplayablePerson(
                    (String)objects[0],
                    (boolean)objects[1],
                    (String)objects[2],
                    (String)objects[3]
            ));
        return list;
    }
}
