package com.sda.repo;

import com.sda.dao.DepartmentDAO;
import com.sda.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepo {

    public DepartmentDAO departmentDAO;

    public List<Department> displayAllDepartments() {
        List<Department> departmentList = departmentDAO.displayAllDepartments();
        return departmentList;
    }
}
