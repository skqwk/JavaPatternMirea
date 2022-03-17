package com.example.task17;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PhoneDAO implements Driver<Phone>{
    EntityManager em;
    private final SessionFactory sessionFactory;
    private Session session;

    @Autowired
    public PhoneDAO(SessionFactory sessionFactory, EntityManager em) {
        this.em = em;
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Phone> readAll() {
        session = sessionFactory.openSession();
        List<Phone> phones = session.createQuery("select i from Phone i", Phone.class).getResultList();
        for (Phone phone : phones) Hibernate.initialize(phone.getManufactures());
        session.close();
        return phones;
    }

    @Override
    public Phone read(long id) {
        session = sessionFactory.openSession();
        Phone phone = session.createQuery("from Phone where id = :id", Phone.class).setParameter("id", id).getSingleResult();
        Hibernate.initialize(phone.getManufactures());
        session.close();
        return phone;
    }

    List<Phone> findPhonesByYear(String year) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Phone> cq = cb.createQuery(Phone.class);

        Root<Phone> phone = cq.from(Phone.class);
        Predicate addressPredicate = cb.equal(phone.get("creationYear"), year);
        cq.where(addressPredicate);
        TypedQuery<Phone> query = em.createQuery(cq);
        return query.getResultList();
    }
}
