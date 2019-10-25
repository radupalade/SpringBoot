package com.sda.dto;

public class ManagerDTO extends EmployeeDTO {

    private String departamentName;

    public String getDepartamentName() {
        return departamentName;
    }

    public void setDepartamentName(String departamentName) {
        this.departamentName = departamentName;
    }

    @Override
    public String toString() {
        return "ManagerDTO{" + super.getName() + "pozitia:  " + super.getPosition() + " are varsta: " + super.getAge() +
                "departamentName='" + departamentName + '\'' +
                '}';
    }
}
