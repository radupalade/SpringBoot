package com.sda.dao;

import com.sda.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.sda.utils.HibernateUtils;


import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAO {
    public Employee addEmployee(Employee employee) {

        Employee employee1 = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(employee);
            System.out.println("Employee was creates with id: " + id);
            session.getTransaction().commit();
            if (id != null) {
                employee1 = session.get(Employee.class, id);
            } else {
                System.out.println("employee not created");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return employee1;
    }


    public List<Employee> displayAllEmployees() {

        return null;
    }

    public Employee createEntity(Employee entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
        return entity;
    }

    public List<Employee> displayEmployeesByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "FROM Employee WHERE name=:name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            employeeList = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return employeeList;

    }

    public List<Employee> displayEmployeesByNameAndPosition(String name, String position) {
        List<Employee> employeeList = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "FROM Employee WHERE name LIKE: name AND position=:position";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            query.setParameter("position", position);
            employeeList = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return employeeList;

    }

    public boolean deleteEmployee(String name) {
        boolean isDeleted = false;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
           /* String hql1 = "FROM Employee WHERE name=:name";
            Query query = session.createQuery(hql1);
            query.setParameter("name", name);
            List<Employee> employeeList = query.list();*/
           /*if (employeeList.size() > 1 || employeeList.size() == 0) {
                isDeleted = false;
            } else {
                session.delete(employeeList.get(0));
                isDeleted = true;
            }*/
            // String hql = "DELETE Employee WHERE name=:name";
            // Query query = session.createQuery(hql);
            //query.setParameter("name", name);

            String countHQL = "SELECT COUNT(*) FROM Employee where name =: name"; //numara intrarile din DB
            Query countQuery = session.createQuery(countHQL);
            countQuery.setParameter("name", name);
            Long countResult = (long) countQuery.uniqueResult(); //numarul de intrari
            System.out.println("count result = " + countResult);
            if (countResult != 1) { //daca avem o singura intrare in DB
                isDeleted = false; //daca avem mai multe sau nici una , nu mai stergem
            } else { //avem o singura intrare in DB
                String deleteHQL = "DELETE FROM Employee WHERE name =: name"; // sterge intrarea din DB cu numele trimis ca param
                Query deleteQuery = session.createQuery(deleteHQL);
                deleteQuery.setParameter("name", name);
                int result = deleteQuery.executeUpdate();//se executa query(in resul retinem nr de linii sterse)
                if (result != 0) { //s-a sters intrarea in DB
                    isDeleted = true;
                } else { // nu s-a sters
                    isDeleted = false;
                }
            }

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    public boolean deleteEmployeeByNameAndPosition(String name, String position) {
        boolean isDeleted = false;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            String countHQL = "SELECT COUNT(*) FROM Employee where name LIKE : name AND position=:position"; //numara intrarile din DB
            Query countQuery = session.createQuery(countHQL);
            countQuery.setParameter("name", name);
            countQuery.setParameter("position", position);
            Long countResult = (long) countQuery.uniqueResult(); //numarul de intrari
            System.out.println("count result = " + countResult);
            if (countResult != 1) { //daca avem o singura intrare in DB
                isDeleted = false; //daca avem mai multe sau nici una , nu mai stergem
            } else { //avem o singura intrare in DB
                String deleteHQL = "DELETE FROM Employee WHERE name LIKE: name AND position=: position"; // sterge intrarea din DB cu numele trimis ca param
                Query deleteQuery = session.createQuery(deleteHQL);
                deleteQuery.setParameter("name", name);
                deleteQuery.setParameter("position", position);
                int result = deleteQuery.executeUpdate();//se executa query(in resul retinem nr de linii sterse)
                if (result != 0) { //s-a sters intrarea in DB
                    isDeleted = true;
                } else { // nu s-a sters
                    isDeleted = false;
                }
            }

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    public Employee updateEmployee(String name, Employee employee) {
        Employee employeeUpdated = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String countHQL = "SELECT COUNT(*) FROM Employee WHERE name LIKE: name";
            Query queryCount = session.createQuery(countHQL);
            queryCount.setParameter("name", name);
            Long countResult = (Long) queryCount.uniqueResult();
            System.out.println("oount result: " + countResult);
            if (countResult != 1) {
                return null;
            } else {
                String updateHQL = "UPDATE Employee SET position=:position, age=:age WHERE name LIKE: name";
                Query queryUpdate = session.createQuery(updateHQL);
                queryUpdate.setParameter("position", employee.getPosition());
                queryUpdate.setParameter("age", employee.getAge());
                queryUpdate.setParameter("name", name);
                int resultUpdate = queryUpdate.executeUpdate();
                System.out.println("result update : " + resultUpdate);
                if (resultUpdate == 0) {
                    return null;
                } else {
                    employeeUpdated = new Employee();
                    String selectHQL = "FROM Employee WHERE name LIKE:name";
                    Query querySelect = session.createQuery(selectHQL);
                    querySelect.setParameter("name", name);
                    List<Employee> employeeList = querySelect.list();
                    employeeUpdated = employeeList.get(0);
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return employeeUpdated;
    }
}
