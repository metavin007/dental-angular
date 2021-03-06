/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.angular.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import th.co.geniustree.dental.angular.validator.EmailUnique;

/**
 *
 * @author Employee
 */
@Entity
@Table(name = "EMPLOYEE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee implements Serializable, UserDetails {

    @Id
    @SequenceGenerator(name = "USER", sequenceName = "USER_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "USER", strategy = GenerationType.SEQUENCE)
    private Integer id;

//    @NotBlank(message = "please input password")
//    @Column(name = "password" , nullable = false)
    private String password;
    @EmailUnique
    @Column(name = "EMAIL", nullable = false, unique = true)
    @NotBlank(message = "please input email")
    @Email(message = "format Incompatible (Ex. xxx@xxx.com)")
    private String email;

    @Column(name = "PID", nullable = false, unique = true)
    @NotBlank(message = "please input password")
    private String pid;
@Size(max = 100)
    @Column(name = "NAMETH", nullable = false)
    @NotBlank(message = "please input name")
    private String nameth;

    private String nameeng;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthday;

    private String sex;
    private String blood;
    private String soldierstatus;
    private String marrystatus;
//    @Column(name = "nation" , nullable = false)
//    @NotBlank(message = "please input nation")
    private String nation;

//    @Column(name = "race" , nullable = false)
//    @NotBlank(message = "please input race")
    private String race;

    private String addressofpid;
//    @Column(name = "address" , nullable = false)
//    @NotBlank(message = "please input address")
    private String address;

    private String tel;
    @Column(name = "MOBILE", nullable = false)
    @NotBlank(message = "please input mobile")
    private String mobile;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startwork;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endwork;

    private String workstatus;
    private boolean enabled = true;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTACTPERSON_ID", nullable = true)
    private ContactPersion contactpersion;

    @ManyToMany
    private List<Authority> authorities;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BANKACCOUNT_ID", nullable = true)
    private BankAccount bankaccount;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getNameth() {
        return nameth;
    }

    public void setNameth(String nameth) {
        this.nameth = nameth;
    }

    public String getNameeng() {
        return nameeng;
    }

    public void setNameeng(String nameeng) {
        this.nameeng = nameeng;
    }

    public BankAccount getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(BankAccount bankaccount) {
        this.bankaccount = bankaccount;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public String getSoldierstatus() {
        return soldierstatus;
    }

    public void setSoldierstatus(String soldierstatus) {
        this.soldierstatus = soldierstatus;
    }

    public String getMarrystatus() {
        return marrystatus;
    }

    public void setMarrystatus(String marrystatus) {
        this.marrystatus = marrystatus;
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

    public String getAddressofpid() {
        return addressofpid;
    }

    public void setAddressofpid(String addressofpid) {
        this.addressofpid = addressofpid;
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

    public Date getStartwork() {
        return startwork;
    }

    public void setStartwork(Date startwork) {
        this.startwork = startwork;
    }

    public Date getEndwork() {
        return endwork;
    }

    public void setEndwork(Date endwork) {
        this.endwork = endwork;
    }

    public String getWorkstatus() {
        return workstatus;
    }

    public void setWorkstatus(String workstatus) {
        this.workstatus = workstatus;
    }

    public ContactPersion getContactpersion() {
        return contactpersion;
    }

    public void setContactpersion(ContactPersion contactpersion) {
        this.contactpersion = contactpersion;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
