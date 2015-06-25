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
import th.co.geniustree.dental.angular.model.User;
import th.co.geniustree.dental.angular.repo.AuthorityRepo;
import th.co.geniustree.dental.angular.repo.BankAccountRepo;
import th.co.geniustree.dental.angular.repo.ContactpersionRepo;
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

    @RequestMapping(value = "/users")
    public Page<User> getUser(Pageable pageable) {
        return userRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/authoritytest")
    public Page<Authority> getauthority(Pageable pageable) {
        return authorityRepo.findAll(pageable);
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
    
      @RequestMapping(value = "/authoritysave", method = RequestMethod.POST)
    public void saveAuthority( @RequestBody Authority authority) {
        authorityRepo.save(authority);
    }
      @RequestMapping(value = "/bankAccountsave", method = RequestMethod.POST)
    public void saveBankAccount( @RequestBody BankAccount bankAccount) {
        bankAccountRepo.save(bankAccount);
    }
      @RequestMapping(value = "/contactPersionsave", method = RequestMethod.POST)
    public void saveAuthority( @RequestBody ContactPersion contactPersion ) {
        contactpersionRepo.save(contactPersion);
    }
}
