package com.sda.validator;

public class EmployeeValidator {
    public boolean isNameValid(String name) {
        if (name == null) {
            return false;
        }
        if (name.isEmpty()) {
            return false;
        }
        if (!name.matches("([A-Z a-z)]*)")) {
            return false;
        }
        return true;
    }


    public boolean isPositionValid(String position) {

        if (position == null) {
            return false;
        }
        if (position.isEmpty()) {
            return false;
        }
        if (!position.matches("([A-Z a-z)]*)")) {
            return false;
        }
        return true;
    }

    public boolean isAgeValid(int age) {
        if (age < 0) {
            return false;
        }
        if (age > 100) {
            return false;
        }
        return true;
    }
}
