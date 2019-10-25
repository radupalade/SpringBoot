package com.sda.service;

import com.sda.dao.DepartmentDAO;
import com.sda.dto.DepartmentDTO;
import com.sda.model.Department;
import com.sda.repo.DepartmentRepo;
import com.sda.transfer.DepartmentMapper;
import com.sda.validator.DepartmentValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    DepartmentMapper departmentMapper = new DepartmentMapper();
    DepartmentRepo departmentRepo = new DepartmentRepo();
    DepartmentDAO departmentDAO = new DepartmentDAO();
    DepartmentValidator departmentValidator = new DepartmentValidator();

    public List<DepartmentDTO> displayDepartmentsDTO() {

        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName("HR");
        DepartmentDTO departmentDTO2 = new DepartmentDTO();
        departmentDTO2.setName("Marketing");
        DepartmentDTO departmentDTO3 = new DepartmentDTO();
        departmentDTO3.setName("Sales");

        departmentDTOList.add(departmentDTO);
        departmentDTOList.add(departmentDTO2);
        departmentDTOList.add(departmentDTO3);

        return departmentDTOList;
    }

    public DepartmentDTO insertDepartments(DepartmentDTO departmentDTO) {

        DepartmentDTO depDtoFromDb = null;
        if (departmentValidator.isNameValid(departmentDTO.getName())) {
            Department department = departmentMapper.convertDepartmentDTOtoDepartment(departmentDTO);
            if(departmentDTO == null) {
                System.out.println("dsgshfshsj");
            }
            Department depFromDb = departmentDAO.createEntityDepartment(department);
            depDtoFromDb = departmentMapper.convertDepartmentToDepartmentDto(depFromDb);
        }
        return depDtoFromDb;
    }


}
