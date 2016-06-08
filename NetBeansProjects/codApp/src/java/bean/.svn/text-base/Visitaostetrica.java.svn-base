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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "visitaostetrica")
@NamedQueries({
    @NamedQuery(name = "Visitaostetrica.findAll", query = "SELECT v FROM Visitaostetrica v"),
    @NamedQuery(name = "Visitaostetrica.findById", query = "SELECT v FROM Visitaostetrica v WHERE v.id = :id")})
public class Visitaostetrica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visitaostetrica")
    private List<Visitaostetricatabella> visitaostetricatabellaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visitaostetrica")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Visitaostetrica() {
    }

    public Visitaostetrica(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Visitaostetricatabella> getVisitaostetricatabellaList() {
        return visitaostetricatabellaList;
    }

    public void setVisitaostetricatabellaList(List<Visitaostetricatabella> visitaostetricatabellaList) {
        this.visitaostetricatabellaList = visitaostetricatabellaList;
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
        if (!(object instanceof Visitaostetrica)) {
            return false;
        }
        Visitaostetrica other = (Visitaostetrica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Visitaostetrica[id=" + id + "]";
    }

}
