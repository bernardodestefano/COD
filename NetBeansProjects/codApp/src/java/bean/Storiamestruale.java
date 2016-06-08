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
@Table(name = "storiamestruale")
@NamedQueries({
    @NamedQuery(name = "Storiamestruale.findAll", query = "SELECT s FROM Storiamestruale s"),
    @NamedQuery(name = "Storiamestruale.findById", query = "SELECT s FROM Storiamestruale s WHERE s.id = :id"),
    @NamedQuery(name = "Storiamestruale.findByMenarca", query = "SELECT s FROM Storiamestruale s WHERE s.menarca = :menarca"),
    @NamedQuery(name = "Storiamestruale.findByRitmo", query = "SELECT s FROM Storiamestruale s WHERE s.ritmo = :ritmo"),
    @NamedQuery(name = "Storiamestruale.findByDurata", query = "SELECT s FROM Storiamestruale s WHERE s.durata = :durata"),
    @NamedQuery(name = "Storiamestruale.findByQuantita", query = "SELECT s FROM Storiamestruale s WHERE s.quantita = :quantita"),
    @NamedQuery(name = "Storiamestruale.findByDismorrea", query = "SELECT s FROM Storiamestruale s WHERE s.dismorrea = :dismorrea")})
public class Storiamestruale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "menarca")
    private Integer menarca;
    @Column(name = "ritmo")
    private Integer ritmo;
    @Column(name = "durata")
    private Integer durata;
    @Column(name = "quantita")
    private String quantita;
    @Column(name = "dismorrea")
    private String dismorrea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storiamestruale")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Storiamestruale() {
    }

    public Storiamestruale(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenarca() {
        return menarca;
    }

    public void setMenarca(Integer menarca) {
        this.menarca = menarca;
    }

    public Integer getRitmo() {
        return ritmo;
    }

    public void setRitmo(Integer ritmo) {
        this.ritmo = ritmo;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public String getQuantita() {
        return quantita;
    }

    public void setQuantita(String quantita) {
        this.quantita = quantita;
    }

    public String getDismorrea() {
        return dismorrea;
    }

    public void setDismorrea(String dismorrea) {
        this.dismorrea = dismorrea;
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
        if (!(object instanceof Storiamestruale)) {
            return false;
        }
        Storiamestruale other = (Storiamestruale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Storiamestruale[id=" + id + "]";
    }

}
