package com.brickred.employee.service;
import com.brickred.employee.exception.EmployeeException;
import com.brickred.employee.model.Employee;
import com.brickred.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void registerEmployee(Employee employee) throws EmployeeException {
        employeeRepository.save(employee);
    }


    public Employee getEmployeeById(Integer id) throws EmployeeException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeException("Employee not found"));
    }

    public void updateEmployee(Integer id, Employee updatedEmployee) throws EmployeeException {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeException("Employee not found"));

        existingEmployee.setMemberId(updatedEmployee.getMemberId());
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setMobile(updatedEmployee.getMobile());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setCity(updatedEmployee.getCity());
        existingEmployee.setState(updatedEmployee.getState());
        existingEmployee.setCountry(updatedEmployee.getCountry());
        existingEmployee.setPinCode(updatedEmployee.getPinCode());


        employeeRepository.save(existingEmployee);
    }

    @Override
    public List<Employee> getallMember() throws EmployeeException {
        return null;
    }

    @Override
    public Employee deleteEmployeebyID(Integer id) throws EmployeeException {
        return null;
    }


}


