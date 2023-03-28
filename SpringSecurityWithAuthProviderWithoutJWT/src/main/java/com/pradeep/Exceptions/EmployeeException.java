package com.pradeep.Exceptions;

public class EmployeeException extends  RuntimeException{

    public EmployeeException(){

    }
    public EmployeeException(String mes){
        super(mes);
    }

}
