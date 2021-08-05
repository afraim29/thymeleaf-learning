package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Employee;
import com.example.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, PasswordEncoder passwordEncoder) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String showForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "registration_form";
    }

    @GetMapping("/all")
    public String retrieveAllEmployee(Model model){
        model.addAttribute("employees", employeeService.retrieveAllEmployee());
        return "retrieve_employees";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("employee") Employee employee){
        employeeService.registerEmployee(employee);
        return "register_success";
    }
    

}
