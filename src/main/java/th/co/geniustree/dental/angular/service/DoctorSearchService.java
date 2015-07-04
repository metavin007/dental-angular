
package th.co.geniustree.dental.angular.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.dental.angular.model.Doctor;
import th.co.geniustree.dental.angular.repo.DoctorRepo;
import th.co.geniustree.dental.angular.spec.DoctorSpec;


@Service
public class DoctorSearchService {
    @Autowired
    private DoctorRepo doctorRepo;
    
     public Page<Doctor> search(String keyword,Pageable pageable){
        Specifications<Doctor> specification = Specifications.where(DoctorSpec.emailLike("%"+keyword+"%"));
        return doctorRepo.findAll(specification,pageable);
        
    }
}
