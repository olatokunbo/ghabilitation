
package jpa.administration;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author theodora
 */
@Entity
public class Groupe implements Serializable{
    @Id
    private String code;
    private String libelle;
    private boolean useFullAdminReg;
    private boolean useFullAdminOp;
    private boolean useFullSuper = true;
    @Version
    private Timestamp version;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    
    @OneToMany(mappedBy = "groupe")
    private List<Habilitation> habilitations;
    

    public Groupe() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean isUseFullAdminReg() {
        return useFullAdminReg;
    }

    public void setUseFullAdminReg(boolean useFullAdminReg) {
        this.useFullAdminReg = useFullAdminReg;
    }

    public boolean isUseFullAdminOp() {
        return useFullAdminOp;
    }

    public void setUseFullAdminOp(boolean useFullAdminOp) {
        this.useFullAdminOp = useFullAdminOp;
    }

    public boolean isUseFullSuper() {
        return useFullSuper;
    }

    public void setUseFullSuper(boolean useFullSuper) {
        this.useFullSuper = useFullSuper;
    }

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    public List<Habilitation> getHabilitations() {
        return habilitations;
    }

    public void setHabilitations(List<Habilitation> habilitations) {
        this.habilitations = habilitations;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        return !((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)));
    }
    
   
    
    @PrePersist
    public void prePersist() {
        dateCreation = new Date();
    }
    
    public void reset() {
        code = null;
        libelle = null;
    }
}
