package jpa.administration;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Version;

/**
 *
 * @author AHISSOU Florent
 */
@Entity
public class Utilisateur implements Serializable {
    @OneToMany(mappedBy = "utilisateur")
    private List<Habilitation> habilitations;
    
    @Id
    protected String login;
    protected String password;
    protected String nom;
    protected String prenom;
    protected String telephone;
    protected String email;
    protected String bp;
    @ManyToOne
    protected Groupe groupe;
    protected String userName;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date dateNaissance;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date dateCreation;
    @Version
    protected Timestamp version;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date loginTime;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    protected Date loginOutTime;
    private String sessionId;
    private int connectionStatus = -1; //-1 - jamais connecté, 0 - déconnecté, 1 - connecté actif, 3 - connecté inactif
    private boolean passwordinit = false;
    @Enumerated(EnumType.STRING)
    private EnumGenre genre;

    public Utilisateur() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Habilitation> getHabilitations() {
        return habilitations;
    }

    public void setHabilitations(List<Habilitation> habilitations) {
        this.habilitations = habilitations;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLoginOutTime() {
        return loginOutTime;
    }

    public void setLoginOutTime(Date loginOutTime) {
        this.loginOutTime = loginOutTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(int connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public boolean isPasswordinit() {
        return passwordinit;
    }

    public void setPasswordinit(boolean passwordinit) {
        this.passwordinit = passwordinit;
    }

    public EnumGenre getGenre() {
        return genre;
    }

    public void setGenre(EnumGenre genre) {
        this.genre = genre;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        return !((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login)));
    }
    
    public void reset() {
        login = null;
        password = null;
        nom = null;
        prenom = null;
        telephone = null;
        email = null;
        bp = null;
    }

}
