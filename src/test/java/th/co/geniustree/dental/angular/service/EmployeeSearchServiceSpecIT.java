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
import th.co.geniustree.dental.angular.model.Employee;
import th.co.geniustree.dental.angular.repo.EmployeeRepo;

/**
 *
 * @author pramoth
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeSearchServiceSpecIT {
    @Autowired
    private EmployeeSearchService employeeSearchService;
    @Autowired
    private EmployeeRepo employeeRepo;
    private Employee pramoth;
    
    @Before
    public void setup(){
        pramoth = new Employee();
        pramoth.setEmail("PraMoth@Xxxx.Com");
        pramoth.setPassword("xxx");
        pramoth.setPid("121212");
        pramoth.setNameth("xxxxx");
        pramoth.setMobile("xxxxxx");
    }
    @Test
    public void findEmailPramothShouldReturnOneRow(){
        employeeRepo.saveAndFlush(pramoth);
        Page<Employee> search = employeeSearchService.search("pramoth", new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
    }
    @Test
    public void duplicateInsertMustNotAllow() {
        employeeRepo.save(pramoth);
        employeeRepo.save(pramoth);
        Page<Employee> search = employeeRepo.findAll(new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
    }
    @Test
    public void insertAndDeleteMustBeSuccess() {
        employeeRepo.save(pramoth);
        Page<Employee> search = employeeRepo.findAll(new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
        employeeRepo.delete(pramoth);
        Page<Employee> searchAgain = employeeRepo.findAll(new PageRequest(0, 10));
        Assertions.assertThat(searchAgain.getTotalElements()).isZero();
    }
    @Test
    public void updateEmailMustBeSuccess() {
        employeeRepo.saveAndFlush(pramoth);
        Page<Employee> search = employeeSearchService.search("pramoth", new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
        pramoth.setEmail("bom@bom.com");
        Page<Employee> searchAgain = employeeSearchService.search("bom", new PageRequest(0, 10));
        Assertions.assertThat(searchAgain.getTotalElements()).isEqualTo(1);
    }
}
