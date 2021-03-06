/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import th.co.geniustree.dental.angular.repo.EmployeeRepo;


/**
 *
 * @author Employee
 */
@Service
public class MyUserDetailService implements UserDetailsService{
    @Autowired
    private EmployeeRepo employeeRepo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       UserDetails user = employeeRepo.findByEmail(username);
       return user;
    }
}
