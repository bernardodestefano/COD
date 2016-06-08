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
@Table(name = "decorsodellagravidanza")
@NamedQueries({
    @NamedQuery(name = "Decorsodellagravidanza.findAll", query = "SELECT d FROM Decorsodellagravidanza d"),
    @NamedQuery(name = "Decorsodellagravidanza.findById", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.id = :id"),
    @NamedQuery(name = "Decorsodellagravidanza.findByTestGravidanza", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.testGravidanza = :testGravidanza"),
    @NamedQuery(name = "Decorsodellagravidanza.findByCicloPrecedente", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.cicloPrecedente = :cicloPrecedente"),
    @NamedQuery(name = "Decorsodellagravidanza.findByDpp", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.dpp = :dpp"),
    @NamedQuery(name = "Decorsodellagravidanza.findByUMCerta", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.uMCerta = :uMCerta"),
    @NamedQuery(name = "Decorsodellagravidanza.findByDecorsoGravidanzaFinoAllaPrimaVisita", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.decorsoGravidanzaFinoAllaPrimaVisita = :decorsoGravidanzaFinoAllaPrimaVisita"),
    @NamedQuery(name = "Decorsodellagravidanza.findByMinacciaAborto", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.minacciaAborto = :minacciaAborto"),
    @NamedQuery(name = "Decorsodellagravidanza.findByNausea", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.nausea = :nausea"),
    @NamedQuery(name = "Decorsodellagravidanza.findByVomito", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.vomito = :vomito"),
    @NamedQuery(name = "Decorsodellagravidanza.findByFarmaciAssunti", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.farmaciAssunti = :farmaciAssunti"),
    @NamedQuery(name = "Decorsodellagravidanza.findByPesoPregravidico", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.pesoPregravidico = :pesoPregravidico"),
    @NamedQuery(name = "Decorsodellagravidanza.findByStatura", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.statura = :statura"),
    @NamedQuery(name = "Decorsodellagravidanza.findByColorito", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.colorito = :colorito"),
    @NamedQuery(name = "Decorsodellagravidanza.findByVarici", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.varici = :varici"),
    @NamedQuery(name = "Decorsodellagravidanza.findByEdemi", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.edemi = :edemi"),
    @NamedQuery(name = "Decorsodellagravidanza.findByEczemi", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.eczemi = :eczemi"),
    @NamedQuery(name = "Decorsodellagravidanza.findByVista", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.vista = :vista"),
    @NamedQuery(name = "Decorsodellagravidanza.findBySeno", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.seno = :seno"),
    @NamedQuery(name = "Decorsodellagravidanza.findByFunzioneIntestino", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.funzioneIntestino = :funzioneIntestino"),
    @NamedQuery(name = "Decorsodellagravidanza.findByFunzioneVescica", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.funzioneVescica = :funzioneVescica"),
    @NamedQuery(name = "Decorsodellagravidanza.findByGruppoSanguignoMadre", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.gruppoSanguignoMadre = :gruppoSanguignoMadre"),
    @NamedQuery(name = "Decorsodellagravidanza.findByGruppoSanguignoPadre", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.gruppoSanguignoPadre = :gruppoSanguignoPadre"),
    @NamedQuery(name = "Decorsodellagravidanza.findByPrimiMovimentiFetali", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.primiMovimentiFetali = :primiMovimentiFetali"),
    @NamedQuery(name = "Decorsodellagravidanza.findByData", query = "SELECT d FROM Decorsodellagravidanza d WHERE d.data = :data")})
public class Decorsodellagravidanza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "testGravidanza")
    private String testGravidanza;
    @Column(name = "cicloPrecedente")
    @Temporal(TemporalType.DATE)
    private Date cicloPrecedente;
    @Column(name = "DPP")
    private String dpp;
    @Column(name = "UMCerta")
    private Boolean uMCerta;
    @Column(name = "decorsoGravidanzaFinoAllaPrimaVisita")
    private String decorsoGravidanzaFinoAllaPrimaVisita;
    @Column(name = "minacciaAborto")
    private String minacciaAborto;
    @Column(name = "nausea")
    private Boolean nausea;
    @Column(name = "vomito")
    private Boolean vomito;
    @Column(name = "farmaciAssunti")
    private String farmaciAssunti;
    @Column(name = "pesoPregravidico")
    private Double pesoPregravidico;
    @Column(name = "statura")
    private Double statura;
    @Column(name = "colorito")
    private String colorito;
    @Column(name = "varici")
    private String varici;
    @Column(name = "edemi")
    private String edemi;
    @Column(name = "eczemi")
    private String eczemi;
    @Column(name = "vista")
    private String vista;
    @Column(name = "seno")
    private String seno;
    @Column(name = "funzioneIntestino")
    private String funzioneIntestino;
    @Column(name = "funzioneVescica")
    private String funzioneVescica;
    @Lob
    @Column(name = "altro")
    private String altro;
    @Column(name = "gruppoSanguignoMadre")
    private String gruppoSanguignoMadre;
    @Column(name = "gruppoSanguignoPadre")
    private String gruppoSanguignoPadre;
    @Column(name = "primiMovimentiFetali")
    private String primiMovimentiFetali;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "decorsodellagravidanza")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Decorsodellagravidanza() {
    }

    public Decorsodellagravidanza(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestGravidanza() {
        return testGravidanza;
    }

    public void setTestGravidanza(String testGravidanza) {
        this.testGravidanza = testGravidanza;
    }

    public Date getCicloPrecedente() {
        return cicloPrecedente;
    }

    public void setCicloPrecedente(Date cicloPrecedente) {
        this.cicloPrecedente = cicloPrecedente;
    }

    public String getDpp() {
        return dpp;
    }

    public void setDpp(String dpp) {
        this.dpp = dpp;
    }

    public Boolean getUMCerta() {
        return uMCerta;
    }

    public void setUMCerta(Boolean uMCerta) {
        this.uMCerta = uMCerta;
    }

    public String getDecorsoGravidanzaFinoAllaPrimaVisita() {
        return decorsoGravidanzaFinoAllaPrimaVisita;
    }

    public void setDecorsoGravidanzaFinoAllaPrimaVisita(String decorsoGravidanzaFinoAllaPrimaVisita) {
        this.decorsoGravidanzaFinoAllaPrimaVisita = decorsoGravidanzaFinoAllaPrimaVisita;
    }

    public String getMinacciaAborto() {
        return minacciaAborto;
    }

    public void setMinacciaAborto(String minacciaAborto) {
        this.minacciaAborto = minacciaAborto;
    }

    public Boolean getNausea() {
        return nausea;
    }

    public void setNausea(Boolean nausea) {
        this.nausea = nausea;
    }

    public Boolean getVomito() {
        return vomito;
    }

    public void setVomito(Boolean vomito) {
        this.vomito = vomito;
    }

    public String getFarmaciAssunti() {
        return farmaciAssunti;
    }

    public void setFarmaciAssunti(String farmaciAssunti) {
        this.farmaciAssunti = farmaciAssunti;
    }

    public Double getPesoPregravidico() {
        return pesoPregravidico;
    }

    public void setPesoPregravidico(Double pesoPregravidico) {
        this.pesoPregravidico = pesoPregravidico;
    }

    public Double getStatura() {
        return statura;
    }

    public void setStatura(Double statura) {
        this.statura = statura;
    }

    public String getColorito() {
        return colorito;
    }

    public void setColorito(String colorito) {
        this.colorito = colorito;
    }

    public String getVarici() {
        return varici;
    }

    public void setVarici(String varici) {
        this.varici = varici;
    }

    public String getEdemi() {
        return edemi;
    }

    public void setEdemi(String edemi) {
        this.edemi = edemi;
    }

    public String getEczemi() {
        return eczemi;
    }

    public void setEczemi(String eczemi) {
        this.eczemi = eczemi;
    }

    public String getVista() {
        return vista;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }

    public String getSeno() {
        return seno;
    }

    public void setSeno(String seno) {
        this.seno = seno;
    }

    public String getFunzioneIntestino() {
        return funzioneIntestino;
    }

    public void setFunzioneIntestino(String funzioneIntestino) {
        this.funzioneIntestino = funzioneIntestino;
    }

    public String getFunzioneVescica() {
        return funzioneVescica;
    }

    public void setFunzioneVescica(String funzioneVescica) {
        this.funzioneVescica = funzioneVescica;
    }

    public String getAltro() {
        return altro;
    }

    public void setAltro(String altro) {
        this.altro = altro;
    }

    public String getGruppoSanguignoMadre() {
        return gruppoSanguignoMadre;
    }

    public void setGruppoSanguignoMadre(String gruppoSanguignoMadre) {
        this.gruppoSanguignoMadre = gruppoSanguignoMadre;
    }

    public String getGruppoSanguignoPadre() {
        return gruppoSanguignoPadre;
    }

    public void setGruppoSanguignoPadre(String gruppoSanguignoPadre) {
        this.gruppoSanguignoPadre = gruppoSanguignoPadre;
    }

    public String getPrimiMovimentiFetali() {
        return primiMovimentiFetali;
    }

    public void setPrimiMovimentiFetali(String primiMovimentiFetali) {
        this.primiMovimentiFetali = primiMovimentiFetali;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        if (!(object instanceof Decorsodellagravidanza)) {
            return false;
        }
        Decorsodellagravidanza other = (Decorsodellagravidanza) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Decorsodellagravidanza[id=" + id + "]";
    }

}
