package com.example.task16;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public class ManufactureDriver implements Driver<Manufacture>{
    private final SessionFactory sessionFactory;
    private Session session;

    public ManufactureDriver(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Manufacture m) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(m);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Manufacture> readAll() {
        session = sessionFactory.openSession();
        List<Manufacture> manufactures = session.createQuery("select i from Manufacture i", Manufacture.class).getResultList();
        session.close();
        return manufactures;
    }

    @Override
    public Manufacture read(long id) {
        session = sessionFactory.openSession();
        Manufacture manufacture = session.createQuery("from Manufacture where id = :id", Manufacture.class).setParameter("id", id).getSingleResult();
        session.close();
        return manufacture;
    }

    @Override
    public boolean update(Manufacture manufacture, long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update Manufacture set name=:n, address=:a where id = :id")
                .setParameter("id", id)
                .setParameter("a", manufacture.getAddress())
                .setParameter("n", manufacture.getName());
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
        Query q = session.createQuery("delete from Manufacture where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }
}
