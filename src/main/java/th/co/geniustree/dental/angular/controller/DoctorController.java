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
import th.co.geniustree.dental.angular.model.Doctor;
import th.co.geniustree.dental.angular.repo.DoctorRepo;

/**
 *
 * @author Best
 */
@RestController
public class DoctorController {
    
    @Autowired
    private DoctorRepo doctorRepo;
    
     @RequestMapping(value = "/showdoctors")
    public Page<Doctor> getCustomers(Pageable pageable) {
        return doctorRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/savedoctors" , method = RequestMethod.POST)
    public void saveDoctor(@Validated @RequestBody Doctor doctor){
    doctorRepo.save(doctor);
    }
}
