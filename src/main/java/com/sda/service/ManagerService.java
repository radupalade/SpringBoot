package com.sda.service;

import com.sda.dto.ManagerDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {

    public List<ManagerDTO> displayManagerDTO() {
        List<ManagerDTO> managerDTOList = new ArrayList<>();

        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setName("vasilica");
        managerDTO.setAge(33);
        managerDTO.setDepartamentName("marketing");
        managerDTO.setPosition("executive manager");

        ManagerDTO managerDTO2 = new ManagerDTO();
        managerDTO2.setName("mihaita");
        managerDTO2.setAge(34);
        managerDTO2.setDepartamentName("sales");
        managerDTO2.setPosition("key account");

        managerDTOList.add(managerDTO);
        managerDTOList.add(managerDTO2);

        return managerDTOList;
    }
    /*public EmployeeDTO insertEmployee(EmployeeDTO employeeDTO) {

        EmployeeDTO employeeDtoFromDb= null;
        if (employeeValidator.isNameValid(employeeDTO.getName())) {
            Employee employee = employeeMapper.convertEmployeeDtoToEmployee(employeeDTO);
            Employee empFromDb = employeeDAO.createEntity(employee);
            employeeDtoFromDb = employeeMapper.convertEmployeeToEmployeeDto(empFromDb);
        }
        return employeeDtoFromDb;
    }*/
}
