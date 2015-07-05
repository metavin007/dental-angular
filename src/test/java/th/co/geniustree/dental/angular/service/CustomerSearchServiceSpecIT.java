/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.co.geniustree.dental.angular.App;
import th.co.geniustree.dental.angular.model.Customer;
import th.co.geniustree.dental.angular.repo.CustomerRepo;

/**
 *
 * @author Best
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerSearchServiceSpecIT {
    
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepo customerRepo;
   
    private Customer customer;
    private Customer customer2;
    private Customer customer3;
    private Customer customer4;
    
    @Before
    public void setup(){
        customer = new Customer();
        customer.setHn("767536");
        customer.setPid("1234567");
        customer.setName("Kittiporn");
        customer2 = new Customer();
        customer2.setHn("767536");
        customer2.setPid("1234567");
        customer2.setName("Best");
        customer3 = new Customer();
        customer3.setHn("767536");
        customer3.setPid("1234567");
        customer3.setName("Khamlai");
    }
    @Test
    public void findNameOrEmailShoudReturnTwoNaja(){
        customerRepo.saveAndFlush(customer);
        customerRepo.saveAndFlush(customer2);
        customerRepo.saveAndFlush(customer3);
        Page<Customer> search = customerService.search("B", new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(2);
    }
    
}
