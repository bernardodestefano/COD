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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "disturbi")
@NamedQueries({
    @NamedQuery(name = "Disturbi.findAll", query = "SELECT d FROM Disturbi d"),
    @NamedQuery(name = "Disturbi.findByCuore", query = "SELECT d FROM Disturbi d WHERE d.cuore = :cuore"),
    @NamedQuery(name = "Disturbi.findBySangue", query = "SELECT d FROM Disturbi d WHERE d.sangue = :sangue"),
    @NamedQuery(name = "Disturbi.findByCircolazione", query = "SELECT d FROM Disturbi d WHERE d.circolazione = :circolazione"),
    @NamedQuery(name = "Disturbi.findByReni", query = "SELECT d FROM Disturbi d WHERE d.reni = :reni"),
    @NamedQuery(name = "Disturbi.findByFegato", query = "SELECT d FROM Disturbi d WHERE d.fegato = :fegato"),
    @NamedQuery(name = "Disturbi.findByPolmoni", query = "SELECT d FROM Disturbi d WHERE d.polmoni = :polmoni"),
    @NamedQuery(name = "Disturbi.findByStomaco", query = "SELECT d FROM Disturbi d WHERE d.stomaco = :stomaco"),
    @NamedQuery(name = "Disturbi.findByIntestino", query = "SELECT d FROM Disturbi d WHERE d.intestino = :intestino"),
    @NamedQuery(name = "Disturbi.findBySistemaNervoso", query = "SELECT d FROM Disturbi d WHERE d.sistemaNervoso = :sistemaNervoso"),
    @NamedQuery(name = "Disturbi.findBySistemaEndocrino", query = "SELECT d FROM Disturbi d WHERE d.sistemaEndocrino = :sistemaEndocrino"),
    @NamedQuery(name = "Disturbi.findByTrasfuzioni", query = "SELECT d FROM Disturbi d WHERE d.trasfuzioni = :trasfuzioni"),
    @NamedQuery(name = "Disturbi.findByUltimaTrasfuzioneData", query = "SELECT d FROM Disturbi d WHERE d.ultimaTrasfuzioneData = :ultimaTrasfuzioneData"),
    @NamedQuery(name = "Disturbi.findByAltro", query = "SELECT d FROM Disturbi d WHERE d.altro = :altro"),
    @NamedQuery(name = "Disturbi.findByAnamnesiPersonaleid", query = "SELECT d FROM Disturbi d WHERE d.anamnesiPersonaleid = :anamnesiPersonaleid")})
public class Disturbi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "cuore")
    private Boolean cuore;
    @Column(name = "sangue")
    private Boolean sangue;
    @Column(name = "circolazione")
    private Boolean circolazione;
    @Column(name = "reni")
    private Boolean reni;
    @Column(name = "fegato")
    private Boolean fegato;
    @Column(name = "polmoni")
    private Boolean polmoni;
    @Column(name = "stomaco")
    private Boolean stomaco;
    @Column(name = "intestino")
    private Boolean intestino;
    @Column(name = "sistemaNervoso")
    private Boolean sistemaNervoso;
    @Column(name = "sistemaEndocrino")
    private Boolean sistemaEndocrino;
    @Column(name = "trasfuzioni")
    private Boolean trasfuzioni;
    @Column(name = "ultimaTrasfuzioneData")
    @Temporal(TemporalType.DATE)
    private Date ultimaTrasfuzioneData;
    @Column(name = "altro")
    private String altro;
    @Lob
    @Column(name = "osservazioni")
    private String osservazioni;
    @Id
    @Basic(optional = false)
    @Column(name = "anamnesiPersonale_id")
    private Integer anamnesiPersonaleid;
    @JoinColumn(name = "anamnesiPersonale_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Anamnesipersonale anamnesipersonale;

    public Disturbi() {
    }

    public Disturbi(Integer anamnesiPersonaleid) {
        this.anamnesiPersonaleid = anamnesiPersonaleid;
    }

    public Boolean getCuore() {
        return cuore;
    }

    public void setCuore(Boolean cuore) {
        this.cuore = cuore;
    }

    public Boolean getSangue() {
        return sangue;
    }

    public void setSangue(Boolean sangue) {
        this.sangue = sangue;
    }

    public Boolean getCircolazione() {
        return circolazione;
    }

    public void setCircolazione(Boolean circolazione) {
        this.circolazione = circolazione;
    }

    public Boolean getReni() {
        return reni;
    }

    public void setReni(Boolean reni) {
        this.reni = reni;
    }

    public Boolean getFegato() {
        return fegato;
    }

    public void setFegato(Boolean fegato) {
        this.fegato = fegato;
    }

    public Boolean getPolmoni() {
        return polmoni;
    }

    public void setPolmoni(Boolean polmoni) {
        this.polmoni = polmoni;
    }

    public Boolean getStomaco() {
        return stomaco;
    }

    public void setStomaco(Boolean stomaco) {
        this.stomaco = stomaco;
    }

    public Boolean getIntestino() {
        return intestino;
    }

    public void setIntestino(Boolean intestino) {
        this.intestino = intestino;
    }

    public Boolean getSistemaNervoso() {
        return sistemaNervoso;
    }

    public void setSistemaNervoso(Boolean sistemaNervoso) {
        this.sistemaNervoso = sistemaNervoso;
    }

    public Boolean getSistemaEndocrino() {
        return sistemaEndocrino;
    }

    public void setSistemaEndocrino(Boolean sistemaEndocrino) {
        this.sistemaEndocrino = sistemaEndocrino;
    }

    public Boolean getTrasfuzioni() {
        return trasfuzioni;
    }

    public void setTrasfuzioni(Boolean trasfuzioni) {
        this.trasfuzioni = trasfuzioni;
    }

    public Date getUltimaTrasfuzioneData() {
        return ultimaTrasfuzioneData;
    }

    public void setUltimaTrasfuzioneData(Date ultimaTrasfuzioneData) {
        this.ultimaTrasfuzioneData = ultimaTrasfuzioneData;
    }

    public String getAltro() {
        return altro;
    }

    public void setAltro(String altro) {
        this.altro = altro;
    }

    public String getOsservazioni() {
        return osservazioni;
    }

    public void setOsservazioni(String osservazioni) {
        this.osservazioni = osservazioni;
    }

    public Integer getAnamnesiPersonaleid() {
        return anamnesiPersonaleid;
    }

    public void setAnamnesiPersonaleid(Integer anamnesiPersonaleid) {
        this.anamnesiPersonaleid = anamnesiPersonaleid;
    }

    public Anamnesipersonale getAnamnesipersonale() {
        return anamnesipersonale;
    }

    public void setAnamnesipersonale(Anamnesipersonale anamnesipersonale) {
        this.anamnesipersonale = anamnesipersonale;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anamnesiPersonaleid != null ? anamnesiPersonaleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disturbi)) {
            return false;
        }
        Disturbi other = (Disturbi) object;
        if ((this.anamnesiPersonaleid == null && other.anamnesiPersonaleid != null) || (this.anamnesiPersonaleid != null && !this.anamnesiPersonaleid.equals(other.anamnesiPersonaleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Disturbi[anamnesiPersonaleid=" + anamnesiPersonaleid + "]";
    }

}
