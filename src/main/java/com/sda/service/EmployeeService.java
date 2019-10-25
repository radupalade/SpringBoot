package com.sda.service;

import com.sda.dao.EmployeeDAO;
import com.sda.dto.EmployeeDTO;
import com.sda.model.Employee;
import org.springframework.stereotype.Service;
import com.sda.repo.EmployeeRepo;
import com.sda.transfer.EmployeeMapper;
import com.sda.validator.EmployeeValidator;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    EmployeeMapper employeeMapper = new EmployeeMapper();
    EmployeeRepo employeeRepo = new EmployeeRepo();
    EmployeeDAO employeeDAO = new EmployeeDAO();
    EmployeeValidator employeeValidator = new EmployeeValidator();


    public List<EmployeeDTO> displayEmployeeDTO() {

        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("mihai");
        employeeDTO.setAge(24);
        employeeDTO.setPosition("noob");

        EmployeeDTO employeeDTO2 = new EmployeeDTO();
        employeeDTO2.setName("vasile");
        employeeDTO2.setAge(44);
        employeeDTO2.setPosition("noob2");

        EmployeeDTO employeeDTO3 = new EmployeeDTO();
        employeeDTO3.setName("mihail");
        employeeDTO3.setAge(34);
        employeeDTO3.setPosition("manager");
        employeeDTOList.add(employeeDTO);
        employeeDTOList.add(employeeDTO2);
        employeeDTOList.add(employeeDTO3);

        return employeeDTOList;


    }

    public EmployeeDTO insertEmployee(EmployeeDTO employeeDTO) {

        EmployeeDTO employeeDtoFromDb = null;
        if (employeeValidator.isNameValid(employeeDTO.getName())) {
            Employee employee = employeeMapper.convertEmployeeDtoToEmployee(employeeDTO);
            Employee empFromDb = employeeDAO.createEntity(employee);
            employeeDtoFromDb = employeeMapper.convertEmployeeToEmployeeDto(empFromDb);
        }
        return employeeDtoFromDb;
    }

    public List<EmployeeDTO> displayEmployeeDTOByName(String name) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        if (employeeValidator.isNameValid(name)) {
            List<Employee> employeeList = employeeRepo.displayEmployeesByName(name);
            for (Employee employee : employeeList) {
                employeeDTOList.add(employeeMapper.convertEmployeeToEmployeeDto(employee));
            }
        } else {
            System.out.println("datele nu sunt valide");
        }
        return employeeDTOList;


    }

    public List<EmployeeDTO> displayEmployeeDTOByNameAndPosition(String name, String position) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        if (employeeValidator.isNameValid(name) && employeeValidator.isPositionValid(position)) {
            List<Employee> employeeList = employeeRepo.displayEmployeesByNameAndPosition(name, position);
            for (Employee employee : employeeList) {
                employeeDTOList.add(employeeMapper.convertEmployeeToEmployeeDto(employee));
            }
        } else {
            System.out.println("datele(name or position) nu sunt valide");
        }
        return employeeDTOList;
    }

    public boolean deleteEmployees(String name) {
        boolean isDeleted = false;
        if (employeeValidator.isNameValid(name)) {
            isDeleted = employeeRepo.deleteEmployee(name);
        }
        if (isDeleted) {
            System.out.println("employee was deleted! ");
        } else {
            System.out.println("employee was not deleted! ");
        }
        return isDeleted;
    }

    public boolean deleteEmployeesByNameAndPosition(String name, String position) {
        boolean isDeleted = false;
        if (employeeValidator.isNameValid(name) && employeeValidator.isPositionValid(position)) {
            isDeleted = employeeRepo.deleteEmployeeByNameAndPosition(name, position);
        }
        if (isDeleted) {
            System.out.println("employee was deleted! ");
        } else {
            System.out.println("employee ws not deleted");
        }
        return isDeleted;
    }

    public EmployeeDTO updateEmployee(String name, EmployeeDTO employeeDTO) {
        EmployeeDTO employeeDTOUpdated = null;
        if (employeeValidator.isNameValid(name) && employeeValidator.isPositionValid(employeeDTO.getPosition()) &&
                employeeValidator.isAgeValid(employeeDTO.getAge())) {
            Employee employee = employeeMapper.convertEmployeeDtoToEmployee(employeeDTO);
            employeeDTOUpdated = employeeMapper.convertEmployeeToEmployeeDto(employeeRepo.updateEmployee(name, employee));


        } else {
            System.out.println("data entered not valid! ");
        }
        return employeeDTOUpdated;
    }
}
