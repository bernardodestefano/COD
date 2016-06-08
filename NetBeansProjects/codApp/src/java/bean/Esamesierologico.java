/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "esamesierologico")
@NamedQueries({
    @NamedQuery(name = "Esamesierologico.findAll", query = "SELECT e FROM Esamesierologico e"),
    @NamedQuery(name = "Esamesierologico.findById", query = "SELECT e FROM Esamesierologico e WHERE e.id = :id"),
    @NamedQuery(name = "Esamesierologico.findByTamponeVaginaleRettale", query = "SELECT e FROM Esamesierologico e WHERE e.tamponeVaginaleRettale = :tamponeVaginaleRettale"),
    @NamedQuery(name = "Esamesierologico.findByData", query = "SELECT e FROM Esamesierologico e WHERE e.data = :data")})
public class Esamesierologico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tamponeVaginaleRettale")
    private String tamponeVaginaleRettale;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Lob
    @Column(name = "terapia")
    private String terapia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "esamesierologico")
    private List<Esamesierologicotabella> esamesierologicotabellaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "esamesierologico")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Esamesierologico() {
    }

    public Esamesierologico(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTamponeVaginaleRettale() {
        return tamponeVaginaleRettale;
    }

    public void setTamponeVaginaleRettale(String tamponeVaginaleRettale) {
        this.tamponeVaginaleRettale = tamponeVaginaleRettale;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTerapia() {
        return terapia;
    }

    public void setTerapia(String terapia) {
        this.terapia = terapia;
    }

    public List<Esamesierologicotabella> getEsamesierologicotabellaList() {
        return esamesierologicotabellaList;
    }

    public void setEsamesierologicotabellaList(List<Esamesierologicotabella> esamesierologicotabellaList) {
        this.esamesierologicotabellaList = esamesierologicotabellaList;
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
        if (!(object instanceof Esamesierologico)) {
            return false;
        }
        Esamesierologico other = (Esamesierologico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Esamesierologico[id=" + id + "]";
    }

}
