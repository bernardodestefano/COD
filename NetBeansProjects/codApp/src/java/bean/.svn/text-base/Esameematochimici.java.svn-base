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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "esameematochimici")
@NamedQueries({
    @NamedQuery(name = "Esameematochimici.findAll", query = "SELECT e FROM Esameematochimici e"),
    @NamedQuery(name = "Esameematochimici.findById", query = "SELECT e FROM Esameematochimici e WHERE e.id = :id")})
public class Esameematochimici implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "note")
    private String note;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "esameematochimici")
    private List<Esameematochimicitabella> esameematochimicitabellaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "esameematochimici")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Esameematochimici() {
    }

    public Esameematochimici(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Esameematochimicitabella> getEsameematochimicitabellaList() {
        return esameematochimicitabellaList;
    }

    public void setEsameematochimicitabellaList(List<Esameematochimicitabella> esameematochimicitabellaList) {
        this.esameematochimicitabellaList = esameematochimicitabellaList;
    }

    public List<Cartellaostetricadigitale> getCartellaostetricadigitaleList() {
        return cartellaostetricadigitaleList;
    }

    public void setCartellaostetricadigitaleList(List<Cartellaostetricadigitale> cartellaostetricadigitaleList) {
        this.cartellaostetricadigitaleList = cartellaostetricadigitaleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Esameematochimici)) {
            return false;
        }
        Esameematochimici other = (Esameematochimici) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Esameematochimici[id=" + id + "]";
    }

}
