
package th.co.geniustree.dental.angular.validator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.Payload;
/**
 *
 * @author Jasin007
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = CerficationDoctorUniqueValidator.class)
public @interface CerficationDoctorUnique {
     
    String message() default "{th.co.geniustree.dental.angular.validator.cernoUnique.message}";
     
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
