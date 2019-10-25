package com.sda.repo;

import com.sda.dao.ManagerDAO;
import com.sda.model.Manager;

import java.util.List;

public class ManagerRepo {

    public ManagerDAO managerDAO;

    public List<Manager> displayAllManagers() {
        List<Manager> managerList = managerDAO.displayAllManagers();
        return managerList;
    }
}
