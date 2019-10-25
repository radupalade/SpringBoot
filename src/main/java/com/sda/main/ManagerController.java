package com.sda.main;

import com.sda.dto.ManagerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sda.service.ManagerService;

import java.util.List;

@RestController
public class ManagerController {

    ManagerService managerService = new ManagerService();

    @RequestMapping("/managers")
    @ResponseBody
    public ResponseEntity displayManagers() {
        List<ManagerDTO> managerDTOList = managerService.displayManagerDTO();

        return new ResponseEntity(managerDTOList, HttpStatus.OK);

    }
   /* @PostMapping(path = "/addManager", produces = "application/json", consumes = "application/json  ")
    public ManagerDTO addManager(@RequestBody ManagerDTO managerDTO) {
        ManagerDTO managerDTO1 = managerService.insertManager(managerDTO);
        return managerDTO1;
    }*/
}
