/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.dental.angular.model.Employee;
import th.co.geniustree.dental.angular.repo.EmployeeRepo;
import th.co.geniustree.dental.angular.spec.EmployeeSpec;

/**
 *
 * @author pramoth
 */
@Service
public class EmployeeSearchService {
    @Autowired
    private EmployeeRepo employeeRepo;
    public Page<Employee> search(String keyword,Pageable pageable){
        Specifications<Employee> specification = Specifications.where(EmployeeSpec.emailLike("%"+keyword+"%"))
                .or(EmployeeSpec.nameLike("%"+keyword+"%"));
        return  employeeRepo.findAll(specification,pageable);
    }
}
