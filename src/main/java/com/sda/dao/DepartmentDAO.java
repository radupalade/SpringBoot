package com.sda.dao;

import com.sda.model.Department;
import com.sda.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDAO {

    public List<Department> displayAllDepartments() {

        return null;
    }
    public Department createEntityDepartment(Department entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
        return entity;
    }
}
