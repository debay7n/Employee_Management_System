package com.brickred.employee.controller;
import com.brickred.employee.exception.EmployeeException;
import com.brickred.employee.model.Employee;
import com.brickred.employee.repository.EmployeeRepository;
import com.brickred.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;

@Controller
public class employeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/home")
    public String getStarted() {
        return "home";
    }

    @GetMapping("/find_page")
    public String findPage() {
        return "find";
    }


    @GetMapping("/employee_register")
    public String empReg() {
        return "register";
    }

    @GetMapping("/employee_update")
    public ModelAndView getAllEmpUpdate() {
        List<Employee> list = employeeRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("viewEmpUpdate");
        modelAndView.addObject("employee", list);
        return modelAndView;
    }

    @PostMapping("/register")
    public String registerEmployee(@ModelAttribute Employee employee) throws EmployeeException {
        employeeService.registerEmployee(employee);
        return "redirect:/employee_register";
    }

    //display all the employees for name
    @GetMapping("/search_Name")
    public ModelAndView getAllEmpName() {
        List<Employee> list = employeeRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("findByName");
        modelAndView.addObject("employee", list);
        return modelAndView;
    }

    //delete handler
    @GetMapping("/delete/{memberId}")
    public String deleteEmployee(@PathVariable("memberId") Integer memberId, RedirectAttributes redirectAttributes) {
        Optional<Employee> employeeOptional = this.employeeRepository.findById(memberId);
        Employee employee = employeeOptional.get();
        this.employeeRepository.delete(employee);
        redirectAttributes.addAttribute("success", "true");
        return "redirect:/search_Name";
    }


    //display all the employees for city
    @GetMapping("/search_city")
    public ModelAndView getAllEmpCity() {
        List<Employee> list = employeeRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("findByCity");
        modelAndView.addObject("employee", list);
        return modelAndView;
    }


    //display all the employees for state
    @GetMapping("/search_state")
    public ModelAndView getAllEmpState() {
        List<Employee> list = employeeRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("findByState");
        modelAndView.addObject("employee", list);
        return modelAndView;
    }


    //display all the employees for country
    @GetMapping("/search_country")
    public ModelAndView getAllEmpCountry() {
        List<Employee> list = employeeRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("findByCountry");
        modelAndView.addObject("employee", list);
        return modelAndView;
    }


    // display all employees by department
    @GetMapping("/search_dept")
    public ModelAndView getAllEmpDept() {
        List<Employee> list = employeeRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("findByDept");
        modelAndView.addObject("employee", list);
        return modelAndView;
    }

    // delete employee by department
    @GetMapping("/search_delete")
    public ModelAndView deleteEmployee() {
        List<Employee> list = employeeRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteEmp");
        modelAndView.addObject("employee", list);
        return modelAndView;
    }

    // update/ or edit an employee
    @GetMapping("/update/{memberID}")
    public String ShowUpdateEmployee(@PathVariable("memberID") Integer memberID, Model m)
    {
        m.addAttribute("title","update employee");
        Employee employee = this.employeeRepository.findById(memberID).get();
        m.addAttribute("employee", employee);
        return "editEmployee";
    }

    @PostMapping("/change")
    public String updateEmployee(@ModelAttribute Employee employee, Model m, Integer memberID) throws EmployeeException{
           Employee employee1 = employeeService.getEmployeeById(memberID);
           employeeService.updateEmployee(memberID, employee1);

        return "redirect:/search_Name";
    }
//    @PostMapping("/{memberID}/update_emp")
//    public String updateEmployee(@PathVariable("memberID") Integer memberID, @ModelAttribute("employee") Employee updatedEmployee) {
//        try {
//            employeeService.updateEmployee(memberID, updatedEmployee);
//        } catch (EmployeeException e) {
//            e.printStackTrace();
//        }
//        return "redirect:/viewEmpUpdate";
//    }


//    public String findEmployees(Model m, Employee employee) {
//        List <Employee> emp = this.employeeRepository.findAll();
//        m.addAttribute("Employee", emp);
//        return "/findByName";
//    }


//    @PostMapping
//    public Employee registerEmployee (@RequestBody EmployeeDto employeeDto) {
//        return EmployeeService.registerEmployee(employeeDto);
//    }
/*
        @GetMapping("/byid/{id}")
        public ResponseEntity<Employee> getbyId(@PathVariable Integer id) throws EmployeeException{
            Employee employee = employeeService.getbyId(id);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }

    @GetMapping("/getAllMembers")
    public ResponseEntity<List<Employee>> getallMember() throws EmployeeException{
        List<Employee> employee = employeeService.getallMember();
        return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<Void> UpdateEmployee(@PathVariable("memberId") Integer memberId, @Valid @RequestBody EmployeeDto employeeDto) throws EmployeeException {
        employeeService.UpdateEmployee(memberId, employeeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Employee> deleteEmployeebyID(@PathVariable("memberId") Integer memberId) throws EmployeeException {
     Employee e1 = employeeService.deleteEmployeebyID(memberId);
        return new ResponseEntity<Employee>( e1, HttpStatus.OK);
    }

    @GetMapping(params = {"name"})
    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam("name") String name) throws EmployeeException {
        List<Employee> employees = employeeService.getByName(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);*/
}

//    @GetMapping("/{mobile}")
//    public ResponseEntity<Employee> getEmployeesByMobile(@PathVariable("mobile") Long mobile) {
//       Employee e1= (Employee) employeeService.getEmployeesByMobile(mobile);
//        return new ResponseEntity<>(  e1  , HttpStatus.OK);
//    }
//
//    @GetMapping("/findbyMobileCity")
//    public ResponseEntity<Employee> getEmployeesByCityMobile (@RequestParam("mobile") Long mobile, @RequestParam("city") String city) {
//        Employee e1= (Employee) employeeService.getEmployeesByCityMobile(mobile, city);
//        return new ResponseEntity<>(  e1  , HttpStatus.OK);
//    }



