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
@Table(name = "esameematochimicitabella")
@NamedQueries({
    @NamedQuery(name = "Esameematochimicitabella.findAll", query = "SELECT e FROM Esameematochimicitabella e"),
    @NamedQuery(name = "Esameematochimicitabella.findById", query = "SELECT e FROM Esameematochimicitabella e WHERE e.id = :id"),
    @NamedQuery(name = "Esameematochimicitabella.findByData", query = "SELECT e FROM Esameematochimicitabella e WHERE e.data = :data"),
    @NamedQuery(name = "Esameematochimicitabella.findBySettimana", query = "SELECT e FROM Esameematochimicitabella e WHERE e.settimana = :settimana"),
    @NamedQuery(name = "Esameematochimicitabella.findByUrocultura", query = "SELECT e FROM Esameematochimicitabella e WHERE e.urocultura = :urocultura"),
    @NamedQuery(name = "Esameematochimicitabella.findByGb", query = "SELECT e FROM Esameematochimicitabella e WHERE e.gb = :gb"),
    @NamedQuery(name = "Esameematochimicitabella.findByGr", query = "SELECT e FROM Esameematochimicitabella e WHERE e.gr = :gr"),
    @NamedQuery(name = "Esameematochimicitabella.findByEmoglobina", query = "SELECT e FROM Esameematochimicitabella e WHERE e.emoglobina = :emoglobina"),
    @NamedQuery(name = "Esameematochimicitabella.findByEmatocrito", query = "SELECT e FROM Esameematochimicitabella e WHERE e.ematocrito = :ematocrito"),
    @NamedQuery(name = "Esameematochimicitabella.findByVolGlobuliMedio", query = "SELECT e FROM Esameematochimicitabella e WHERE e.volGlobuliMedio = :volGlobuliMedio"),
    @NamedQuery(name = "Esameematochimicitabella.findByContenutoEmoglobinaMedio", query = "SELECT e FROM Esameematochimicitabella e WHERE e.contenutoEmoglobinaMedio = :contenutoEmoglobinaMedio"),
    @NamedQuery(name = "Esameematochimicitabella.findByPiastrine", query = "SELECT e FROM Esameematochimicitabella e WHERE e.piastrine = :piastrine"),
    @NamedQuery(name = "Esameematochimicitabella.findByGlicemia", query = "SELECT e FROM Esameematochimicitabella e WHERE e.glicemia = :glicemia"),
    @NamedQuery(name = "Esameematochimicitabella.findByRicercaABArteritrociti", query = "SELECT e FROM Esameematochimicitabella e WHERE e.ricercaABArteritrociti = :ricercaABArteritrociti"),
    @NamedQuery(name = "Esameematochimicitabella.findByEsameUrineAlbumina", query = "SELECT e FROM Esameematochimicitabella e WHERE e.esameUrineAlbumina = :esameUrineAlbumina"),
    @NamedQuery(name = "Esameematochimicitabella.findByEsameUrineGlucosio", query = "SELECT e FROM Esameematochimicitabella e WHERE e.esameUrineGlucosio = :esameUrineGlucosio"),
    @NamedQuery(name = "Esameematochimicitabella.findByEsameUrineSedimento", query = "SELECT e FROM Esameematochimicitabella e WHERE e.esameUrineSedimento = :esameUrineSedimento")})
public class Esameematochimicitabella implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "settimana")
    private Integer settimana;
    @Column(name = "urocultura")
    private String urocultura;
    @Column(name = "GB")
    private Double gb;
    @Column(name = "GR")
    private Double gr;
    @Column(name = "emoglobina")
    private Double emoglobina;
    @Column(name = "ematocrito")
    private Double ematocrito;
    @Column(name = "volGlobuliMedio")
    private Double volGlobuliMedio;
    @Column(name = "contenutoEmoglobinaMedio")
    private Double contenutoEmoglobinaMedio;
    @Column(name = "piastrine")
    private Double piastrine;
    @Column(name = "glicemia")
    private Double glicemia;
    @Column(name = "ricercaABArteritrociti")
    private String ricercaABArteritrociti;
    @Column(name = "esameUrineAlbumina")
    private Double esameUrineAlbumina;
    @Column(name = "esameUrineGlucosio")
    private Double esameUrineGlucosio;
    @Column(name = "esameUrineSedimento")
    private Double esameUrineSedimento;
    @JoinColumn(name = "esameEmatochimici_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Esameematochimici esameematochimici;

    public Esameematochimicitabella() {
    }

    public Esameematochimicitabella(Integer id) {
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

    public Integer getSettimana() {
        return settimana;
    }

    public void setSettimana(Integer settimana) {
        this.settimana = settimana;
    }

    public String getUrocultura() {
        return urocultura;
    }

    public void setUrocultura(String urocultura) {
        this.urocultura = urocultura;
    }

    public Double getGb() {
        return gb;
    }

    public void setGb(Double gb) {
        this.gb = gb;
    }

    public Double getGr() {
        return gr;
    }

    public void setGr(Double gr) {
        this.gr = gr;
    }

    public Double getEmoglobina() {
        return emoglobina;
    }

    public void setEmoglobina(Double emoglobina) {
        this.emoglobina = emoglobina;
    }

    public Double getEmatocrito() {
        return ematocrito;
    }

    public void setEmatocrito(Double ematocrito) {
        this.ematocrito = ematocrito;
    }

    public Double getVolGlobuliMedio() {
        return volGlobuliMedio;
    }

    public void setVolGlobuliMedio(Double volGlobuliMedio) {
        this.volGlobuliMedio = volGlobuliMedio;
    }

    public Double getContenutoEmoglobinaMedio() {
        return contenutoEmoglobinaMedio;
    }

    public void setContenutoEmoglobinaMedio(Double contenutoEmoglobinaMedio) {
        this.contenutoEmoglobinaMedio = contenutoEmoglobinaMedio;
    }

    public Double getPiastrine() {
        return piastrine;
    }

    public void setPiastrine(Double piastrine) {
        this.piastrine = piastrine;
    }

    public Double getGlicemia() {
        return glicemia;
    }

    public void setGlicemia(Double glicemia) {
        this.glicemia = glicemia;
    }

    public String getRicercaABArteritrociti() {
        return ricercaABArteritrociti;
    }

    public void setRicercaABArteritrociti(String ricercaABArteritrociti) {
        this.ricercaABArteritrociti = ricercaABArteritrociti;
    }

    public Double getEsameUrineAlbumina() {
        return esameUrineAlbumina;
    }

    public void setEsameUrineAlbumina(Double esameUrineAlbumina) {
        this.esameUrineAlbumina = esameUrineAlbumina;
    }

    public Double getEsameUrineGlucosio() {
        return esameUrineGlucosio;
    }

    public void setEsameUrineGlucosio(Double esameUrineGlucosio) {
        this.esameUrineGlucosio = esameUrineGlucosio;
    }

    public Double getEsameUrineSedimento() {
        return esameUrineSedimento;
    }

    public void setEsameUrineSedimento(Double esameUrineSedimento) {
        this.esameUrineSedimento = esameUrineSedimento;
    }

    public Esameematochimici getEsameematochimici() {
        return esameematochimici;
    }

    public void setEsameematochimici(Esameematochimici esameematochimici) {
        this.esameematochimici = esameematochimici;
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
        if (!(object instanceof Esameematochimicitabella)) {
            return false;
        }
        Esameematochimicitabella other = (Esameematochimicitabella) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Esameematochimicitabella[id=" + id + "]";
    }

}
