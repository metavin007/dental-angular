/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;
import th.co.geniustree.dental.angular.validator.MobileUnique;
import th.co.geniustree.dental.angular.validator.NameUnique;
import th.co.geniustree.dental.angular.validator.PidUnique;

/**
 *
 * @author pramoth
 */
@Entity
public class Customer implements Serializable{
    @Id
    @SequenceGenerator(name = "CUSTOMER", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CUSTOMER", strategy = GenerationType.SEQUENCE)
    private BigInteger id;
   
    @NotBlank(message = "HN is not empty")
    private String hn;
    
    @PidUnique
    @NotBlank(message = "Person ID is not empty")
    private String pid;
    
    @NameUnique
    @NotBlank(message = "Name is not empty")
    private String name;
    
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
    private String sex;
    private String blood;
    private String nation;
    private String race;
    private String address;
    private String tel;
    @MobileUnique
    private String mobile;
    private String job;
    private String email;
    
    @ManyToMany
    private List<MedicalHistory> medicalhistory;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getHn() {
        return hn;
    }

    public void setHn(String hn) {
        this.hn = hn;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MedicalHistory> getMedicalhistory() {
        return medicalhistory;
    }

    public void setMedicalhistory(List<MedicalHistory> medicalhistory) {
        this.medicalhistory = medicalhistory;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
 }
