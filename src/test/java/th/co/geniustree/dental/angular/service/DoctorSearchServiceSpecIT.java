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
import th.co.geniustree.dental.angular.model.Doctor;
import th.co.geniustree.dental.angular.repo.DoctorRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class DoctorSearchServiceSpecIT {

    @Autowired
    private DoctorSearchService doctorSearchService;
    @Autowired
    private DoctorRepo doctorRepo;
    private Doctor doctor0;
    private Doctor doctor1;
    private Doctor doctor2;

    @Before
    public void setup() {
        doctor0 = new Doctor();
        doctor1 = new Doctor();
        doctor2 = new Doctor();

        doctor1.setCerno("1234");
        doctor1.setCertype("ออมทรัพย์");
        doctor1.setEmail("xxx@xxx.com");
        doctor1.setNameth("dortorนะครับ");
        doctor1.setPid("1730200213549");
        doctor1.setMobile("0964747468");

        doctor2.setCerno("1235");
        doctor2.setCertype("ออมทรัพย์");
        doctor2.setEmail("ccc@ccc.com");
        doctor2.setNameth("dortorนะครับ");
        doctor2.setPid("1730200213549");
        doctor2.setMobile("0964747468");

        doctor0.setCerno("1236");
        doctor0.setCertype("ออมทรัพย์");
        doctor0.setEmail("eee@eee.com");
        doctor0.setNameth("dortorนะครับ");
        doctor0.setPid("1730200213549");
        doctor0.setMobile("0964747468");
    }

    @Test
    public void findEmailDoctorOneRow() {
        doctorRepo.saveAndFlush(doctor0);
   
        Page<Doctor> search = doctorSearchService.search("ee", new PageRequest(0, 10));
        Assertions.assertThat(search.getTotalElements()).isEqualTo(1);
    }
}
