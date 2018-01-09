package com.netcracker;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Buyer> getAll() {
        CriteriaQuery<Buyer> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Buyer.class);
        criteriaQuery.from(Buyer.class);
        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
    }

    public Buyer getById(int id) {
        return sessionFactory.getCurrentSession().get(Buyer.class, id);
    }

    public void create(Buyer buyer) {
        sessionFactory.getCurrentSession().persist(buyer);
    }

    public boolean deleteAll() {
        List<Buyer> list = getAll();
        for(Buyer buyer:list) {
            if (buyer==null) return false;
            deleteById(buyer.getId());
        }
        return true;
    }

    public boolean deleteById(int id) {
        Buyer buyer = getById(id);
        if (buyer==null) return false;
        sessionFactory.getCurrentSession().delete(buyer);
        return true;
    }
}

