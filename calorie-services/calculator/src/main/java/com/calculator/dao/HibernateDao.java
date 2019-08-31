package com.calculator.dao;

import java.io.Serializable;
import java.util.List;

import com.calculator.annotations.DBTransaction;
import com.calculator.annotations.TransactionType;

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
    public List<T> findAll() {
       return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}