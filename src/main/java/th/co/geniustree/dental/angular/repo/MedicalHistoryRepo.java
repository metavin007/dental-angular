/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.repo;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.dental.angular.model.MedicalHistory;

/**
 *
 * @author Best
 */
public interface MedicalHistoryRepo extends JpaRepository<MedicalHistory, Integer>{
    
}
