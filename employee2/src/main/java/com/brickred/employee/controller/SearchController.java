package com.brickred.employee.controller;

import com.brickred.employee.model.Employee;
import com.brickred.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private EmployeeRepository employeeRepository;

//    @GetMapping("/search/{query}")
//    public ResponseEntity<?> searchName(@PathVariable("query") String query){
//        System.out.println(query);
//        List<Employee> searchEmp = this.employeeRepository.findByNameContaining(query);
//        return ResponseEntity.ok(searchEmp);
//    }
//
//    @GetMapping("/searchCity/{query}")
//    public ResponseEntity<?> searchCity(@PathVariable("query") String query) {
//        System.out.println(query);
//        List<Employee> searchEmp = this.employeeRepository.findByCityContaining(query);
//        return ResponseEntity.ok(searchEmp);
//    }
//
//    @GetMapping("/searchState/{query}")
//    public ResponseEntity<?> searchState(@PathVariable("query") String query) {
//        System.out.println(query);
//        List<Employee> searchEmp = this.employeeRepository.findByCityContaining(query);
//        return ResponseEntity.ok(searchEmp);
//    }
//
//    @GetMapping("/searchCountry/{query}")
//    public ResponseEntity<?> searchCountry(@PathVariable("query") String query) {
//        System.out.println(query);
//        List<Employee> searchEmp = this.employeeRepository.findByCityContaining(query);
//        return ResponseEntity.ok(searchEmp);
//    }
//
//    @GetMapping("/searchDelete/{query}")
//    public ResponseEntity<?> deleteEmp(@PathVariable("query") String query) {
//        System.out.println(query);
//        List<Employee> searchEmp = this.employeeRepository.findByCityContaining(query);
//        return ResponseEntity.ok(searchEmp);
//    }
//
//    @GetMapping("/searchDept/{query}")
//    public ResponseEntity<?> searchDept(@PathVariable("query") String query) {
//        System.out.println(query);
//        List<Employee> searchEmp = this.employeeRepository.findByCityContaining(query);
//        return ResponseEntity.ok(searchEmp);
//    }

}
