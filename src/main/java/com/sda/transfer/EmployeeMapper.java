package com.sda.transfer;

import com.sda.dto.EmployeeDTO;
import com.sda.model.Employee;

public class EmployeeMapper {

    public EmployeeDTO convertEmployeeToEmployeeDto(Employee employee) {
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setName(employee.getName());
        employeeDto.setAge(employee.getAge());
        employeeDto.setPosition(employee.getPosition());
        return employeeDto;
    }

    public Employee convertEmployeeDtoToEmployee(EmployeeDTO employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employee.setPosition(employeeDto.getPosition());
        return employee;
    }
}
