package com.calculator.dao;

import java.io.Serializable;
import java.util.List;

import com.calculator.annotations.DBTransaction;
import com.calculator.annotations.TransactionType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateDao<T extends Serializable> {
    @Autowired
    protected SessionFactory sessionFactory;
    
    protected Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    @DBTransaction(type = TransactionType.READ)
    public List<T> findAllByName(String exp, String fieldName) {
        Query query = getCurrentSession()
                .createQuery("from " + clazz.getName() + " where " + fieldName + " like :searchField");
        query.setString("searchField", "%" + exp + "%");
        return query.list();
    }

    @DBTransaction(type = TransactionType.READ)
    public List<T> findAll() {
        Query query = getCurrentSession()
                .createQuery("from " + clazz.getName());
        return query.list();
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}