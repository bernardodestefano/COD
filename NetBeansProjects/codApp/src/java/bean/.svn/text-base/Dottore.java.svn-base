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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lodato
 */
@Entity
@Table(name = "dottore")
@NamedQueries({
    @NamedQuery(name = "Dottore.findAll", query = "SELECT d FROM Dottore d"),
    @NamedQuery(name = "Dottore.findByCodiceFiscale", query = "SELECT d FROM Dottore d WHERE d.codiceFiscale = :codiceFiscale"),
    @NamedQuery(name = "Dottore.findByNome", query = "SELECT d FROM Dottore d WHERE d.nome = :nome"),
    @NamedQuery(name = "Dottore.findByCognome", query = "SELECT d FROM Dottore d WHERE d.cognome = :cognome"),
    @NamedQuery(name = "Dottore.findByIndirizzo", query = "SELECT d FROM Dottore d WHERE d.indirizzo = :indirizzo"),
    @NamedQuery(name = "Dottore.findByCellulare", query = "SELECT d FROM Dottore d WHERE d.cellulare = :cellulare"),
    @NamedQuery(name = "Dottore.findByEmail", query = "SELECT d FROM Dottore d WHERE d.email = :email"),
    @NamedQuery(name = "Dottore.findByComune", query = "SELECT d FROM Dottore d WHERE d.comune = :comune"),
    @NamedQuery(name = "Dottore.findByProvincia", query = "SELECT d FROM Dottore d WHERE d.provincia = :provincia")})
public class Dottore implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codiceFiscale")
    private String codiceFiscale;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "indirizzo")
    private String indirizzo;
    @Basic(optional = false)
    @Column(name = "cellulare")
    private String cellulare;
    @Column(name = "email")
    private String email;
    @Column(name = "comune")
    private String comune;
    @Column(name = "provincia")
    private String provincia;
    @JoinColumn(name = "datiAutenticazione_username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Datiautenticazione datiautenticazione;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dottore")
    private List<Cartellaostetricadigitale> cartellaostetricadigitaleList;

    public Dottore() {
    }

    public Dottore(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Dottore(String codiceFiscale, String nome, String cognome, String cellulare) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.cellulare = cellulare;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
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
        if (!(object instanceof Dottore)) {
            return false;
        }
        Dottore other = (Dottore) object;
        if ((this.codiceFiscale == null && other.codiceFiscale != null) || (this.codiceFiscale != null && !this.codiceFiscale.equals(other.codiceFiscale))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Dottore[codiceFiscale=" + codiceFiscale + "]";
    }

}
