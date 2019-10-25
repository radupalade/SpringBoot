package com.sda.main;

import com.sda.dto.EmployeeDTO;
import com.sda.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sda.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    EmployeeService employeeService = new EmployeeService();

    @RequestMapping("/employees")
    @ResponseBody
    public ResponseEntity displayEmployees() {
        List<EmployeeDTO> employeeDTOList = employeeService.displayEmployeeDTO();

        return new ResponseEntity(employeeDTOList, HttpStatus.OK);

    }

    @PostMapping(path = "/addEmployee", produces = "application/json", consumes = "application/json  ")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO employeeDTO1 = employeeService.insertEmployee(employeeDTO);
        return employeeDTO1;
    }

    @GetMapping("/findEmployee/{name}")
    public List<EmployeeDTO> getEmplpoyeeByName(@PathVariable String name) {
        System.out.println("numele folosit la cautare este: " + name);
        List<EmployeeDTO> employeeDTOList = employeeService.displayEmployeeDTOByName(name);
        return employeeDTOList;
    }

    @GetMapping("/findEmployees/name/{name}/position/{position}")
    public List<EmployeeDTO> getEmplpoyeeByNameAndPosition(@PathVariable String name, @PathVariable String position) {
        System.out.println("numele folosit la cautare este: " + name + " iar pozitia : " + position);
        List<EmployeeDTO> employeeDTOList = employeeService.displayEmployeeDTOByNameAndPosition(name, position);
        return employeeDTOList;
    }

    @DeleteMapping("/deleteEmployee/{name}")
    public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name) {
        boolean isDeleted = employeeService.deleteEmployees(name);
        if (!isDeleted) {
            return new ResponseEntity<>("s-au gasit mai multi cu acelasi nume,sau nici unul", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("s-a sters cu succes", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteEmployees/name/{name}/position/{position}")
    public ResponseEntity<String> deleteEmployeeByNameAndPosition(@PathVariable String name, @PathVariable String position) {
        boolean isDeleted = employeeService.deleteEmployeesByNameAndPosition(name, position);
        if (!isDeleted) {
            return new ResponseEntity<>("s-au gasit mai multi cu acelasi nume ,sau niciunul", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("s-a sters cu succes", HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/updateEmployee/name/{name}", consumes = "application/json", produces = "application/json")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable String name) {
        System.out.println(name);
        System.out.println(employeeDTO.getPosition() + " " + employeeDTO.getName());

        EmployeeDTO employeeDTOUpdated = employeeService.updateEmployee(name, employeeDTO);
        return employeeDTOUpdated;
    }

}
