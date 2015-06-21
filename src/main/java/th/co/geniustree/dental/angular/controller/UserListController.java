/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.dental.angular.model.User;
import th.co.geniustree.dental.angular.repo.UserRepo;

/**
 *
 * @author kekhuay
 */
@RestController
public class UserListController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = "/users/search")
    public Page<User> searchByNameTHOrEmail(@RequestParam String keyword, Pageable pageable) {
        return userRepo.findByNameTHOrEmail(keyword, keyword, pageable);
    }
}
