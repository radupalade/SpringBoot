package com.sda.main;

import com.sda.dto.DepartmentDTO;
import com.sda.model.Department;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sda.service.DepartmentService;

import java.util.List;

@RestController
public class DepartmentController {
    DepartmentService departmentService = new DepartmentService();

    @RequestMapping("/departments")
    @ResponseBody
    public ResponseEntity displayDepartments() {
        List<DepartmentDTO> departmentDTOList = departmentService.displayDepartmentsDTO();

        return new ResponseEntity(departmentDTOList, HttpStatus.OK);
    }

    @PostMapping(path = "/addDepartment", produces = "application/json", consumes = "application/json  ")
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO departmentDTO1 = departmentService.insertDepartments(departmentDTO);
        return departmentDTO1;
    }
}
