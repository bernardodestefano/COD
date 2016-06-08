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
@Table(name = "anamnesifamiliare")
@NamedQueries({
    @NamedQuery(name = "Anamnesifamiliare.findAll", query = "SELECT a FROM Anamnesifamiliare a"),
    @NamedQuery(name = "Anamnesifamiliare.findById", query = "SELECT a FROM Anamnesifamiliare a WHERE a.id = :id")})
public class Anamnesifamiliare implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "osservazioni")
    private String osservazioni;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anamnesifamiliare")
    private List<AnamnesifamiliareHasMalattiefamiliari> anamnesifamiliareHasMalattiefamiliariList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anamnesifamiliare")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Anamnesifamiliare() {
    }

    public Anamnesifamiliare(Integer id) {
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

    public List<AnamnesifamiliareHasMalattiefamiliari> getAnamnesifamiliareHasMalattiefamiliariList() {
        return anamnesifamiliareHasMalattiefamiliariList;
    }

    public void setAnamnesifamiliareHasMalattiefamiliariList(List<AnamnesifamiliareHasMalattiefamiliari> anamnesifamiliareHasMalattiefamiliariList) {
        this.anamnesifamiliareHasMalattiefamiliariList = anamnesifamiliareHasMalattiefamiliariList;
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
        if (!(object instanceof Anamnesifamiliare)) {
            return false;
        }
        Anamnesifamiliare other = (Anamnesifamiliare) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Anamnesifamiliare[id=" + id + "]";
    }

}
