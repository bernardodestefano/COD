/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "ecografiatabella")
@NamedQueries({
    @NamedQuery(name = "Ecografiatabella.findAll", query = "SELECT e FROM Ecografiatabella e"),
    @NamedQuery(name = "Ecografiatabella.findById", query = "SELECT e FROM Ecografiatabella e WHERE e.id = :id"),
    @NamedQuery(name = "Ecografiatabella.findByData", query = "SELECT e FROM Ecografiatabella e WHERE e.data = :data"),
    @NamedQuery(name = "Ecografiatabella.findByDatazione", query = "SELECT e FROM Ecografiatabella e WHERE e.datazione = :datazione"),
    @NamedQuery(name = "Ecografiatabella.findByMorfologica", query = "SELECT e FROM Ecografiatabella e WHERE e.morfologica = :morfologica"),
    @NamedQuery(name = "Ecografiatabella.findByAltre", query = "SELECT e FROM Ecografiatabella e WHERE e.altre = :altre")})
public class Ecografiatabella implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "datazione")
    @Temporal(TemporalType.DATE)
    private Date datazione;
    @Column(name = "morfologica")
    private String morfologica;
    @Column(name = "altre")
    private String altre;
    @JoinColumn(name = "storiaOstetrica_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ecografie ecografie;

    public Ecografiatabella() {
    }

    public Ecografiatabella(Integer id) {
        this.id = id;
    }

    public Ecografiatabella(Integer id, Date data) {
        this.id = id;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDatazione() {
        return datazione;
    }

    public void setDatazione(Date datazione) {
        this.datazione = datazione;
    }

    public String getMorfologica() {
        return morfologica;
    }

    public void setMorfologica(String morfologica) {
        this.morfologica = morfologica;
    }

    public String getAltre() {
        return altre;
    }

    public void setAltre(String altre) {
        this.altre = altre;
    }

    public Ecografie getEcografie() {
        return ecografie;
    }

    public void setEcografie(Ecografie ecografie) {
        this.ecografie = ecografie;
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
        if (!(object instanceof Ecografiatabella)) {
            return false;
        }
        Ecografiatabella other = (Ecografiatabella) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Ecografiatabella[id=" + id + "]";
    }

}
