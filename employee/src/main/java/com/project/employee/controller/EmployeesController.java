package com.project.employee.controller;

import com.project.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.project.commonModule.models.Employees;


@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeeService employeeService;

    @GetMapping("/read")
    public List<Employees> readEmployees(){
        return employeeService.viewEmployees();
    }

    @PostMapping
    public List<Employees> createEmployees(@RequestBody List<Employees> employees){
        return employeeService.createEmployees(employees);
    }

    @DeleteMapping
    public void deleteEmployees(@RequestBody List<String> employeesNames){

        employeeService.deleteEmployees(employeesNames);
    }
}
