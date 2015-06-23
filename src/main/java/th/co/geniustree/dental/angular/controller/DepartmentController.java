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
import th.co.geniustree.dental.angular.model.Department;
import th.co.geniustree.dental.angular.repo.DepartmentRepo;

/**
 *
 * @author User
 */
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentRepo departmentRepo;

    @RequestMapping(value = "/department")
    public Page<Department> getDepartments(Pageable pageable) {
        return departmentRepo.findAll(pageable);
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public void saveDepartment(@Validated @RequestBody Department department) {
        departmentRepo.save(department);
    }

    @RequestMapping(value = "/departmentdelete", method = RequestMethod.POST)
    public void deleteDepartment(@RequestBody Department department) {
        departmentRepo.delete(department.getId());
    }

    @RequestMapping(value = "/department/search", method = RequestMethod.POST)
    public Page<Department> searchDepartment(@RequestBody String keyword, Pageable pageable) {
        
        if(keyword.equals("s"))
        {
           return departmentRepo.findAll(pageable);
        }
        else{
           return departmentRepo.findByName(keyword, pageable);
        }
        
    }
    
}
