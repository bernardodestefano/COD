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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "paziente")
@NamedQueries({
    @NamedQuery(name = "Paziente.findAll", query = "SELECT p FROM Paziente p"),
    @NamedQuery(name = "Paziente.findByCodiceFiscale", query = "SELECT p FROM Paziente p WHERE p.codiceFiscale = :codiceFiscale"),
    @NamedQuery(name = "Paziente.findByCognome", query = "SELECT p FROM Paziente p WHERE p.cognome = :cognome"),
    @NamedQuery(name = "Paziente.findByNome", query = "SELECT p FROM Paziente p WHERE p.nome = :nome"),
    @NamedQuery(name = "Paziente.findByIndirizzo", query = "SELECT p FROM Paziente p WHERE p.indirizzo = :indirizzo"),
    @NamedQuery(name = "Paziente.findByTelefono", query = "SELECT p FROM Paziente p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Paziente.findByLuogoNascita", query = "SELECT p FROM Paziente p WHERE p.luogoNascita = :luogoNascita"),
    @NamedQuery(name = "Paziente.findByDataNascita", query = "SELECT p FROM Paziente p WHERE p.dataNascita = :dataNascita"),
    @NamedQuery(name = "Paziente.findByTitoloStudi", query = "SELECT p FROM Paziente p WHERE p.titoloStudi = :titoloStudi"),
    @NamedQuery(name = "Paziente.findByProfessione", query = "SELECT p FROM Paziente p WHERE p.professione = :professione"),
    @NamedQuery(name = "Paziente.findByStatoCivile", query = "SELECT p FROM Paziente p WHERE p.statoCivile = :statoCivile"),
    @NamedQuery(name = "Paziente.findByDataMatrimonio", query = "SELECT p FROM Paziente p WHERE p.dataMatrimonio = :dataMatrimonio")})
public class Paziente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codiceFiscale")
    private String codiceFiscale;
    @Basic(optional = false)
    @Column(name = "cognome")
    private String cognome;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "indirizzo")
    private String indirizzo;
    @Column(name = "telefono")
    private Integer telefono;
    @Basic(optional = false)
    @Column(name = "luogoNascita")
    private String luogoNascita;
    @Basic(optional = false)
    @Column(name = "dataNascita")
    private String dataNascita;
    @Column(name = "titoloStudi")
    private String titoloStudi;
    @Column(name = "professione")
    private String professione;
    @Basic(optional = false)
    @Column(name = "statoCivile")
    private String statoCivile;
    @Column(name = "dataMatrimonio")
    @Temporal(TemporalType.DATE)
    private Date dataMatrimonio;
    @JoinColumn(name = "datiAutenticazione_username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Datiautenticazione datiautenticazione;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paziente")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Paziente() {
    }

    public Paziente(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Paziente(String codiceFiscale, String cognome, String nome, String luogoNascita, String dataNascita, String statoCivile) {
        this.codiceFiscale = codiceFiscale;
        this.cognome = cognome;
        this.nome = nome;
        this.luogoNascita = luogoNascita;
        this.dataNascita = dataNascita;
        this.statoCivile = statoCivile;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getTitoloStudi() {
        return titoloStudi;
    }

    public void setTitoloStudi(String titoloStudi) {
        this.titoloStudi = titoloStudi;
    }

    public String getProfessione() {
        return professione;
    }

    public void setProfessione(String professione) {
        this.professione = professione;
    }

    public String getStatoCivile() {
        return statoCivile;
    }

    public void setStatoCivile(String statoCivile) {
        this.statoCivile = statoCivile;
    }

    public Date getDataMatrimonio() {
        return dataMatrimonio;
    }

    public void setDataMatrimonio(Date dataMatrimonio) {
        this.dataMatrimonio = dataMatrimonio;
    }

    public Datiautenticazione getDatiautenticazione() {
        return datiautenticazione;
    }

    public void setDatiautenticazione(Datiautenticazione datiautenticazione) {
        this.datiautenticazione = datiautenticazione;
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
        hash += (codiceFiscale != null ? codiceFiscale.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paziente)) {
            return false;
        }
        Paziente other = (Paziente) object;
        if ((this.codiceFiscale == null && other.codiceFiscale != null) || (this.codiceFiscale != null && !this.codiceFiscale.equals(other.codiceFiscale))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Paziente[codiceFiscale=" + codiceFiscale + "]";
    }

     public static final String TIPOSTATOCIVILE_CELIBE ="celibe";
     public static final String TIPOSTATOCIVILE_NUBILE ="nubile";
     public static final String TIPOSTATOCIVILE_CONIUGATA ="coniugata";
}
