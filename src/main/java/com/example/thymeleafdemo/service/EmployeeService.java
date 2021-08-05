package com.example.thymeleafdemo.service;

import com.example.thymeleafdemo.model.Employee;
import com.example.thymeleafdemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, PasswordEncoder passwordEncoder) {
        this.employeeRepo = employeeRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerEmployee(Employee employee) {
        String encodedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encodedPassword);
        employee.setRole("USER");
        employeeRepo.save(employee);
    }

    public String login(Employee employee) {
        Employee getEmployeeByEmail = employeeRepo.findByEmail(employee.getEmail());
        System.out.println(getEmployeeByEmail);
        return "Okay";
    }

    public List<Employee> retrieveAllEmployee() {
        return employeeRepo.findAll();
    }


}
