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
import th.co.geniustree.dental.angular.model.User;
import th.co.geniustree.dental.angular.repo.UserRepo;

/**
 *
 * @author Best
 */
@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

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
}
