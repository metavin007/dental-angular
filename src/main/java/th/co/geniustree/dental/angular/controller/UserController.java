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
import th.co.geniustree.dental.angular.model.Authority;
import th.co.geniustree.dental.angular.model.BankAccount;
import th.co.geniustree.dental.angular.model.ContactPersion;
import th.co.geniustree.dental.angular.model.Department;
import th.co.geniustree.dental.angular.model.User;
import th.co.geniustree.dental.angular.repo.AuthorityRepo;
import th.co.geniustree.dental.angular.repo.BankAccountRepo;
import th.co.geniustree.dental.angular.repo.ContactpersionRepo;
import th.co.geniustree.dental.angular.repo.DepartmentRepo;
import th.co.geniustree.dental.angular.repo.UserRepo;

/**
 *
 * @author Best
 */
@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AuthorityRepo authorityRepo;
    @Autowired
    private BankAccountRepo bankAccountRepo;
    @Autowired
    private ContactpersionRepo contactpersionRepo;
    @Autowired
    private DepartmentRepo departmentRepo;

    @RequestMapping(value = "/users")
    public Page<User> getUser(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @RequestMapping(value = "/userssave", method = RequestMethod.POST)
    public void saveUser(@Validated @RequestBody User user) {
        userRepo.save(user);
    }

    @RequestMapping(value = "/usersdelete", method = RequestMethod.POST)
    public void deleteUser(@RequestBody User user) {
        userRepo.delete(user);
    }
    @RequestMapping(value = "/users/search", method = RequestMethod.POST)
    public Page<User> searchUser(@RequestBody String keyword, Pageable pageable) {
        return userRepo.findByNameTHOrEmail(keyword, keyword, pageable);
    }
    
    @RequestMapping(value = "/Allsave")
    public void saveAll(@Validated @RequestBody User user,BankAccount bankAccount,ContactPersion contactPersion,Department department){
       userRepo.save(user);
       bankAccountRepo.save(bankAccount);
       contactpersionRepo.save(contactPersion);
       departmentRepo.save(department);
    }
    
}
