/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import th.co.geniustree.dental.angular.model.Doctor;
import th.co.geniustree.dental.angular.model.Doctor_;




public class DoctorSpec {
   public static Specification<Doctor> emailLike(String keyword) {
        return new Specification<Doctor>() {

            @Override
            public Predicate toPredicate(Root<Doctor> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
               return cb.like(cb.upper(root.get(Doctor_.email)), keyword.toUpperCase());
            }
        };
    }
}
