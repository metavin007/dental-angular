/////*
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
////package th.co.geniustree.dental.angular.controller;
////
////import java.util.Set;
////import java.util.function.Function;
////import javax.validation.ConstraintViolation;
////import javax.validation.Validation;
////import javax.validation.Validator;
////import javax.validation.ValidatorFactory;
////import org.assertj.core.api.Assertions;
////import org.junit.After;
////import org.junit.Before;
////import org.junit.Test;
////import static org.junit.Assert.*;
////import th.co.geniustree.dental.angular.model.Customer;
////
/////**
//// *
//// * @author pramoth
//// */
////public class ValidatorTest {
////
////    private Validator validator;
////
////    public ValidatorTest() {
////    }
////
////    @Before
////    public void setUp() {
////        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
////        validator = factory.getValidator();
////    }
////
////    @After
////    public void tearDown() {
////    }
////
////    @Test
////    public void emptyNameShouldRaiseConstrainViolation() {
////        Customer customer = new Customer();
////        customer.setName("");
////        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
////        Assertions.assertThat(violations).extracting(t -> t.getPropertyPath().toString()).contains("name");
////    }
////    @Test
////    public void emptyEmailShouldRaiseConstrainViolation() {
////        Customer customer = new Customer();
////        customer.setEmail("");
////        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
////        Assertions.assertThat(violations).extracting(t -> t.getPropertyPath().toString()).contains("email");
////    }
////    @Test
////    public void notWellformEmailShouldRaiseConstrainViolation() {
////        Customer customer = new Customer();
////        customer.setEmail("xxxxx");
////        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
////        Assertions.assertThat(violations).extracting(t -> t.getPropertyPath().toString()).contains("email");
////    }
////    
////    @Test
////    public void emptyMobileShouldRaiseConstrainViolation() {
////        Customer customer = new Customer();
////        customer.setMobile("     ");
////        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
////        Assertions.assertThat(violations).extracting(t -> t.getPropertyPath().toString()).contains("mobile");
////    }
//    
//
//}
