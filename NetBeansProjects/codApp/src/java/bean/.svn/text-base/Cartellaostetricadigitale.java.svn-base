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
@Table(name = "cartellaostetricadigitale")
@NamedQueries({
    @NamedQuery(name = "Cartellaostetricadigitale.findAll", query = "SELECT c FROM Cartellaostetricadigitale c"),
    @NamedQuery(name = "Cartellaostetricadigitale.findById", query = "SELECT c FROM Cartellaostetricadigitale c WHERE c.id = :id"),
    @NamedQuery(name = "Cartellaostetricadigitale.findByData", query = "SELECT c FROM Cartellaostetricadigitale c WHERE c.data = :data")})
public class Cartellaostetricadigitale implements Serializable,Comparable<Cartellaostetricadigitale> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "visite_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Visite visite;
    @JoinColumn(name = "visitaOstetrica_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Visitaostetrica visitaostetrica;
    @JoinColumn(name = "storiaPreconcezionale_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Storiapreconcezionale storiapreconcezionale;
    @JoinColumn(name = "storiaOstretricaMadreDellaDonna_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Storiaostretricamadredelladonna storiaostretricamadredelladonna;
    @JoinColumn(name = "storiaOstetrica_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Storiaostetrica storiaostetrica;
    @JoinColumn(name = "storiaMestruale_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Storiamestruale storiamestruale;
    @JoinColumn(name = "storiaGinecologica_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Storiaginecologica storiaginecologica;
    @JoinColumn(name = "AbitudiniDiVita_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Abitudinidivita abitudinidivita;
    @JoinColumn(name = "anamnesiFamiliare_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Anamnesifamiliare anamnesifamiliare;
    @JoinColumn(name = "anamnesiPartner_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Anamnesipartner anamnesipartner;
    @JoinColumn(name = "anamnesiPersonale_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Anamnesipersonale anamnesipersonale;
    @JoinColumn(name = "anticoncezionali_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Anticoncezionali anticoncezionali;
    @JoinColumn(name = "bambino_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bambino bambino;
    @JoinColumn(name = "controlloGravidanza_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Controllogravidanza controllogravidanza;
    @JoinColumn(name = "decorsoDellaGravidanza_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Decorsodellagravidanza decorsodellagravidanza;
    @JoinColumn(name = "dottore_codiceFiscale", referencedColumnName = "codiceFiscale")
    @ManyToOne(optional = false)
    private Dottore dottore;
    @JoinColumn(name = "ecografie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ecografie ecografie;
    @JoinColumn(name = "esameEmatochimici_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Esameematochimici esameematochimici;
    @JoinColumn(name = "esameSierologico_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Esamesierologico esamesierologico;
    @JoinColumn(name = "paziente_codiceFiscale", referencedColumnName = "codiceFiscale")
    @ManyToOne(optional = false)
    private Paziente paziente;

    public Cartellaostetricadigitale() {
    }

    public Cartellaostetricadigitale(Integer id) {
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

    public Visite getVisite() {
        return visite;
    }

    public void setVisite(Visite visite) {
        this.visite = visite;
    }

    public Visitaostetrica getVisitaostetrica() {
        return visitaostetrica;
    }

    public void setVisitaostetrica(Visitaostetrica visitaostetrica) {
        this.visitaostetrica = visitaostetrica;
    }

    public Storiapreconcezionale getStoriapreconcezionale() {
        return storiapreconcezionale;
    }

    public void setStoriapreconcezionale(Storiapreconcezionale storiapreconcezionale) {
        this.storiapreconcezionale = storiapreconcezionale;
    }

    public Storiaostretricamadredelladonna getStoriaostretricamadredelladonna() {
        return storiaostretricamadredelladonna;
    }

    public void setStoriaostretricamadredelladonna(Storiaostretricamadredelladonna storiaostretricamadredelladonna) {
        this.storiaostretricamadredelladonna = storiaostretricamadredelladonna;
    }

    public Storiaostetrica getStoriaostetrica() {
        return storiaostetrica;
    }

    public void setStoriaostetrica(Storiaostetrica storiaostetrica) {
        this.storiaostetrica = storiaostetrica;
    }

    public Storiamestruale getStoriamestruale() {
        return storiamestruale;
    }

    public void setStoriamestruale(Storiamestruale storiamestruale) {
        this.storiamestruale = storiamestruale;
    }

    public Storiaginecologica getStoriaginecologica() {
        return storiaginecologica;
    }

    public void setStoriaginecologica(Storiaginecologica storiaginecologica) {
        this.storiaginecologica = storiaginecologica;
    }

    public Abitudinidivita getAbitudinidivita() {
        return abitudinidivita;
    }

    public void setAbitudinidivita(Abitudinidivita abitudinidivita) {
        this.abitudinidivita = abitudinidivita;
    }

    public Anamnesifamiliare getAnamnesifamiliare() {
        return anamnesifamiliare;
    }

    public void setAnamnesifamiliare(Anamnesifamiliare anamnesifamiliare) {
        this.anamnesifamiliare = anamnesifamiliare;
    }

    public Anamnesipartner getAnamnesipartner() {
        return anamnesipartner;
    }

    public void setAnamnesipartner(Anamnesipartner anamnesipartner) {
        this.anamnesipartner = anamnesipartner;
    }

    public Anamnesipersonale getAnamnesipersonale() {
        return anamnesipersonale;
    }

    public void setAnamnesipersonale(Anamnesipersonale anamnesipersonale) {
        this.anamnesipersonale = anamnesipersonale;
    }

    public Anticoncezionali getAnticoncezionali() {
        return anticoncezionali;
    }

    public void setAnticoncezionali(Anticoncezionali anticoncezionali) {
        this.anticoncezionali = anticoncezionali;
    }

    public Bambino getBambino() {
        return bambino;
    }

    public void setBambino(Bambino bambino) {
        this.bambino = bambino;
    }

    public Controllogravidanza getControllogravidanza() {
        return controllogravidanza;
    }

    public void setControllogravidanza(Controllogravidanza controllogravidanza) {
        this.controllogravidanza = controllogravidanza;
    }

    public Decorsodellagravidanza getDecorsodellagravidanza() {
        return decorsodellagravidanza;
    }

    public void setDecorsodellagravidanza(Decorsodellagravidanza decorsodellagravidanza) {
        this.decorsodellagravidanza = decorsodellagravidanza;
    }

    public Dottore getDottore() {
        return dottore;
    }

    public void setDottore(Dottore dottore) {
        this.dottore = dottore;
    }

    public Ecografie getEcografie() {
        return ecografie;
    }

    public void setEcografie(Ecografie ecografie) {
        this.ecografie = ecografie;
    }

    public Esameematochimici getEsameematochimici() {
        return esameematochimici;
    }

    public void setEsameematochimici(Esameematochimici esameematochimici) {
        this.esameematochimici = esameematochimici;
    }

    public Esamesierologico getEsamesierologico() {
        return esamesierologico;
    }

    public void setEsamesierologico(Esamesierologico esamesierologico) {
        this.esamesierologico = esamesierologico;
    }

    public Paziente getPaziente() {
        return paziente;
    }

    public void setPaziente(Paziente paziente) {
        this.paziente = paziente;
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
        if (!(object instanceof Cartellaostetricadigitale)) {
            return false;
        }
        Cartellaostetricadigitale other = (Cartellaostetricadigitale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Cartellaostetricadigitale[id=" + id + "]";
    }

    @Override
    public int compareTo(Cartellaostetricadigitale o) {
        return this.getData().compareTo(o.getData());
    }


}
