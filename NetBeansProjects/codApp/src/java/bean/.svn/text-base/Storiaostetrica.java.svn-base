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
@Table(name = "storiaostetrica")
@NamedQueries({
    @NamedQuery(name = "Storiaostetrica.findAll", query = "SELECT s FROM Storiaostetrica s"),
    @NamedQuery(name = "Storiaostetrica.findById", query = "SELECT s FROM Storiaostetrica s WHERE s.id = :id")})
public class Storiaostetrica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "osservazioni")
    private String osservazioni;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storiaostetrica")
    private List<Storiaostretricatabella> storiaostretricatabellaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storiaostetrica")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Storiaostetrica() {
    }

    public Storiaostetrica(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOsservazioni() {
        return osservazioni;
    }

    public void setOsservazioni(String osservazioni) {
        this.osservazioni = osservazioni;
    }

    public List<Storiaostretricatabella> getStoriaostretricatabellaList() {
        return storiaostretricatabellaList;
    }

    public void setStoriaostretricatabellaList(List<Storiaostretricatabella> storiaostretricatabellaList) {
        this.storiaostretricatabellaList = storiaostretricatabellaList;
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
        if (!(object instanceof Storiaostetrica)) {
            return false;
        }
        Storiaostetrica other = (Storiaostetrica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Storiaostetrica[id=" + id + "]";
    }

}
