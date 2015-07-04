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
import th.co.geniustree.dental.angular.model.Employee;
import th.co.geniustree.dental.angular.repo.EmployeeRepo;
import th.co.geniustree.dental.angular.validator.EmailUnique;

/**
 *
 * @author pramoth
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class EmailUniqueValidatorIT {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private Validator validator;
    private Employee pramoth;

    @Before
    public void setup() {
        pramoth = new Employee();
        pramoth.setEmail("PraMoth@Xxxx.Com");
        pramoth.setPassword("xxx");
        pramoth.setPid("121212");
        pramoth.setNameth("xxxxx");
        pramoth.setMobile("xxxxxx");
        pramoth = employeeRepo.save(pramoth);
    }

    @Test
    public void ifAlreadyExistEmailThenError() {
        Set<ConstraintViolation<Employee>> validate = validator.validateProperty(pramoth, "email");
        Assertions.assertThat(validate).extracting(c->c.getMessage()).contains("dup");
    }
}
