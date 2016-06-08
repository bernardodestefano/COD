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
@Table(name = "esamesierologicotabella")
@NamedQueries({
    @NamedQuery(name = "Esamesierologicotabella.findAll", query = "SELECT e FROM Esamesierologicotabella e"),
    @NamedQuery(name = "Esamesierologicotabella.findById", query = "SELECT e FROM Esamesierologicotabella e WHERE e.id = :id"),
    @NamedQuery(name = "Esamesierologicotabella.findByData", query = "SELECT e FROM Esamesierologicotabella e WHERE e.data = :data"),
    @NamedQuery(name = "Esamesierologicotabella.findByRosolia", query = "SELECT e FROM Esamesierologicotabella e WHERE e.rosolia = :rosolia"),
    @NamedQuery(name = "Esamesierologicotabella.findByToxoplasmosi", query = "SELECT e FROM Esamesierologicotabella e WHERE e.toxoplasmosi = :toxoplasmosi"),
    @NamedQuery(name = "Esamesierologicotabella.findByCitomegalovirus", query = "SELECT e FROM Esamesierologicotabella e WHERE e.citomegalovirus = :citomegalovirus"),
    @NamedQuery(name = "Esamesierologicotabella.findByHbsAg", query = "SELECT e FROM Esamesierologicotabella e WHERE e.hbsAg = :hbsAg"),
    @NamedQuery(name = "Esamesierologicotabella.findByHiv", query = "SELECT e FROM Esamesierologicotabella e WHERE e.hiv = :hiv"),
    @NamedQuery(name = "Esamesierologicotabella.findByHcv", query = "SELECT e FROM Esamesierologicotabella e WHERE e.hcv = :hcv"),
    @NamedQuery(name = "Esamesierologicotabella.findByVdrl", query = "SELECT e FROM Esamesierologicotabella e WHERE e.vdrl = :vdrl")})
public class Esamesierologicotabella implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "rosolia")
    private String rosolia;
    @Column(name = "toxoplasmosi")
    private String toxoplasmosi;
    @Column(name = "citomegalovirus")
    private String citomegalovirus;
    @Column(name = "HbsAg")
    private String hbsAg;
    @Column(name = "HIV")
    private String hiv;
    @Column(name = "HCV")
    private String hcv;
    @Column(name = "VDRL")
    private String vdrl;
    @JoinColumn(name = "esameSierologico_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Esamesierologico esamesierologico;

    public Esamesierologicotabella() {
    }

    public Esamesierologicotabella(Integer id) {
        this.id = id;
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

    public String getRosolia() {
        return rosolia;
    }

    public void setRosolia(String rosolia) {
        this.rosolia = rosolia;
    }

    public String getToxoplasmosi() {
        return toxoplasmosi;
    }

    public void setToxoplasmosi(String toxoplasmosi) {
        this.toxoplasmosi = toxoplasmosi;
    }

    public String getCitomegalovirus() {
        return citomegalovirus;
    }

    public void setCitomegalovirus(String citomegalovirus) {
        this.citomegalovirus = citomegalovirus;
    }

    public String getHbsAg() {
        return hbsAg;
    }

    public void setHbsAg(String hbsAg) {
        this.hbsAg = hbsAg;
    }

    public String getHiv() {
        return hiv;
    }

    public void setHiv(String hiv) {
        this.hiv = hiv;
    }

    public String getHcv() {
        return hcv;
    }

    public void setHcv(String hcv) {
        this.hcv = hcv;
    }

    public String getVdrl() {
        return vdrl;
    }

    public void setVdrl(String vdrl) {
        this.vdrl = vdrl;
    }

    public Esamesierologico getEsamesierologico() {
        return esamesierologico;
    }

    public void setEsamesierologico(Esamesierologico esamesierologico) {
        this.esamesierologico = esamesierologico;
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
        if (!(object instanceof Esamesierologicotabella)) {
            return false;
        }
        Esamesierologicotabella other = (Esamesierologicotabella) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Esamesierologicotabella[id=" + id + "]";
    }

}
