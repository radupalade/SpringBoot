package com.sda.repo;

import com.sda.dao.EmployeeDAO;
import com.sda.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepo {

    EmployeeDAO employeeDAO = new EmployeeDAO();

    public List<Employee> displayAllEmployees() {
        List<Employee> employeeList = employeeDAO.displayAllEmployees();
        return employeeList;
    }

    public List<Employee> displayEmployeesByName(String name) {
        List<Employee> employeeList = employeeDAO.displayEmployeesByName(name);
        return employeeList;

    }

    public List<Employee> displayEmployeesByNameAndPosition(String name, String position) {
        List<Employee> employeeList = employeeDAO.displayEmployeesByNameAndPosition(name, position);
        return employeeList;
    }

    public boolean deleteEmployee(String name) {
        return employeeDAO.deleteEmployee(name);
    }

    public boolean deleteEmployeeByNameAndPosition(String name, String position) {
        return employeeDAO.deleteEmployeeByNameAndPosition(name, position);
    }

    public Employee updateEmployee(String name, Employee employee) {
        return employeeDAO.updateEmployee(name, employee);
    }
/*
    public Employee createEmployee(Employee employee) {
        Employee employee1 = employeeDAO.createEmployee(employee);
        return employee1;
    }
*/
}
