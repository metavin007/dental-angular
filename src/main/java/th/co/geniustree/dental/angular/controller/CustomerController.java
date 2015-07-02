/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.dental.angular.model.Customer;
import th.co.geniustree.dental.angular.model.Employee;
import th.co.geniustree.dental.angular.model.MedicalHistory;
import th.co.geniustree.dental.angular.repo.CustomerRepo;
import th.co.geniustree.dental.angular.repo.EmployeeRepo;
import th.co.geniustree.dental.angular.repo.MedicalHistoryRepo;




/**
 *
 * @author pramoth
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private EmployeeRepo userRepo;
    @Autowired
    private MedicalHistoryRepo medicalHistoryRepo;

    @RequestMapping(value = "/customers")
    public Page<Customer> getCustomers(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }
    @RequestMapping(value = "/customers",method = RequestMethod.POST)
    public void saveCustomer(@Validated @RequestBody Customer customer) {
        customerRepo.save(customer);
    }
     ////////// Delete ////////////////////
    @RequestMapping(value = "/customerde", method = RequestMethod.POST)
    public void deleteCustomer(@RequestBody Customer customer) {
        customerRepo.delete(customer.getId());
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public boolean loginAdmin(@RequestBody Employee user){
       return userRepo.equals(user);
    }
    @RequestMapping(value = "/medicalhistory")
    public Page<MedicalHistory> getMedicalHistory(Pageable pageable) {
        return medicalHistoryRepo.findAll(pageable);
    }
}
