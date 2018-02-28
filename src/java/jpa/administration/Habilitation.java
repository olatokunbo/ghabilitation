
package jpa.administration;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author theodora
 */
@Entity
public class Habilitation implements Serializable{
    @Id
    private String code;
    @Version
    private Timestamp version;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Groupe groupe;

    public Habilitation() {
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
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
        if (!(object instanceof Habilitation)) {
            return false;
        }
        Habilitation other = (Habilitation) object;
        return !((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)));
    }
    
    @PrePersist
    public void initDateCreation() {
        dateCreation = new Date();
    }
    
    public void reset() {
        code = null;
        utilisateur =null;
        groupe=null;
    }

}
