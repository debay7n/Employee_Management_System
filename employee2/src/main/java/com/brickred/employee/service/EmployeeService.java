package com.brickred.employee.service;
import com.brickred.employee.exception.EmployeeException;
import com.brickred.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    public void registerEmployee(Employee employee) throws EmployeeException;

    public void updateEmployee(Integer id, Employee updatedEmployee) throws EmployeeException;

    public Employee getEmployeeById(Integer id) throws EmployeeException;
    public List<Employee> getallMember() throws EmployeeException;
    public Employee deleteEmployeebyID(Integer id) throws EmployeeException;




}





