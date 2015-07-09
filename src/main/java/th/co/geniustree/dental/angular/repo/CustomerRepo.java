/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.repo;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import th.co.geniustree.dental.angular.model.Customer;



/**
 *
 * @author pramoth
 */
public interface CustomerRepo extends JpaRepository<Customer, BigInteger>,JpaSpecificationExecutor<Customer>{

    public Customer findByPidIgnoreCase(String value);
    
    public Customer findByMobileIgnoreCase(String value);

    public Customer findByNamethIgnoreCase(String value);

   
    
}
