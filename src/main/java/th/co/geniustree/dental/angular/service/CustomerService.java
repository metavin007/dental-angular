/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.dental.angular.model.Customer;
import th.co.geniustree.dental.angular.model.Customer_;
import th.co.geniustree.dental.angular.model.Employee;
import th.co.geniustree.dental.angular.repo.CustomerRepo;
import th.co.geniustree.dental.angular.spec.CustomerSpec;


/**
 *
 * @author Best
 */
@Service
public class CustomerService {
   
    @Autowired
    private CustomerRepo customerRepo;
    
    public Page<Customer> search(String keyword,Pageable pageable){
        Specifications<Customer> specification = Specifications.where(CustomerSpec.likeName("%"+keyword+"%"))
                .or(CustomerSpec.likeEmail("%"+keyword+"%"));
   return customerRepo.findAll(specification,pageable);
    }
 }
