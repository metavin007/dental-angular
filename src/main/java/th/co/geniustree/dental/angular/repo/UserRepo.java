/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.dental.angular.model.User;

/**
 *
 * @author User
 */
public interface UserRepo extends JpaRepository<User, Integer>{

    public User findByEmail(String email);
    
    public Page<User> findByNameTHOrEmail(String nameTH, String email, Pageable pageable);
    
}
