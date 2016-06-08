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
@Table(name = "abitudinidivita")
@NamedQueries({
    @NamedQuery(name = "Abitudinidivita.findAll", query = "SELECT a FROM Abitudinidivita a"),
    @NamedQuery(name = "Abitudinidivita.findById", query = "SELECT a FROM Abitudinidivita a WHERE a.id = :id"),
    @NamedQuery(name = "Abitudinidivita.findByLavoro", query = "SELECT a FROM Abitudinidivita a WHERE a.lavoro = :lavoro"),
    @NamedQuery(name = "Abitudinidivita.findByAttivitaDomestica", query = "SELECT a FROM Abitudinidivita a WHERE a.attivitaDomestica = :attivitaDomestica"),
    @NamedQuery(name = "Abitudinidivita.findByAttivitaCorporea", query = "SELECT a FROM Abitudinidivita a WHERE a.attivitaCorporea = :attivitaCorporea"),
    @NamedQuery(name = "Abitudinidivita.findByAbitazione", query = "SELECT a FROM Abitudinidivita a WHERE a.abitazione = :abitazione"),
    @NamedQuery(name = "Abitudinidivita.findByViaggi", query = "SELECT a FROM Abitudinidivita a WHERE a.viaggi = :viaggi"),
    @NamedQuery(name = "Abitudinidivita.findByAlimentazione", query = "SELECT a FROM Abitudinidivita a WHERE a.alimentazione = :alimentazione"),
    @NamedQuery(name = "Abitudinidivita.findByMetodoCura", query = "SELECT a FROM Abitudinidivita a WHERE a.metodoCura = :metodoCura"),
    @NamedQuery(name = "Abitudinidivita.findByFumo", query = "SELECT a FROM Abitudinidivita a WHERE a.fumo = :fumo"),
    @NamedQuery(name = "Abitudinidivita.findByQtaGiornalieraSigarettePrimaGravidanza", query = "SELECT a FROM Abitudinidivita a WHERE a.qtaGiornalieraSigarettePrimaGravidanza = :qtaGiornalieraSigarettePrimaGravidanza"),
    @NamedQuery(name = "Abitudinidivita.findByQtaGiornalieraSigaretteDuranteGravidanza", query = "SELECT a FROM Abitudinidivita a WHERE a.qtaGiornalieraSigaretteDuranteGravidanza = :qtaGiornalieraSigaretteDuranteGravidanza"),
    @NamedQuery(name = "Abitudinidivita.findByCaffe", query = "SELECT a FROM Abitudinidivita a WHERE a.caffe = :caffe"),
    @NamedQuery(name = "Abitudinidivita.findByQuantitaCaffeAlGiorno", query = "SELECT a FROM Abitudinidivita a WHERE a.quantitaCaffeAlGiorno = :quantitaCaffeAlGiorno"),
    @NamedQuery(name = "Abitudinidivita.findByAlcool", query = "SELECT a FROM Abitudinidivita a WHERE a.alcool = :alcool"),
    @NamedQuery(name = "Abitudinidivita.findByQuantitaAlcoolAlMese", query = "SELECT a FROM Abitudinidivita a WHERE a.quantitaAlcoolAlMese = :quantitaAlcoolAlMese"),
    @NamedQuery(name = "Abitudinidivita.findByStupefacenti", query = "SELECT a FROM Abitudinidivita a WHERE a.stupefacenti = :stupefacenti"),
    @NamedQuery(name = "Abitudinidivita.findByAltreOsservazioni", query = "SELECT a FROM Abitudinidivita a WHERE a.altreOsservazioni = :altreOsservazioni"),
    @NamedQuery(name = "Abitudinidivita.findByQuantitaStupefacentiAlMese", query = "SELECT a FROM Abitudinidivita a WHERE a.quantitaStupefacentiAlMese = :quantitaStupefacentiAlMese"),
    @NamedQuery(name = "Abitudinidivita.findByFarmaciAbituali", query = "SELECT a FROM Abitudinidivita a WHERE a.farmaciAbituali = :farmaciAbituali")})
public class Abitudinidivita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "lavoro")
    private String lavoro;
    @Column(name = "attivitaDomestica")
    private String attivitaDomestica;
    @Column(name = "attivitaCorporea")
    private String attivitaCorporea;
    @Column(name = "abitazione")
    private String abitazione;
    @Column(name = "viaggi")
    private String viaggi;
    @Column(name = "alimentazione")
    private String alimentazione;
    @Column(name = "metodoCura")
    private String metodoCura;
    @Column(name = "fumo")
    private Boolean fumo;
    @Column(name = "qtaGiornalieraSigarettePrimaGravidanza")
    private Integer qtaGiornalieraSigarettePrimaGravidanza;
    @Column(name = "qtaGiornalieraSigaretteDuranteGravidanza")
    private Integer qtaGiornalieraSigaretteDuranteGravidanza;
    @Column(name = "caffe")
    private Boolean caffe;
    @Column(name = "quantitaCaffeAlGiorno")
    private Integer quantitaCaffeAlGiorno;
    @Column(name = "alcool")
    private Boolean alcool;
    @Column(name = "quantitaAlcoolAlMese")
    private Integer quantitaAlcoolAlMese;
    @Column(name = "stupefacenti")
    private Boolean stupefacenti;
    @Column(name = "AltreOsservazioni")
    private String altreOsservazioni;
    @Column(name = "quantitaStupefacentiAlMese")
    private String quantitaStupefacentiAlMese;
    @Column(name = "FarmaciAbituali")
    private String farmaciAbituali;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "abitudinidivita")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Abitudinidivita() {
    }

    public Abitudinidivita(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLavoro() {
        return lavoro;
    }

    public void setLavoro(String lavoro) {
        this.lavoro = lavoro;
    }

    public String getAttivitaDomestica() {
        return attivitaDomestica;
    }

    public void setAttivitaDomestica(String attivitaDomestica) {
        this.attivitaDomestica = attivitaDomestica;
    }

    public String getAttivitaCorporea() {
        return attivitaCorporea;
    }

    public void setAttivitaCorporea(String attivitaCorporea) {
        this.attivitaCorporea = attivitaCorporea;
    }

    public String getAbitazione() {
        return abitazione;
    }

    public void setAbitazione(String abitazione) {
        this.abitazione = abitazione;
    }

    public String getViaggi() {
        return viaggi;
    }

    public void setViaggi(String viaggi) {
        this.viaggi = viaggi;
    }

    public String getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
    }

    public String getMetodoCura() {
        return metodoCura;
    }

    public void setMetodoCura(String metodoCura) {
        this.metodoCura = metodoCura;
    }

    public Boolean getFumo() {
        return fumo;
    }

    public void setFumo(Boolean fumo) {
        this.fumo = fumo;
    }

    public Integer getQtaGiornalieraSigarettePrimaGravidanza() {
        return qtaGiornalieraSigarettePrimaGravidanza;
    }

    public void setQtaGiornalieraSigarettePrimaGravidanza(Integer qtaGiornalieraSigarettePrimaGravidanza) {
        this.qtaGiornalieraSigarettePrimaGravidanza = qtaGiornalieraSigarettePrimaGravidanza;
    }

    public Integer getQtaGiornalieraSigaretteDuranteGravidanza() {
        return qtaGiornalieraSigaretteDuranteGravidanza;
    }

    public void setQtaGiornalieraSigaretteDuranteGravidanza(Integer qtaGiornalieraSigaretteDuranteGravidanza) {
        this.qtaGiornalieraSigaretteDuranteGravidanza = qtaGiornalieraSigaretteDuranteGravidanza;
    }

    public Boolean getCaffe() {
        return caffe;
    }

    public void setCaffe(Boolean caffe) {
        this.caffe = caffe;
    }

    public Integer getQuantitaCaffeAlGiorno() {
        return quantitaCaffeAlGiorno;
    }

    public void setQuantitaCaffeAlGiorno(Integer quantitaCaffeAlGiorno) {
        this.quantitaCaffeAlGiorno = quantitaCaffeAlGiorno;
    }

    public Boolean getAlcool() {
        return alcool;
    }

    public void setAlcool(Boolean alcool) {
        this.alcool = alcool;
    }

    public Integer getQuantitaAlcoolAlMese() {
        return quantitaAlcoolAlMese;
    }

    public void setQuantitaAlcoolAlMese(Integer quantitaAlcoolAlMese) {
        this.quantitaAlcoolAlMese = quantitaAlcoolAlMese;
    }

    public Boolean getStupefacenti() {
        return stupefacenti;
    }

    public void setStupefacenti(Boolean stupefacenti) {
        this.stupefacenti = stupefacenti;
    }

    public String getAltreOsservazioni() {
        return altreOsservazioni;
    }

    public void setAltreOsservazioni(String altreOsservazioni) {
        this.altreOsservazioni = altreOsservazioni;
    }

    public String getQuantitaStupefacentiAlMese() {
        return quantitaStupefacentiAlMese;
    }

    public void setQuantitaStupefacentiAlMese(String quantitaStupefacentiAlMese) {
        this.quantitaStupefacentiAlMese = quantitaStupefacentiAlMese;
    }

    public String getFarmaciAbituali() {
        return farmaciAbituali;
    }

    public void setFarmaciAbituali(String farmaciAbituali) {
        this.farmaciAbituali = farmaciAbituali;
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
        if (!(object instanceof Abitudinidivita)) {
            return false;
        }
        Abitudinidivita other = (Abitudinidivita) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Abitudinidivita[id=" + id + "]";
    }

}
