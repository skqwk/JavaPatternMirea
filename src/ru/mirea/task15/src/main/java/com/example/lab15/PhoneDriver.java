package com.example.lab15;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public class PhoneDriver implements Driver<Phone>{

    private final SessionFactory sessionFactory;
    private Session session;

    public PhoneDriver(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Phone phone) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(phone);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Phone> readAll() {
        session = sessionFactory.openSession();
        List<Phone> phones = session.createQuery("select i from Phone i", Phone.class).getResultList();
        session.close();
        return phones;
    }

    @Override
    public Phone read(long id) {
        session = sessionFactory.openSession();
        Phone phone = session.createQuery("from Phone where id = :id", Phone.class).setParameter("id", id).getSingleResult();
        session.close();
        return phone;
    }

    @Override
    public boolean update(Phone phone, long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update Phone set name=:n, creationYear=:y where id = :id")
                .setParameter("id", id)
                        .setParameter("y", phone.getCreationYear())
                                .setParameter("n", phone.getName());
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Phone where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }
}
