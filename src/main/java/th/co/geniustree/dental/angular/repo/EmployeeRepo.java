/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import th.co.geniustree.dental.angular.model.Employee;

/**
 *
 * @author Employee
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer>,JpaSpecificationExecutor<Employee>{

    public Employee findByEmail(String email);
    @Query("select u from Employee u where u.nameth like %?1% or u.email like %?2%")
    public Page<Employee> findByNameTHOrEmail(String nameth, String email, Pageable pageable);

    public Employee findByEmailIgnoreCase(String value);
    
}
