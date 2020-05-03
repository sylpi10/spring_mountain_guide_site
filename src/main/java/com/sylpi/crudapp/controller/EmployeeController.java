package com.sylpi.crudapp.controller;

import com.sylpi.crudapp.entity.Employee;
import com.sylpi.crudapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> allEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{theId}")
    public Employee findById(@PathVariable int theId) {
        Employee employee = employeeService.findById(theId);
        if (employee == null){
            throw new RuntimeException("no result");
        }
            return employee;
    }


    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);

        employeeService.save(theEmployee);
        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")

    public String deleteEmployee(@PathVariable int id){
       Employee tempEmployee = employeeService.findById(id);

       // throw exception if null
        if (tempEmployee == null){
            throw new RuntimeException("no result");
        }
         employeeService.deleteById(id);
        return "Deleted employee with id " + id;
    }

}
