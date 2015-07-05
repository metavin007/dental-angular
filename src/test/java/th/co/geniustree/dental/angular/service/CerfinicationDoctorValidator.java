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
import th.co.geniustree.dental.angular.model.Doctor;
import th.co.geniustree.dental.angular.repo.DoctorRepo;

/**
 *
 * @author Jasin007
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class CerfinicationDoctorValidator {

    @Autowired
    DoctorRepo doctorRepo;
    
    @Autowired
    private Validator validator;
    private Doctor doctor;

    @Before
    public void setrow() {
        doctor = new Doctor();
        doctor.setCerno("1234");
        doctor.setCertype("ออมทรัพย์");
        doctor.setEmail("xxx@xxx.com");
        doctor.setNameth("dortorนะครับ");
        doctor.setPid("1730200213549");
        doctor.setMobile("0964747468");
        doctorRepo.save(doctor);
    }
        
    @Test
    public void ifCerfinicationDoctorIsAlreadyExistThenError() {
        Set<ConstraintViolation<Doctor>> validateProperty = validator.validateProperty(doctor, "cerno");
        Assertions.assertThat(validateProperty).extracting(c -> c.getMessage()).contains("cerfinicationซ้ำ");
    }
}
