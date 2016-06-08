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
@Table(name = "anamnesipartner")
@NamedQueries({
    @NamedQuery(name = "Anamnesipartner.findAll", query = "SELECT a FROM Anamnesipartner a"),
    @NamedQuery(name = "Anamnesipartner.findById", query = "SELECT a FROM Anamnesipartner a WHERE a.id = :id"),
    @NamedQuery(name = "Anamnesipartner.findByNome", query = "SELECT a FROM Anamnesipartner a WHERE a.nome = :nome"),
    @NamedQuery(name = "Anamnesipartner.findByCognome", query = "SELECT a FROM Anamnesipartner a WHERE a.cognome = :cognome"),
    @NamedQuery(name = "Anamnesipartner.findByDataNascita", query = "SELECT a FROM Anamnesipartner a WHERE a.dataNascita = :dataNascita"),
    @NamedQuery(name = "Anamnesipartner.findByGruppoSangue", query = "SELECT a FROM Anamnesipartner a WHERE a.gruppoSangue = :gruppoSangue"),
    @NamedQuery(name = "Anamnesipartner.findByPesoNascita", query = "SELECT a FROM Anamnesipartner a WHERE a.pesoNascita = :pesoNascita"),
    @NamedQuery(name = "Anamnesipartner.findByTitoloStudio", query = "SELECT a FROM Anamnesipartner a WHERE a.titoloStudio = :titoloStudio"),
    @NamedQuery(name = "Anamnesipartner.findByProfessione", query = "SELECT a FROM Anamnesipartner a WHERE a.professione = :professione"),
    @NamedQuery(name = "Anamnesipartner.findByFumo", query = "SELECT a FROM Anamnesipartner a WHERE a.fumo = :fumo"),
    @NamedQuery(name = "Anamnesipartner.findByAlcool", query = "SELECT a FROM Anamnesipartner a WHERE a.alcool = :alcool"),
    @NamedQuery(name = "Anamnesipartner.findByFarmaci", query = "SELECT a FROM Anamnesipartner a WHERE a.farmaci = :farmaci"),
    @NamedQuery(name = "Anamnesipartner.findByMalattieFamiliari", query = "SELECT a FROM Anamnesipartner a WHERE a.malattieFamiliari = :malattieFamiliari"),
    @NamedQuery(name = "Anamnesipartner.findByMalattiePersonali", query = "SELECT a FROM Anamnesipartner a WHERE a.malattiePersonali = :malattiePersonali")})
public class Anamnesipartner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "dataNascita")
    @Temporal(TemporalType.DATE)
    private Date dataNascita;
    @Column(name = "gruppoSangue")
    private String gruppoSangue;
    @Column(name = "pesoNascita")
    private Double pesoNascita;
    @Column(name = "titoloStudio")
    private String titoloStudio;
    @Column(name = "professione")
    private String professione;
    @Column(name = "fumo")
    private Boolean fumo;
    @Column(name = "alcool")
    private Boolean alcool;
    @Column(name = "farmaci")
    private Boolean farmaci;
    @Column(name = "malattieFamiliari")
    private String malattieFamiliari;
    @Column(name = "malattiePersonali")
    private String malattiePersonali;
    @Lob
    @Column(name = "osservazioni")
    private String osservazioni;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anamnesipartner")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Anamnesipartner() {
    }

    public Anamnesipartner(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getGruppoSangue() {
        return gruppoSangue;
    }

    public void setGruppoSangue(String gruppoSangue) {
        this.gruppoSangue = gruppoSangue;
    }

    public Double getPesoNascita() {
        return pesoNascita;
    }

    public void setPesoNascita(Double pesoNascita) {
        this.pesoNascita = pesoNascita;
    }

    public String getTitoloStudio() {
        return titoloStudio;
    }

    public void setTitoloStudio(String titoloStudio) {
        this.titoloStudio = titoloStudio;
    }

    public String getProfessione() {
        return professione;
    }

    public void setProfessione(String professione) {
        this.professione = professione;
    }

    public Boolean getFumo() {
        return fumo;
    }

    public void setFumo(Boolean fumo) {
        this.fumo = fumo;
    }

    public Boolean getAlcool() {
        return alcool;
    }

    public void setAlcool(Boolean alcool) {
        this.alcool = alcool;
    }

    public Boolean getFarmaci() {
        return farmaci;
    }

    public void setFarmaci(Boolean farmaci) {
        this.farmaci = farmaci;
    }

    public String getMalattieFamiliari() {
        return malattieFamiliari;
    }

    public void setMalattieFamiliari(String malattieFamiliari) {
        this.malattieFamiliari = malattieFamiliari;
    }

    public String getMalattiePersonali() {
        return malattiePersonali;
    }

    public void setMalattiePersonali(String malattiePersonali) {
        this.malattiePersonali = malattiePersonali;
    }

    public String getOsservazioni() {
        return osservazioni;
    }

    public void setOsservazioni(String osservazioni) {
        this.osservazioni = osservazioni;
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
        if (!(object instanceof Anamnesipartner)) {
            return false;
        }
        Anamnesipartner other = (Anamnesipartner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Anamnesipartner[id=" + id + "]";
    }

     public static final String GRUPPOSANGUIGNOPARTNER_APOSITIVO ="Apositivo";
     public static final String GRUPPOSANGUIGNOPARTNER_ANEGATIVO ="Anegativo";
     public static final String GRUPPOSANGUIGNOPARTNER_BPOSITIVO ="Bpositivo";
     public static final String GRUPPOSANGUIGNOPARTNER_BNEGATIVO ="Bnegativo";
     public static final String GRUPPOSANGUIGNOPARTNER_0POSITIVO ="0positivo";
     public static final String GRUPPOSANGUIGNOPARTNER_0NEGATIVO ="0negativo";
     public static final String GRUPPOSANGUIGNOPARTNER_ABPOSITIVO ="ABpositivo";
     public static final String GRUPPOSANGUIGNOPARTNER_ABNEGATIVO ="ABnegativo";
}
