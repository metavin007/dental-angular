package th.co.geniustree.dental.angular.validator;

import com.google.common.base.Strings;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import th.co.geniustree.dental.angular.model.Doctor;
import th.co.geniustree.dental.angular.repo.DoctorRepo;

/**
 *
 * @author Jasin007
 */
public class CerficationDoctorUniqueValidator implements ConstraintValidator<CerficationDoctorUnique, String> {

    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public void initialize(CerficationDoctorUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Strings.isNullOrEmpty(value)) {
            return true;
        }
        Doctor findBycernoIgnoreCase = doctorRepo.findBycernoIgnoreCase(value);
        return findBycernoIgnoreCase == null;
    }

}
