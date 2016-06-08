/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "datiautenticazione")
@NamedQueries({
    @NamedQuery(name = "Datiautenticazione.findAll", query = "SELECT d FROM Datiautenticazione d"),
    @NamedQuery(name = "Datiautenticazione.findByUsername", query = "SELECT d FROM Datiautenticazione d WHERE d.username = :username"),
    @NamedQuery(name = "Datiautenticazione.findByPassword", query = "SELECT d FROM Datiautenticazione d WHERE d.password = :password"),
    @NamedQuery(name = "Datiautenticazione.findByTipoUtente", query = "SELECT d FROM Datiautenticazione d WHERE d.tipoUtente = :tipoUtente")})
public class Datiautenticazione implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "tipoUtente")
    private String tipoUtente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datiautenticazione")
    private List<Dottore> dottoreList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datiautenticazione")
    private List<Paziente> pazienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datiautenticazione")
    private List<Amministratore> amministratoreList;

    public Datiautenticazione() {
    }

    public Datiautenticazione(String username) {
        this.username = username;
    }

    public Datiautenticazione(String username, String password, String tipoUtente) {
        this.username = username;
        this.password = password;
        this.tipoUtente = tipoUtente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUtente() {
        return tipoUtente;
    }

    public void setTipoUtente(String tipoUtente) {
        this.tipoUtente = tipoUtente;
    }

    public List<Dottore> getDottoreList() {
        return dottoreList;
    }

    public void setDottoreList(List<Dottore> dottoreList) {
        this.dottoreList = dottoreList;
    }

    public List<Paziente> getPazienteList() {
        return pazienteList;
    }

    public void setPazienteList(List<Paziente> pazienteList) {
        this.pazienteList = pazienteList;
    }

    public List<Amministratore> getAmministratoreList() {
        return amministratoreList;
    }

    public void setAmministratoreList(List<Amministratore> amministratoreList) {
        this.amministratoreList = amministratoreList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datiautenticazione)) {
            return false;
        }
        Datiautenticazione other = (Datiautenticazione) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Datiautenticazione[username=" + username + "]";
    }

    public static final String TIPOUTENTE_AMMINISTRATORE="amministratore";
    public static final String TIPOUTENTE_PAZIENTE="paziente";
    public static final String TIPOUTENTE_DOTTORE="dottore";
}
