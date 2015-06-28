///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package th.co.geniustree.dental.angular.model;
//
//import java.util.Date;
//import org.assertj.core.api.Assertions;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import th.co.geniustree.dental.angular.App;
//import th.co.geniustree.dental.angular.model.Department;
//import th.co.geniustree.dental.angular.model.Employee;
//import th.co.geniustree.dental.angular.repo.DepartmentRepo;
//import th.co.geniustree.dental.angular.repo.EmployeeRepo;
//
///**
// *
// * @author pramoth
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = App.class)
//@Transactional(propagation = Propagation.REQUIRED)
//public class UserRepoIT {
//
//    private static final Logger LOG = LoggerFactory.getLogger(UserRepoIT.class);
//    @Autowired
//    private EmployeeRepo userRepo;
//    @Autowired
//    private DepartmentRepo departmentRepo;
//
//    @Before
//    public void setup() {
//        LOG.info("setup call.");
//    }
//
//    @Test
//    public void test1() {
//        long count = userRepo.count();
//        Assertions.assertThat(count).isEqualTo(0);
//    }
//
//    @Test
//    public void userMustSaveableToDB() {
//        Employee user = createUser();
//        userRepo.save(user);
//        Employee findByEmail = userRepo.findByEmail("xxx@xxx.com");
//        Assertions.assertThat(findByEmail).isNotNull();
//    }
//
//    private Employee createUser() {
//        Employee user = new Employee();
//        user.setEmail("xxx@xxx.com");
//        user.setNamethai("ดำ แดง");
//        user.setAddress("xxxxxxx xxxx xxxxxx");
//        user.setBirthday(new Date());
//        return user;
//    }
//
//    @Test
//    public void userWithDepartmentMustBeSaveableToDB() {
//        Department dep = new Department();
//        dep.setName("Software Development");
//        dep = departmentRepo.save(dep);
//        Employee user = createUser();
//        user.setDepartment(dep);
//        userRepo.save(user);
//        Employee findByEmail = userRepo.findByEmail("xxx@xxx.com");
//        
//        Assertions.assertThat(findByEmail.getDepartment()).isEqualTo(dep);
//    }
//}
