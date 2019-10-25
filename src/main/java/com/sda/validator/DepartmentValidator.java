package com.sda.validator;

public class DepartmentValidator {
    public boolean isNameValid(String name){
        if(name==null){
            return false;
        }
        if(name.isEmpty()){
            return false;
        }
        if(!name.matches("([A-Z a-z)]*)")){
            return false;
        }
        return true;
    }
}
