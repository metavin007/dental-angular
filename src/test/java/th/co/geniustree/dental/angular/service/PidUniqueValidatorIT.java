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
 * @author kekhuay
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class PidUniqueValidatorIT {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private Validator validator;
    private Customer bom;
    @Before
    public void setUp() {
        bom = new Customer();
        bom.setHn("bbbbb");
        bom.setPid("12345");
        bom.setName("bom");
        bom = customerRepo.save(bom);
    }
    @Test
    public void ifPidIsAlreadyExistThenError() {
        Set<ConstraintViolation<Customer>> validateProperty = validator.validateProperty(bom, "pid");
        Assertions.assertThat(validateProperty).extracting(c -> c.getMessage()).contains("dup ซ้ำ");
    }
}
