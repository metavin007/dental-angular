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
import th.co.geniustree.dental.angular.model.Customer;
import th.co.geniustree.dental.angular.repo.CustomerRepo;

/**
 *
 * @author kekhuay
 */

public class PidUniqueValidator implements ConstraintValidator<PidUnique, String> {

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public void initialize(PidUnique constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Strings.isNullOrEmpty(value)) {
            return true;
        }
        Customer findByPidIgnoreCase = customerRepo.findByPidIgnoreCase(value);
        return findByPidIgnoreCase == null;
    }
    
}
