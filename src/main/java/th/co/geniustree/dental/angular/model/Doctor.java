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
import th.co.geniustree.dental.angular.validator.CerficationDoctorUnique;

/**
 *
 * @author pramoth
 */
@Entity
public class Doctor extends Employee implements Serializable{
    @CerficationDoctorUnique
    @NotBlank(message = "Please Input cerNo.")
    private String cerno;
    
    @NotBlank(message = "Please Input cerType.")
    private String certype;

    public String getCerno() {
        return cerno;
    }

    public void setCerno(String cerno) {
        this.cerno = cerno;
    }

    public String getCertype() {
        return certype;
    }

    public void setCertype(String certype) {
        this.certype = certype;
    }


    
    
}
