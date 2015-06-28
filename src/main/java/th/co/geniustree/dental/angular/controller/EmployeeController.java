/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.dental.angular.model.Employee;
import th.co.geniustree.dental.angular.repo.EmployeeRepo;

/**
 *
 * @author Best
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;
   

    @RequestMapping(value = "/employees")
    public Page<Employee> getUser(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }

    @RequestMapping(value = "/employeessave", method = RequestMethod.POST)
    public void saveUser(@Validated @RequestBody Employee user) {
        employeeRepo.save(user);
    }

    @RequestMapping(value = "/employeesdelete", method = RequestMethod.POST)
    public void deleteUser(@RequestBody Employee user) {
        employeeRepo.delete(user);
    }

    @RequestMapping(value = "/employees/search", method = RequestMethod.POST)
    public Page<Employee> searchUser(@RequestBody String keyword, Pageable pageable) {
        return employeeRepo.findByNameTHOrEmail(keyword, keyword, pageable);
    }

}
