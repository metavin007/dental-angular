/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.validator;

import com.google.common.base.Strings;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import th.co.geniustree.dental.angular.repo.CustomerRepo;

/**
 *
 * @author oom
 */
public class NamethUniqueValidator implements ConstraintValidator<NamethUnique, String>{

    @Autowired
    private CustomerRepo customerRepo;
    
    @Override
    public void initialize(NamethUnique constraintAnotation) {
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(Strings.isNullOrEmpty(value)){
        return true;
        }
        //return customerRepo.findByNamethIgnoreCase(value) == null;
        return customerRepo.findByNamethIgnoreCase(value) == null;
        
    }
    
}
