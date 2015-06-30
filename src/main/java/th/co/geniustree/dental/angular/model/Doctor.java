/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.hibernate.annotations.CollectionId;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author pramoth
 */
@Entity
public class Doctor extends Employee implements Serializable{
   
    @NotBlank(message = "Please Input cerNo.")
    private String cer;
    
    @NotBlank(message = "Please Input cerType.")
    private String cerType;

    public String getCerNo() {
        return cer;
    }

    public void setCerNo(String cerNo) {
        this.cer = cerNo;
    }

    
    public String getCerType() {
        return cerType;
    }

    public void setCerType(String cerType) {
        this.cerType = cerType;
    }
    
    
    
}
