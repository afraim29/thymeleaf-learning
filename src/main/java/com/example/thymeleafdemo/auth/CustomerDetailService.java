package com.example.thymeleafdemo.auth;

import com.example.thymeleafdemo.model.Employee;
import com.example.thymeleafdemo.repo.EmployeeRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailService implements UserDetailsService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = employeeRepo.findByEmail(email);
        if (employee == null){
            throw new UsernameNotFoundException("Email Not Found!");
        }
        return new CustomDetails(employee);
    }
}
