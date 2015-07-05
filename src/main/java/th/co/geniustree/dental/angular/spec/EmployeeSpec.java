package th.co.geniustree.dental.angular.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import th.co.geniustree.dental.angular.model.Employee;
import th.co.geniustree.dental.angular.model.Employee_;

/**
 *
 * @author pramoth
 */
public class EmployeeSpec {

    public static Specification<Employee> nameLike(String keyword) {
        return new Specification<Employee>() {

            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.or(cb.like(root.get(Employee_.nameth), keyword), cb.like(cb.upper(root.get(Employee_.nameeng)), keyword.toUpperCase()));
            }
        };
    }

    public static Specification<Employee> emailLike(String keyword) {
        return new Specification<Employee>() {

            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(cb.upper(root.get(Employee_.email)), keyword.toUpperCase());
            }
        };
    }
}
