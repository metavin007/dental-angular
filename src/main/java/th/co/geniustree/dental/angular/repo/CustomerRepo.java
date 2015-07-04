/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.repo;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.dental.angular.model.Customer;


/**
 *
 * @author pramoth
 */
public interface CustomerRepo extends JpaRepository<Customer, BigInteger>{

    public Customer findByPidIgnoreCase(String value);
    
}
