package com.sda.transfer;

import com.sda.dto.DepartmentDTO;
import com.sda.model.Department;

public class DepartmentMapper {
    public DepartmentDTO convertDepartmentToDepartmentDto(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(department.getName());

        return departmentDTO;
    }

    public Department convertDepartmentDTOtoDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());

        return department;
    }
}
