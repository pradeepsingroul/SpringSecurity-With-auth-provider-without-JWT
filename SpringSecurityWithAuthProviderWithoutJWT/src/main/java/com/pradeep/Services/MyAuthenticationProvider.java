package com.pradeep.Services;


import com.pradeep.Model.Employee;
import com.pradeep.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password  = authentication.getCredentials().toString();

        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(email);
        if(optionalEmployee.isPresent()){
           Employee employee1 = optionalEmployee.get();
           if(passwordEncoder.matches(password,employee1.getPassword())){
               List<GrantedAuthority> authorities = new ArrayList<>();
               return new UsernamePasswordAuthenticationToken(email,password,authorities);
           }else throw  new BadCredentialsException("Invalid password");
        }else{
            throw new BadCredentialsException("User does not exits with the email :"+email);
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
