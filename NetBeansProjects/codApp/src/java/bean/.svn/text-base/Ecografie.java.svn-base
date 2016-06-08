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
@Table(name = "ecografie")
@NamedQueries({
    @NamedQuery(name = "Ecografie.findAll", query = "SELECT e FROM Ecografie e"),
    @NamedQuery(name = "Ecografie.findById", query = "SELECT e FROM Ecografie e WHERE e.id = :id")})
public class Ecografie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "esamiPrenatali")
    private String esamiPrenatali;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ecografie")
    private List<Ecografiatabella> ecografiatabellaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ecografie")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Ecografie() {
    }

    public Ecografie(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEsamiPrenatali() {
        return esamiPrenatali;
    }

    public void setEsamiPrenatali(String esamiPrenatali) {
        this.esamiPrenatali = esamiPrenatali;
    }

    public List<Ecografiatabella> getEcografiatabellaList() {
        return ecografiatabellaList;
    }

    public void setEcografiatabellaList(List<Ecografiatabella> ecografiatabellaList) {
        this.ecografiatabellaList = ecografiatabellaList;
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
        if (!(object instanceof Ecografie)) {
            return false;
        }
        Ecografie other = (Ecografie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Ecografie[id=" + id + "]";
    }

}
