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
 * @author oom
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class NameUniqueValidatorIT {
    @Autowired
    private CustomerRepo customerRepo;
    
    @Autowired
    private Validator validator;
    private Customer oom;
    
    @Before
    public void setting(){
        oom = new Customer();
        oom.setHn("1234");
        oom.setPid("12332");
        oom.setName("Umboon");
        oom.setMobile("0836240426");
        oom = customerRepo.save(oom);
    }
    @Test
    public void ifAlreadyNameThenError(){
        Set<ConstraintViolation<Customer>> validateProperty = validator.validateProperty(oom, "name");
        Assertions.assertThat(validateProperty).extracting(c -> c.getMessage()).contains("dup Name");
    }
}
