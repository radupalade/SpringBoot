package com.sda.dao;

import com.sda.model.Manager;
import com.sda.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ManagerDAO {

    public List<Manager> displayAllManagers() {

        return null;
    }

    public Manager createEntityManagers(Manager entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
        return entity;
    }
}
