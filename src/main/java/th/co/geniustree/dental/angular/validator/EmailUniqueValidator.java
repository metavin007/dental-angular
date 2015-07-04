/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.validator;

import com.google.common.base.Strings;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import th.co.geniustree.dental.angular.model.Employee;
import th.co.geniustree.dental.angular.repo.EmployeeRepo;

/**
 *
 * @author pramoth
 */
public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void initialize(EmailUnique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Strings.isNullOrEmpty(value)) {
            return true;
        }
        Employee findByEmailIgnoreCase = employeeRepo.findByEmailIgnoreCase(value);
        return findByEmailIgnoreCase == null;
    }

}
