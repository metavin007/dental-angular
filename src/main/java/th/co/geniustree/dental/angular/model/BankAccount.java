package th.co.geniustree.dental.angular.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BANKACCOUNT")
public class BankAccount implements Serializable {

    @Id
    @SequenceGenerator(name = "BankAccount", sequenceName = "BANKACCOUNT_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "BankAccount", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String addcountid;
    private String addcountname;
    private String bankname;
    private String addcounttype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddcountid() {
        return addcountid;
    }

    public void setAddcountid(String addcountid) {
        this.addcountid = addcountid;
    }

    public String getAddcountname() {
        return addcountname;
    }

    public void setAddcountname(String addcountname) {
        this.addcountname = addcountname;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getAddcounttype() {
        return addcounttype;
    }

    public void setAddcounttype(String addcounttype) {
        this.addcounttype = addcounttype;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final BankAccount other = (BankAccount) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
