/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.service;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
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
public class MobileUniqueValidatorIT {
    
    @Autowired
    private CustomerRepo customerRepo;
    
    @Autowired
    private Validator validator;
    private Customer customer;
    
    @Before
    public void setting(){
    customer = new Customer();
    customer.setHn("1234");
    customer.setPid("1234567890");
    customer.setName("Best");
    customer.setMobile("0817868274");
    customer = customerRepo.save(customer);
    }
    
    @Test
    public void ifMobileuniqueMustReturnOneNaja(){
         Set<ConstraintViolation<Customer>> validateProperty = validator.validateProperty(customer, "mobile");
        Assertions.assertThat(validateProperty).extracting(c -> c.getMessage()).contains("dup phone number ");
    }
    
}
